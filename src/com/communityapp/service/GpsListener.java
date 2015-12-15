package com.communityapp.service;

import com.communityapp.config.BusinessLogicConfig;
import com.communityapp.location.GeoUtils;
import com.communityapp.location.LocationHandler;
import com.mycommunityapp.config.PreferenceConfig;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

 
public class GpsListener implements LocationListener {
    private final Context mContext;
    //private RequestManager mRequestManager;
    // flag for GPS status
    boolean isGPSEnabled = false;
 
    // flag for network status
    boolean isNetworkEnabled = false;
 
    // flag for GPS status
    boolean canGetLocation = false;
 
    Location location; // location
    double latitude; // latitude
    double longitude; // longitude
 
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 5; // 5 miles
 
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
 
    // Declaring a Location Manager
    protected LocationManager locationManager;
    public static boolean locationFound=false;
    private Location mLastLocation;
    public GpsListener(Context context) {
        this.mContext = context;
      //  mRequestManager = RequestManager.from(context);
        getLocation();
    }
 
    public Location getLocation() {
        try {
            locationManager = (LocationManager) mContext
                    .getSystemService(Activity.LOCATION_SERVICE);
 
            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
 
            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
 
            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                                locationFound=true;
                            }
                        }
                    }
                }
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (location !=null) {
        	LocationHandler locationHandler = new LocationHandler();
            locationHandler.saveLocation(mContext, location, true);
            String searchModeType=PreferenceConfig.getStoreSearchType(mContext);
//			if(searchModeType.equalsIgnoreCase(PreferenceConstants.STORE_TYPE1)){
//            String uLatitude= Double.toString(latitude);//userJsonObject.getString(JSONTagConstants.USER_LAT);
//			String uLongitude= Double.toString(longitude);//userJsonObject.getString(JSONTagConstants.USER_LON);
//			PreferenceConfig.setHomeLatitude(uLatitude, mContext);
//			PreferenceConfig.setHomeLongitude(uLongitude, mContext);           
//			}
		}
        return location;
    }
     
    /**
     * Stop using GPS listener
     * Calling this function will stop using GPS in your app
     * */
    public void stopUsingGPS(){
        if(locationManager != null){
            locationManager.removeUpdates(GpsListener.this);
        }       
    }
     
    /**
     * Function to get latitude
     * */
    public double getLatitude(){
        if(location != null){
            latitude = location.getLatitude();
        }
         
        // return latitude
        return latitude;
    }
     
    /**
     * Function to get longitude
     * */
    public double getLongitude(){
        if(location != null){
            longitude = location.getLongitude();
        }
         
        // return longitude
        return longitude;
    }
     
    /**
     * Function to check GPS/wifi enabled
     * @return boolean
     * */
    public boolean canGetLocation() {
        return this.canGetLocation;
    }
     
    /**
     * Function to show settings alert dialog
     * On pressing Settings button will lauch Settings Options
     * */
    public void showSettingsAlert(){
    	 AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
         
         // Setting Dialog Title
         alertDialog.setTitle("GPS is settings");
   
         // Setting Dialog Message
         alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
   
         // Setting Icon to Dialog
         //alertDialog.setIcon(R.drawable.delete);
   
         // On pressing Settings button
         alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog,int which) {
                 Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                 mContext.startActivity(intent);
             }
         });
   
         // on pressing cancel button
         alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
             dialog.cancel();
             }
         });
   
         // Showing Alert Message
         alertDialog.show();
    }
 
    @Override
    public void onLocationChanged(Location locatio) {
    	location=locatio;
    	 getLatitude();
    	 getLongitude();
    	final float oneMile = 1609.344f;
		String geoSignificantDistanceStr = PreferenceConfig.getGeoSignificantDistance(mContext);
		float minDistance = TextUtils.isEmpty(geoSignificantDistanceStr)?
				BusinessLogicConfig.GPS_SIGNIFICANT_DISTANCE_MILES_THRESHOLD 
				: Integer.parseInt(geoSignificantDistanceStr); // in miles
		minDistance = minDistance * oneMile;  // in meters
		Location mLastKnowLocation = GeoUtils.getLastBestLocation(mContext, (int) minDistance, 
				System.currentTimeMillis() - AlarmManager.INTERVAL_FIFTEEN_MINUTES);
    	if (PreferenceConfig.isFirstTimeGL(mContext) || !GeoUtils.isLocationDistanceCriteriaIsValid(location, mLastKnowLocation, minDistance)) {
//			LogConfig.logv(LOG_TAG, "locationUpdated(): Distance criteria voilated");
			// call location trigger.
			//triggerLocationUpdateWS();
			PreferenceConfig.setFirstTimeGL(false, mContext);
		} else {
			// location distance is under the criteria, no need to generate location trigger.
			// DO NOTHING
//			LogConfig.logv(LOG_TAG, "locationUpdated(): location is under distance criteria");
		}
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
 
    /** Method to call location trigger network request. */
//	private void triggerLocationUpdateWS() {
////		LogConfig.logv(LOG_TAG, "triggerLocationUpdateWS()");
//		Bundle params = new Bundle();
//		params.putByte(TriggerConstants.KEY_NAME_BUNDLE_TRIGGER_WORKER_MODE,
//				TriggerConstants.WORKER_MODE_TRIGGER_GEO_LOCATION);
//		mRequestManager.triggerEvent(DownloadFormat.RETURN_FORMAT_JSON, params);
//	}
}