/**
 * Copyright XYMOB Inc 2013. All rights reserved.
 */
package com.communityapp.config;

/**
 * A configuration interface that holds constants that used for various business logic
 * for the app.
 *
 * @author Rakesh Saytode : rakesh.saytode@xymob.com
 */
public interface BusinessLogicConfig {

	// GPS related
	public final long GPS_REQUEST_DELTA_THRESHOLD = 1000 * 60 * 15; 				// 15 Mins
	public final long GPS_REQUEST_TIMEOUT_DELAY = 1000 * 20;						// 20 Secs
	public final int  GPS_SIGNIFICANT_DISTANCE_MILES_THRESHOLD = 5;					// 5 Miles
	
	// Tab related
	public final int TAB_HEIGHT_THRESHOLD = 600;
	public final int TAB_HEIGHT_FOR_SMALLER_SCREEN = 60;
	public final int TAB_HEIGHT_FOR_BIGGER_SCREEN = 98;
	
	public final long REFRESH_OFFERS_THRESHOLD = 1000 * 60 * 15; 				// 15 Mins
	public final long REFRESH_ALL_CATEGORY_THRESHOLD = 1000 /** 60 * 60 * 24*/; 	// 24 Hours
	
	// wrong token threshold
	public final int WRONG_TOKEN_THRESHOLD = 5;
	public final int TOKEN_DIGIT_THRESHOLD = 4;
	public final byte MIN_CHAR_IN_ZIPCODE = 2;
	public final byte MAX_CHAR_IN_ZIPCODE = 10;
	
	// set 100 to progress after following msec in splash.
	public final int MAX_PROGRESS_BAR_TIME = 2500;
	
	// Offer types coming from server.
	public final String OFFER_TYPE_ONLINE = "Online";
	public final String OFFER_TYPE_INSTORE = "Instore";
	
	// App update types coming from server.
	public final String APP_UPDATE_TYPE_OPTIONAL = "Optional";
	public final String APP_UPDATE_TYPE_MANDATORY = "Mandatory";
	
	// app config 
	public final long APP_CONFIG_THRESHOLD = 1000 * 60 * 60 * 8;  // 8 hours
	
	public final long APP_BACKGROUND_THRESHOLD = 1000 * 60 * 60 * 12; // 12 hour
	
	/** Constant value 5. */
	public final int DEFAULT_OFFER_PROXIMITY_RADIUS = 5; // in miles
	/** Constant value 60. */
	public final int MAX_OFFER_PROXIMITY_RADIUS_FOR_SLIDER = 60; // in miles
	
	public final long SCANNER_TIMEOUT_DELAY = 1000 * 30;						// 30 seconds
	public final int DEFAULT_BARCODE_MIN_RANGE = 5;
	public final int DEFAULT_BARCODE_MAX_RANGE = 16;
	public final int CODE_RED_ITERATION_COUNT = 1000;
	public final int CODE_RED_OUTPUT_LENGTH = 256;
	
}
