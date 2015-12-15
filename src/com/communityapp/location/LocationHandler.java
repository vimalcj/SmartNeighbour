/**
 * Copyright XYMOB Inc 2013. All rights reserved.
 */
package com.communityapp.location;

import java.util.Date;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import com.communityapp.config.BusinessLogicConfig;
import com.mycommunityapp.R;
import com.mycommunityapp.config.PreferenceConfig;
import com.mycommunityapp.config.PreferenceConfig.PreferenceConstants;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.Preference;
import android.text.TextUtils;



/**
 * A location handler class that fetch the latest GPS location of the device and 
 * persist the same for further use throughout the app.
 * @author Rakesh Saytode (rakesh.saytode@xymob.com)
 *
 */
public class LocationHandler extends Observable implements LocationListener {
	@SuppressWarnings("unused")
	private static final String TAG = "LocationHandler";
	
	public static final int LOCATION_PROVIDER_ENABLED = 0;
	public static final int LOCATION_PROVIDER_DISABLED = -1;
	
	public static final int LATTITUDE = 0;
	public static final int LONGITUDE = 1;
	
	public static final String LOCATION_RESULT_INVALID = "invalid";
	public static final String LOCATION_RESULT_TIMEOUT = "timeout";
	
	private static Context mContext;
	
	private Timer mGpsTimeoutTimer;
	//private RequestManager mRequestManager;
	private Location mLastLocation;

	public interface LocationRequester {
		public final byte LOCAL = 0;
		public final byte LOCAL_SPONSORED = 1;
		public final byte LOCATE_STORES = 2;
		public final byte BUSINESS_SEARCH = 3;
		public final byte SEARCH_BRANDS = 4;
	}
	
	public LocationHandler() {
		super();
	}
	
	@Override
	public void onLocationChanged(Location location) {
		updateLocation(location);		
	}

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	/** Update the location. See {@link Location}
	 * @param location new location.
	 */
	public void updateLocation(Location location) {
		String geoSignificantDistanceStr = PreferenceConfig.getGeoSignificantDistance(mContext);
		float minDistance = TextUtils.isEmpty(geoSignificantDistanceStr)?
				BusinessLogicConfig.GPS_SIGNIFICANT_DISTANCE_MILES_THRESHOLD 
				: Integer.parseInt(geoSignificantDistanceStr); // in miles
		if (PreferenceConfig.isFirstTimeGL(mContext) || !GeoUtils.isLocationDistanceCriteriaIsValid(location, mLastLocation, minDistance)) {
//			LogConfig.logv(LOG_TAG, "locationUpdated(): Distance criteria voilated");
			// call location trigger.
		//	triggerLocationUpdateWS();
			PreferenceConfig.setFirstTimeGL(false, mContext);
		} else {
			// location distance is under the criteria, no need to generate location trigger.
			// DO NOTHING
//			LogConfig.logv(LOG_TAG, "locationUpdated(): location is under distance criteria");
		}
		
		if (location != null) {
			setGpsLocationFixTimestamp(mContext, System.currentTimeMillis());
			saveLocation(mContext, location, true);
			setChanged();
	        notifyObservers(location);
		} else {
			setChanged();
	        notifyObservers(LOCATION_RESULT_INVALID);
		}
    }
	
