/**
 * Copyright XYMOB Inc 2013. All rights reserved.
 */
package com.communityapp.location;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;



/**
 * An Utility class for location data handling.
 * @author Rakesh Saytode (rakesh.saytode@xymob.com)
 *
 */
public class GeoUtils {
	
	/**
     * To be used if you just want a one-shot best last location, iterates over
     * all providers and returns the most accurate result.
     */
    public static Location getBestLastGeolocation(Context context) {
        LocationManager manager = (LocationManager)context.getSystemService(
                Context.LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();
         
        Location bestLocation = null;
        for (String it : providers) {
            Location location = manager.getLastKnownLocation(it);
            if (location != null) {
                if (bestLocation == null || 
                        location.getAccuracy() < bestLocation.getAccuracy()) {
                    bestLocation = location;
                }
            }
        }
        return bestLocation;
    }
    
    /** Check the LocationProvider ON/OFF status. */
    public static boolean isGpsLocationProviderEnabled(Context context) {
    	boolean isEnabled = false;
    	LocationManager manager = (LocationManager)context.getSystemService(
                Context.LOCATION_SERVICE);
        List<String> providersList = manager.getAllProviders();
         
        for (String provider : providersList) {
            if (provider.equalsIgnoreCase(LocationManager.GPS_PROVIDER)) {
            	isEnabled = manager.isProviderEnabled(provider);
            	break;
            }
        }
		return isEnabled;
    }
		 
    /** Check the distance <code>miles</code> criteria between two {@link Location} objects. 
     * <p>Note: 1 Miles = 1609.344 m, 1 Miles = 1.609 km*/ 
    public static boolean isLocationDistanceCriteriaIsValid(Location firstLocation,
    		Location secondLocation, float miles) {
    	final float oneMile = 1609.344f;
    	float results [] = new float[2];
		
		try {
			// Calculate the distance
			Location.distanceBetween(firstLocation.getLatitude(), firstLocation.getLongitude(),
					secondLocation.getLatitude(), secondLocation.getLongitude(), results);
			
			// If distance criteria fulfilled return true or else false.
			return (results[0] < (oneMile * miles));
		} catch (Exception e) {	/* If location is invalid or null, we do nothing. */}
		return false;
    }
    
    /** Check the distance <code>miles</code> criteria between two {@link Location} objects. 
     * <p>Note: 1 Miles = 1609.344 m, 1 Miles = 1.609 km*/ 
    public static boolean isLocationDistanceCriteriaIsValid(double[] newLocation,
    		double[] oldLocation, float miles) {
    	final float oneMile = 1609.344f;
    	float results [] = new float[2];
		
		try {
			// Calculate the distance
			Location.distanceBetween(newLocation[LocationHandler.LATTITUDE],
					newLocation[LocationHandler.LONGITUDE], oldLocation[LocationHandler.LATTITUDE],
					oldLocation[LocationHandler.LONGITUDE], results);
			
			// If distance criteria fulfilled return true or else false.
			return (results[0] < (oneMile * miles));
		} catch (Exception e) {	/* If location is invalid or null, we do nothing. */}
		return false;
    }
    
	/**
	 * Method to get last best known location if last known location is valid or not in terms of
	 * distance and accuracy.
	 * 
	 * @param minDistance Minimum distance before we require a location update.
	 * @param minTime Minimum time required between location updates.
	 * @return The validity of last known location.
	 */
	public static Location getLastBestLocation(Context context, int minDistance, long minTime) {
		//LogConfig.logv("GeoUtils", "isLastLocationValid()");
		Location bestLocation = null;
		float bestAccuracy = Float.MAX_VALUE;
		long bestTime = Long.MIN_VALUE;

		LocationManager locationManager = (LocationManager) 
			context.getSystemService(Context.LOCATION_SERVICE);

		// Iterate through all the providers on the system, keeping
		// note of the most accurate result within the acceptable time limit.
		// If no result is found within maxTime, return the newest Location.
		List<String> matchingProviders = locationManager.getAllProviders();
		for (String provider : matchingProviders) {
			Location location = locationManager.getLastKnownLocation(provider);
			if (location != null) {
				float accuracy = location.getAccuracy();
				long time = location.getTime();

				if ((time > minTime && accuracy < bestAccuracy)) {
					bestLocation = location;
					bestAccuracy = accuracy;
					bestTime = time;
				} else if (time < minTime && bestAccuracy == Float.MAX_VALUE
						&& time > bestTime) {
					bestLocation = location;
					bestTime = time;
				}
			}
		}
		// If the best result is beyond the allowed time limit, or the accuracy
		// of the best result is wider than the acceptable maximum distance, need
		// location update so return null.
		if (bestTime < minTime || bestAccuracy > minDistance) {
		//	LogConfig.logv("GeoUtils", "isLastLocationValid(): Need fresh loc update");
			return null;
		}
	//	LogConfig.logv("GeoUtils", "isLastLocationValid(): Last location is valid.");
		return bestLocation;
	}
}