	/** Register and start for location updates. Also see {@link LocationManager}*/
	public int register(Context context, LocationManager locationManager) {
		mContext = context;
		// check the distance criteria between old and new location.
					// If distance is more than the criteria then call a location trigger.
	//	mRequestManager = RequestManager.from(context);
		Criteria criteria = new Criteria();
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_HIGH);
		String bestProvider = locationManager.getBestProvider(criteria, true);
		startGpsTimeoutListener(locationManager);
		if (bestProvider != null) {
			locationManager.requestLocationUpdates(bestProvider, 0, 0, this);
			return LOCATION_PROVIDER_ENABLED;	
		}
		return LOCATION_PROVIDER_DISABLED;
	}
	
	/** Un-register the location update listener. Also see {@link LocationManager}*/
	public void unregister(LocationManager locationManager) {
        locationManager.removeUpdates(this);
        stopGpsTimeoutListener();
    }
	
	/** Start the GPS timeout listener, Will activate after specified delay to cancel the
	 * location updates. */
	private void startGpsTimeoutListener(LocationManager locationManager) {
		mGpsTimeoutTimer = new Timer();
		mGpsTimeoutTimer.schedule(new GpsTimeoutListener(this, locationManager),
				BusinessLogicConfig.GPS_REQUEST_TIMEOUT_DELAY);
	}
	
	/** Stop the GPS timeout listener, user might cancelled the GPS request. */
	public void stopGpsTimeoutListener() {
		if (mGpsTimeoutTimer != null) {
			mGpsTimeoutTimer.cancel();
			mGpsTimeoutTimer = null;
		}
	}
	
	/** Get the last known location. See {@link Location}*/
	synchronized public Location getLastKnownLocation() {
        return mLastLocation;
    }
	
	/** Reset last known location. See {@link Location}*/
	synchronized public void clearLastKnownLocation() {
        mLastLocation = null;
    }
	
	/** Determines whether one Location reading is better than the current Location fix. See {@link Location}
	  * @param location  The new Location that you want to evaluate
	  * @param currentBestLocation  The current Location fix, to which you want to compare the new one
	  */
	protected boolean isBetterLocation(Location location, Location currentBestLocation) {
	    if (currentBestLocation == null) {
	        // A new location is always better than no location
	        return true;
	    }

	    // Check whether the new location fix is newer or older
	    long timeDelta = location.getTime() - currentBestLocation.getTime();
	    boolean isSignificantlyNewer = timeDelta > BusinessLogicConfig.GPS_REQUEST_DELTA_THRESHOLD;
	    boolean isSignificantlyOlder = timeDelta < -BusinessLogicConfig.GPS_REQUEST_DELTA_THRESHOLD;
	    boolean isNewer = timeDelta > 0;

	    // If it's been more than ten minutes since the current location, use the new location
	    // because the user has likely moved
	    if (isSignificantlyNewer) {
	        return true;
	    // If the new location is more than ten minutes older, it must be worse
	    } else if (isSignificantlyOlder) {
	        return false;
	    }

	    // Check whether the new location fix is more or less accurate
	    int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation.getAccuracy());
	    boolean isLessAccurate = accuracyDelta > 0;
	    boolean isMoreAccurate = accuracyDelta < 0;
	    boolean isSignificantlyLessAccurate = accuracyDelta > 200;

	    // Check if the old and new location are from the same provider
	    boolean isFromSameProvider = isSameProvider(location.getProvider(),
	            currentBestLocation.getProvider());

	    // Determine location quality using a combination of timeliness and accuracy
	    if (isMoreAccurate) {
	        return true;
	    } else if (isNewer && !isLessAccurate) {
	        return true;
	    } else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
	        return true;
	    }
	    return false;
	}

	/** Checks whether two providers are the same */
	private boolean isSameProvider(String provider1, String provider2) {
	    if (provider1 == null) {
	      return provider2 == null;
	    }
	    return provider1.equals(provider2);
	}
	
	/** Check if the current best location is older enough with comparing minutes. See {@link Location}
	 * @param currentBestLocation Current best location.
	 * @param inMinute Location is older if this much minutes have passed from last location update.
	 * @return True, if older or else False.
	 */
	public boolean isLastLocationOlder(Location currentBestLocation, final long inMinute) {
		if (currentBestLocation == null) {
			return true;
		}
		long timeDelta = new Date().getTime() - currentBestLocation.getTime();
		return timeDelta > inMinute;
	}
	
    
    /** Save the location access permission status in preferences. See {@link Location}, {@link Preference}. */
	public void setGpsLocationPermissionStatus(Context context, final boolean isGpsPermitted) {
		SharedPreferences prefs = PreferenceConfig.getInstance(context);
		prefs.edit().putBoolean(PreferenceConstants.GPS_ACCESS_PERMISSION, isGpsPermitted).commit();
	}
	
	/** Get the location access permission status from preferences. See {@link Location}, {@link Preference}. */
	public boolean getGpsLocationPermissionStatus(Context context) {
		SharedPreferences prefs = PreferenceConfig.getInstance(context);
		return prefs.getBoolean(PreferenceConstants.GPS_ACCESS_PERMISSION, false);
	}
	
	/** Save the gps location fix time-stamp in preferences. See {@link Location}, {@link Preference}. */
	public void setGpsLocationFixTimestamp(Context context, final long inTimestampMillis) {
		SharedPreferences prefs = PreferenceConfig.getInstance(context);
		prefs.edit().putLong(PreferenceConstants.GPS_FIX_TIMESTAMP, inTimestampMillis).commit();
	}
	
	/** Get the gps location fix time-stamp in preferences. See {@link Location}, {@link Preference}. */
	public long getGpsLocationFixTimestamp(Context context) {
		SharedPreferences prefs = PreferenceConfig.getInstance(context);
		return prefs.getLong(PreferenceConstants.GPS_FIX_TIMESTAMP, 0);
	}
	
	public static void saveLocation(Context context, final Location location, final boolean isNewLocation) {
		SharedPreferences prefs = PreferenceConfig.getInstance(context);
		SharedPreferences.Editor editor = prefs.edit();
		if (isNewLocation) {
			editor.putString(PreferenceConstants.GPS_NEW_LATTITUDE, location.getLatitude() + "0");
			editor.putString(PreferenceConstants.GPS_NEW_LONGITUDE, location.getLongitude() + "0");
		} else {
			editor.putString(PreferenceConstants.GPS_OLD_LATTITUDE, location.getLatitude() + "0");
			editor.putString(PreferenceConstants.GPS_OLD_LONGITUDE, location.getLongitude() + "0");
		}
		editor.commit();
	}
	
	public static Location getSavedLocation(Context context, final boolean isReadingNewLocation) {
		SharedPreferences prefs = PreferenceConfig.getInstance(context);
		Location location = new Location(
				context.getResources().getString(R.string.app_name));
		if (isReadingNewLocation) {
			location.setLatitude(Double.parseDouble(prefs.getString(PreferenceConstants.GPS_NEW_LATTITUDE, "0")));
			location.setLongitude(Double.parseDouble(prefs.getString(PreferenceConstants.GPS_NEW_LONGITUDE, "0")));
		} else {
			location.setLatitude(Double.parseDouble(prefs.getString(PreferenceConstants.GPS_OLD_LATTITUDE, "0")));
			location.setLongitude(Double.parseDouble(prefs.getString(PreferenceConstants.GPS_OLD_LONGITUDE, "0")));
		}
		return location;
	}
	
	public static double[] getSavedLocation(final boolean isReadingNewLocation, Context context) {
		SharedPreferences prefs = PreferenceConfig.getInstance(context);
		double[] locationData = new double[2];
		if (isReadingNewLocation) {
			locationData[LATTITUDE] = Double.parseDouble(prefs.getString(PreferenceConstants.GPS_NEW_LATTITUDE, "0"));
			locationData[LONGITUDE] = Double.parseDouble(prefs.getString(PreferenceConstants.GPS_NEW_LONGITUDE, "0"));
		} else {
			locationData[LATTITUDE] = Double.parseDouble(prefs.getString(PreferenceConstants.GPS_OLD_LATTITUDE, "0"));
			locationData[LONGITUDE] = Double.parseDouble(prefs.getString(PreferenceConstants.GPS_OLD_LONGITUDE, "0"));
		}
		return locationData;
	}
	
	public boolean isLocationTimestampExpired(Context context) {
		return ((System.currentTimeMillis() - getGpsLocationFixTimestamp(context))
					> BusinessLogicConfig.GPS_REQUEST_DELTA_THRESHOLD);
	}
	
	/**
	 * Timeout listener for GPS request, It unregisters the GPS update request and notify the
	 * location observers.
	 * @author Rakesh Saytode (rakesh.saytode@xymob.com)
	 *
	 */
	private class GpsTimeoutListener extends TimerTask {
		
		private LocationHandler mLocationHandler;
		private LocationManager mLocationManager;
		
		GpsTimeoutListener(LocationHandler locationHandler, LocationManager locationManager) {
			mLocationHandler = locationHandler;
			mLocationManager = locationManager;
		}
		
		@Override
		public void run() {
			mLocationHandler.unregister(mLocationManager);
			mLocationHandler.setChanged();
			mLocationHandler.notifyObservers(LocationHandler.LOCATION_RESULT_TIMEOUT);
		}
	}
	
//	/** Method to call location trigger network request. */
//	private void triggerLocationUpdateWS() {
////		LogConfig.logv(LOG_TAG, "triggerLocationUpdateWS()");
//		Bundle params = new Bundle();
//		params.putByte(TriggerConstants.KEY_NAME_BUNDLE_TRIGGER_WORKER_MODE,
//				TriggerConstants.WORKER_MODE_TRIGGER_GEO_LOCATION);
//		mRequestManager.triggerEvent(DownloadFormat.RETURN_FORMAT_JSON, params);
//	}
}


