/**
 * Copyright 2013 XYMOB Inc. All rights reserved.
 */
package com.mycommunityapp.config;

import com.mycommunityapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;

//import com.manthansystems.loyalty.R;
//import com.manthansystems.loyalty.ui.OffersFragment.OfferNotificationType;
//import com.manthansystems.loyalty.worker.BaseWorker.DownloadMode;
//import com.manthansystems.loyalty.worker.LoyaltyCardWorker.LoyaltyCardWorkerMode;

/**
 * A configuration class that holds the preference related constants and keys.
 * 
 * @author Rakesh Saytode (rakesh.saytode@xymob.com)
 * 
 */
public class PreferenceConfig {

	/**
	 * An interface to hold the constants used for preference data storing.
	 * 
	 * @author Rakesh Saytode : rakesh.saytode@xymob.com
	 * 
	 */
	public interface PreferenceConstants {
		// GPS related
		public final String GPS_ACCESS_PERMISSION = "gpsPermissionFlag";
		public final String GPS_FIX_TIMESTAMP = "gpsTimeStamp";
		public final String GPS_OLD_LATTITUDE = "gps_old_lat";
		public final String GPS_OLD_LONGITUDE = "gps_old_long";
		public final String GPS_NEW_LATTITUDE = "lat";
		public final String GPS_NEW_LONGITUDE = "lon";

		// Zip related
		public final String USER_ENTERED_ZIPCODE = "user_entered_zip";
		public final String HOME_ZIPCODE = "home_zipcode";

		// User credentials
		public final String SESSION_ID = "SESSION_ID";
		public final String LOGIN_TOKEN = "LOGIN_TOKEN";
		public final String USER_EMAIL_ADDRESS = "USER_EMAIL_ADDRESS";
		public final String USER_PUSH_TOKEN = "USER_PUSH_TOKEN";
		public final String USERNAME = "USERNAME";// phone no or email
		public final String PASSWORD = "PASSWORD";
		public final String CONFIRMPASSWORD = "CONFIRMPASSWORD";
		public final String NAME = "NAME";
		public final String LASTNAME = "LASTNAME";
		public final String PHONE_NO = "PHONE_NO";
		public final String DOB = "DOB";
		public final String GENTYPE = "GENTYPE";
		public final String BLOCKNO = "BLOCKNO";
		public final String FLATNO = "FLATNO";
		public final String TOWER = "TOWER";
		public final String FLOORNO = "FLOORNO";
		public final String RESTYPE = "RESTYPE";
		//public final String REGISTRATION_FLAG = "RESTYPE";
		public final String USER_LOGOUT = "USER_LOGOUT";
		public final String FILEPATH = "FILEPATH";
		public final String JOINSTATUS = "JOINSTATUS";
		public final String MYACCOUNT_FLAG = "MYACCOUNT_FLAG";
		public final String VEHICLE_FLAG = "VEHICLE_FLAG";

		// GCM related
		public final String GCM_ALERT_TITLE = "GCM_ALERT_TITLE";
		public final String GCM_PRODUCT_TYPE = "GCM_PRODUCT_TYPE";
		public final String GCM_PRODUCT_ID = "GCM_PRODUCT_ID";
		public final String IS_FROM_GCM = "IS_FROM_GCM";

		// Timestamps
		public final String TIME_STAMP_REFRESH_COMMON_OFFERS = "TIME_STAMP_REFRESH_COMMON_OFFERS";
		public final String TIME_STAMP_REFRESH_PERSONAL_OFFERS = "TIME_STAMP_REFRESH_PERSONAL_OFFERS";
		public final String TIME_STAMP_REFRESH_ALL_CATEGORIES = "TIME_STAMP_REFRESH_ALL_CATEGORIES";
		public final String TIME_STAMP_REFRESH_MARKETING_OFFERS = "TIME_STAMP_REFRESH_MARKETING_OFFERS";

		// Flags
		public final String FLAG_SHOW_GPS_ACCESS_PERMISSION_DIALOG = "FLAG_SHOW_GPS_ACCESS_PERMISSION_DIALOG";
		public final String FLAG_VALID_APP_USER = "FLAG_VALID_APP_USER";
		public final String FLAG_FIRST_FAVORITE_OFFERS_SYNC_STATUS = "FLAG_FIRST_FAVORITE_OFFERS_SYNC_STATUS";
		public final String FLAG_APP_CONFIG_DOWNLOAD_STATUS = "FLAG_APP_CONFIG_DOWNLOAD_STATUS";
		public final String FLAG_IS_APP_SUPPORT_REDEMPTION = "FLAG_IS_APP_SUPPORT_REDEMPTION";

		// user registration
		public final String EMAIL_SCREEN_SHOWN = "EMAIL_SCREEN_SHOWN";
		public final String HOME_ZIPCODE_SCREEN_SHOWN = "HOME_ZIPCODE_SCREEN_SHOWN";
		public final String SHOW_CATEGORY = "SHOW_CATEGORY";
		public final String SET_NOTIFICATION = "SET_NOTIFICATION";
		public final String EMAIL_SCREEN_VISIBLE = "EMAIL_SCREEN_VISIBLE";
		public final String TOKEN_SCREEN_VISIBLE = "TOKEN_SCREEN_VISIBLE";
		public final String HOMEZIP_SCREEN_VISIBLE = "HOMEZIP_SCREEN_VISIBLE";
		public final String HOME_SCREEN_CLICK = "HOME_SCREEN_CLICK";
		public final String USER_LATI = "USER_LATI";
		public final String USER_LONG = "USER_LONG";
		

		// location for zipcode
		public final String LAT_FOR_ZIPCODE = "LAT_FOR_ZIPCODE";
		public final String LON_FOR_ZIPCODE = "LON_FOR_ZIPCODE";
		public final String TIME_STAMP_APP_BACKGROUND = "TIME_STAMP_APP_BACKGROUND";
		public final String OFFERS_PROXIMITY_RADIUS = "OFFERS_PROXIMITY_RADIUS";
		public final String OFFERS_NOTIFICATION_PROXIMITY_RADIUS = "OFFERS_NOTIFICATION_PROXIMITY_RADIUS";
		public final String ADMIN_OFFERS_PROXIMITY_RADIUS = "ADMIN_OFFERS_PROXIMITY_RADIUS";

		// offer count
		public final String PERSONAL_OFFER_COUNT = "PERSONAL_OFFER_COUNT";
		public final String COMMON_OFFER_COUNT = "COMMON_OFFER_COUNT";
		public final String FAVORITE_OFFER_COUNT = "FAVORITE_OFFER_COUNT";
		public final String STORE_LOCATOR_COUNT = "STORE_LOCATOR_COUNT";
		public final String MARKETING_MSG_COUNT = "MARKETING_MSG_COUNT";

		// marketing message config flag
		public final String MARKETING_MESSAGE_LINK_ENABLE_IN_APP = "MARKETING_MESSAGE_LINK_ENABLE_IN_APP";

		// Notification
		public final String IS_LAUNCH_FROM_NOTIFICATION = "IS_LAUNCH_FROM_NOTIFICATION";
		public final String LAUNCH_SCREEN_FROM_NOTIFICATION = "LAUNCH_SCREEN_FROM_NOTIFICATION";
		public final String APP_IS_RUNNING = "APP_IS_RUNNING";

		// category filter
		public final String CATEGORY_FILTER_ID_LIST = "CATEGORY_FILTER_ID_LIST";
		public final String COMING_FROM_OFFER = "COMING_FROM_OFFER";
		public final String ALL_CATEGORY_IS_SELECTED = "ALL_CATEGORY_IS_SELECTED";
		public final String EXPAND_CATEGORY_FILTER_ID_LIST = "EXPAND_CATEGORY_FILTER_ID_LIST";
		public final String CATEGORY_FILTER_ID_LIST_PREFERENCE = "CATEGORY_FILTER_ID_LIST_PREFERENCE";

		// Others
		public final String APP_START_TIME = "app_start_time";
		public final String APP_VERSION_CODE = "APP_VERSION_CODE";
		public final String OFFER_DOWNLOAD_MODE = "OFFER_DOWNLOAD_MODE";
		public final String OFFER_DOWNLOAD_MODE_HOME = "OFFER_DOWNLOAD_MODE_HOME";
		public final String OFFER_REFRESH_INTERVAL = "OFFER_REFRESH_INTERVAL";
		public final String GEO_SIGNIFICANT_DISTANCE = "GEO_SIGNIFICANT_DISTANCE";
		public final String ACTIVE_TRIGGERS_LIST = "ACTIVE_TRIGGERS_LIST";
		public final String GEO_SIGNIFICANT_FREQUENCY = "GEO_SIGNIFICANT_FREQUENCY";
		public final String APP_UPDATE_AVAILABLE = "APP_UPDATE_AVAILABLE";
		public final String APP_UPDATE_CHECKED = "APP_UPDATE_CHECKED";
		public final String APP_UPDATE_MESSAGE = "APP_UPDATE_MESSAGE";
		public final String APP_UPDATE_TYPE = "APP_UPDATE_TYPE";
		public final String APP_VERSION_SET = "APP_VERSION_SET";
		public final String APP_VERSION_NAME = "APP_VERSION_NAME";
		public final String EARLIER_APP_VERSION_CODE = "EARLIER_APP_VERSION_CODE";
		public final String EARLIER_APP_VERSION_NAME = "EARLIER_APP_VERSION_NAME";

		// Loyalty card
		public final String LOYALTY_CARD_USER_EMAIL = "LOYALTY_CARD_USER_EMAIL";
		public final String LOYALTY_CARD_FIRST_NAME = "LOYALTY_CARD_FIRST_NAME";
		public final String LOYALTY_CARD_IMAGE_URL = "LOYALTY_CARD_IMAGE_URL";
		public final String LOYALTY_CARD_TOTAL_REWARDS_DAY = "LOYALTY_CARD_TOTAL_REWARDS_DAY";
		public final String LOYALTY_CARD_TOTAL_REWARDS = "LOYALTY_CARD_TOTAL_REWARDS";
		public final String LOYALTY_CARD_EXPIRY_DAYS = "LOYALTY_CARD_EXPIRY_DAYS";
		public final String LOYALTY_CARD_EXPIRY_REWARDS = "LOYALTY_CARD_EXPIRY_REWARDS";
		public final String LOYALTY_CARD_TRANSACTION_ID = "LOYALTY_CARD_TRANSACTION_ID";
		public final String LOYALTY_CARD_DATE = "LOYALTY_CARD_DATE";
		public final String LOYALTY_CARD_REWARDS = "LOYALTY_CARD_REWARDS";
		public final String LOYALTY_CARD_HISTORY_COUNT = "LOYALTY_CARD_HISTORY_COUNT";
		public final String LOYALTY_CARD_CREATED = "LOYALTY_CARD_CREATED";
		public final String LOYALTY_CARD_NUMBER = "LOYALTY_CARD_NUMBER";
		public final String LOYALTY_CARD_WORKER_MODE = "LOYALTY_CARD_WORKER_MODE";
		public final String LOYALTY_CARD_IMAGE_PATH = "LOYALTY_CARD_IMAGE_PATH";
		public final String LOYALTY_CARD_LAUNCH_DETAIL_SCREEN = "LOYALTY_CARD_LAUNCH_DETAIL_SCREEN";
		public final String FLAG_APP_CONFIG_EXPIRED = "FLAG_APP_CONFIG_EXPIRED";
		public final String FLAG_FIRST_LAUNCH_LOYALTY_CARD = "FLAG_FIRST_LAUNCH_LOYALTY_CARD";

		public final String COLOR_CODE = "COLOR_CODE";
		public final String MARKETING_MESSAGE_IMAGE_URL = "MARKETING_MESSAGE_IMAGE_URL";
		public final String BARCODE_TYPE = "BARCODE_TYPE";
		public final String BARCODE_MIN_RANGE = "BARCODE_MIN_RANGE";
		public final String BARCODE_MAX_RANGE = "BARCODE_MAX_RANGE";
		public final String CODE_RED = "CODE_RED";
		public final String CODE_RED_IVECTOR = "CODE_RED_IVECTOR";
		public final String CODE_RED_PASSWD = "CODE_RED_PASS";
		public final String SEARCH_COLUMN = "SEARCH_COLUMN";
		public final String LMS_INTEGRATED = "LMS_INTEGRATED";
		public final String TOPBARCOLOR_CODE = "TOPBARCOLOR_CODE";
		// public final String URL_GET_ALL_CATEGORIES =
		// "URL_GET_ALL_CATEGORIES";

		public final String CONFIG_OFFER_LIST = "CONFIG_OFFER_LIST";
		public final String DEFAULT_GPS_STATUS = "DEFAULT_GPS_STATUS";
		public final String NEW_GPS_STATUS = "NEW_GPS_STATUS";
		public final String ZIP = "zip";
		public final String HOME_PAGE_CONFIG_STATUS = "HOME_PAGE_CONFIG_STATUS";
		public final String HOME_ICON = "HOME_ICON";
		public final String FIRST_TIME_ACCESS = "FIRST_TIME_ACCESS";
		public final String FIRST_TIME_ACCESS_FILTER = "FIRST_TIME_ACCESS_FILTER";
		public final String LOAD_FILTER_FIRST = "LOAD_FILTER_FIRST";

		// Store Related
		public final String STORE_SEARCH_TYPE = "STORE_SEARCH_TYPE";
		public final String PREVIOUS_STORE_SEARCH_TYPE = "PREVIOUS_STORE_SEARCH_TYPE";
		public final String FIRST_TIME_CLICKED = "FIRST_TIME_CLICKED";

		public final String COMING_FROM_STORE = "COMING_FROM_STORE";
		public final String COMING_FROM_OFFER1 = "COMING_FROM_OFFER1";
		public final String STORE_TYPE1 = "gps";
		public final String STORE_TYPE2 = "uzip";
		public final String STORE_TYPE3 = "hzip";
		public final String STORE_TAB_NAME = "STORE_TAB_NAME";
		// public final String LOCATIO_HOME_LATI = "LOCATIO_HOME_LATI";
		// public final String LOCATIO_HOME_LONG = "LOCATIO_HOME_LONG";
		public final String LOCATIO_ZIP_LATI = "LOCATIO_ZIP_LATI";
		public final String LOCATIO_ZIP_LONG = "LOCATIO_ZIP_LONG";

		public final String SHOW_TURN_ON = "SHOW_TURN_ON";

		// Flurry Analysis
		public final String FLURRY_USERID = "FLURRY_USERID";
		public final String PIWIK_USERID = "PIWIK_USERID";

		public final String SHOW_SPLASH_SCREEN = "SHOW_SPLASH_SCREEN";
		public final String COMING_FROM_SCREEN = "COMING_FROM_SCREEN";

		public final String FIRST_TIME_GL = "FIRST_TIME_GL";

		public final String COMING_FROM_MARKETINGMSG = "COMING_FROM_MARKETINGMSG";
		public final String S3_BUCKET_CATEGORIES_FILE_NAME = "S3_BUCKET_CATEGORIES_FILE_NAME";
		public final String ALL_CATEGORIES_S3_URL = "ALL_CATEGORIES_S3_URL";
	}

	/**
	 * Call this method to get the singleton instance of
	 * {@link PreferenceConfig} class object.
	 */
	public static SharedPreferences getInstance(Context context) {
		return context.getSharedPreferences(
				context.getResources().getString(R.string.app_name), 0);
	}

	/** Call to get the username of user. */
	public static String getUserName(Context context) {
		return getInstance(context).getString(PreferenceConstants.USERNAME, "");
	}

	/** Call to set the user name of user. */
	public static void setUserName(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.USERNAME, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getPassword(Context context) {
		return getInstance(context).getString(PreferenceConstants.PASSWORD, "");
	}

	/** Call to set the pswd of user. */
	public static void setPassword(String password, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.PASSWORD, password).commit();
	}

	/** Call to get the confirm pswd of user. */
	public static String getConfirmPassword(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.CONFIRMPASSWORD, "");
	}

	/** Call to set the confrm pswd of user. */
	public static void setConfirmPassword(String password, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.CONFIRMPASSWORD, password)
				.commit();
	}

	/** Call to set the user name of user. */
	public static void setName(String name, Context context) {
		getInstance(context).edit().putString(PreferenceConstants.NAME, name)
				.commit();
	}

	/** Call to get the pswd of user. */
	public static String getName(Context context) {
		return getInstance(context).getString(PreferenceConstants.NAME, "");
	}
	
	/** Call to set the user name of user. */
	public static void setLastName(String name, Context context) {
		getInstance(context).edit().putString(PreferenceConstants.LASTNAME, name)
				.commit();
	}

	/** Call to get the pswd of user. */
	public static String getLastName(Context context) {
		return getInstance(context).getString(PreferenceConstants.LASTNAME, "");
	}

	/** Call to set the user name of user. */
	public static void setPhoneNo(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.PHONE_NO, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getPhoneNo(Context context) {
		return getInstance(context).getString(PreferenceConstants.PHONE_NO, "");
	}

	/** Call to set the user name of user. */
	public static void setDOB(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.DOB, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getDOB(Context context) {
		return getInstance(context).getString(PreferenceConstants.DOB, "");
	}

	/** Call to set the user name of user. */
	public static void setGenType(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.GENTYPE, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getGenType(Context context) {
		return getInstance(context).getString(PreferenceConstants.GENTYPE, "");
	}

	/** Call to set the user name of user. */
	public static void setBlockNo(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.BLOCKNO, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getBlockNo(Context context) {
		return getInstance(context).getString(PreferenceConstants.BLOCKNO, "");
	}

	/** Call to set the user name of user. */
	public static void setTower(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.TOWER, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getTower(Context context) {
		return getInstance(context).getString(PreferenceConstants.TOWER, "");
	}

	/** Call to set the user name of user. */
	public static void setFloorNo(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.FLOORNO, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getFloorNo(Context context) {
		return getInstance(context).getString(PreferenceConstants.FLOORNO, "");
	}

	/** Call to set the user name of user. */
	public static void setFlatNo(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.FLATNO, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getFlatNo(Context context) {
		return getInstance(context).getString(PreferenceConstants.FLATNO, "");
	}

	/** Call to set the user name of user. */
	public static void setResType(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.RESTYPE, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getResType(Context context) {
		return getInstance(context).getString(PreferenceConstants.RESTYPE, "");
	}

	/** A method to set application update check status flag. */
	public static void setIsAppLogOut(final boolean status, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.USER_LOGOUT, status).commit();
	}

	/** A method to get application update check status flag. */
	public static boolean isApplogOut(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.USER_LOGOUT, false);
	}

	/** Call to set the user name of user. */
	public static void setIDFilePath(String username, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.FILEPATH, username).commit();
	}

	/** Call to get the pswd of user. */
	public static String getIDFilePath(Context context) {
		return getInstance(context).getString(PreferenceConstants.FILEPATH, "");
	}

	/** A method to set application update check status flag. */
	public static void setIsJoinStatus(final boolean status, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.JOINSTATUS, status).commit();
	}

	/** A method to get application update check status flag. */
	public static boolean isJoinStatus(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.JOINSTATUS, false);
	}
	
	/** A method to set application update check status flag. */
	public static void setMyaccountSaveStatus(final boolean status, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.MYACCOUNT_FLAG, status).commit();
	}

	/** A method to get application update check status flag. */
	public static boolean getMyaccountSaveStatus(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.MYACCOUNT_FLAG, false);
	}
	/** A method to set application update check status flag. */
	public static void setVehicleAdded(final boolean status, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.VEHICLE_FLAG
						, status).commit();
	}

	/** A method to get application update check status flag. */
	public static boolean getvehicleAdded(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.VEHICLE_FLAG, false);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** Call to get the home latitude set by user. */
	public static String getHomeLatitude(Context context) {
		return getInstance(context).getString(PreferenceConstants.USER_LATI,
				"0.0");
	}

	/** Call to set the home latitude code set by user. */
	public static void setHomeLatitude(String latitude, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.USER_LATI, latitude).commit();
	}

	/** Call to get the home longitude set by user. */
	public static String getHomeLongitude(Context context) {
		return getInstance(context).getString(PreferenceConstants.USER_LONG,
				"0.0");
	}

	/** Call to set the home longitude code set by user. */
	public static void setHomeLongitude(String longitude, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.USER_LONG, longitude).commit();
	}

	/**
	 * Call to get the user enter zip code which was set from location setting
	 * screen.
	 */
	public static String getUserEnteredZipcode(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.USER_ENTERED_ZIPCODE, "");
	}

	/** Call to set the user enter zip code. */
	public static void setUserEnteredZipcode(String zipcode, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.USER_ENTERED_ZIPCODE, zipcode)
				.commit();
	}

	// /** Method to check if timestamp for offers is expired or not. */
	// public static boolean isOffersTimestampExpired(Context context) {
	// return ((System.currentTimeMillis() - getCommonOffersTimestamp(context))
	// > PreferenceConfig.getOfferRefreshInterval(context));
	// }

	/** Method to get timestamp for common offers download. */
	public static long getCommonOffersTimestamp(Context context) {
		return getInstance(context).getLong(
				PreferenceConstants.TIME_STAMP_REFRESH_COMMON_OFFERS, 0);
	}

	/** Method to set timestamp for common offers download. */
	public static void setCommonOffersTimestamp(long time, Context context) {
		getInstance(context)
				.edit()
				.putLong(PreferenceConstants.TIME_STAMP_REFRESH_COMMON_OFFERS,
						time).commit();
	}

	// /** Method to check if timestamp for Personal offers is expired or not.
	// */
	// public static boolean isPersonalOffersTimestampExpired(Context context) {
	// return ((System.currentTimeMillis() -
	// getPersonalOffersTimestamp(context))
	// > PreferenceConfig.getOfferRefreshInterval(context));
	// }

	/** Method to get timestamp for Personal offers download. */
	public static long getPersonalOffersTimestamp(Context context) {
		return getInstance(context).getLong(
				PreferenceConstants.TIME_STAMP_REFRESH_PERSONAL_OFFERS, 0);
	}

	/** Method to set timestamp for Personal offers download. */
	public static void setPersonalOffersTimestamp(long time, Context context) {
		getInstance(context)
				.edit()
				.putLong(
						PreferenceConstants.TIME_STAMP_REFRESH_PERSONAL_OFFERS,
						time).commit();
	}

	// /** Method to check if timestamp for Marketing offers is expired or not.
	// */
	// public static boolean isMarketingOffersTimestampExpired(Context context)
	// {
	// return ((System.currentTimeMillis() -
	// getMarketingOffersTimestamp(context))
	// > PreferenceConfig.getOfferRefreshInterval(context));
	// }

	/** Method to get timestamp for Marketing offers download. */
	public static long getMarketingOffersTimestamp(Context context) {
		return getInstance(context).getLong(
				PreferenceConstants.TIME_STAMP_REFRESH_MARKETING_OFFERS, 0);
	}

	/** Method to set timestamp for Marketing offers download. */
	public static void setMarketingOffersTimestamp(long time, Context context) {
		getInstance(context)
				.edit()
				.putLong(
						PreferenceConstants.TIME_STAMP_REFRESH_MARKETING_OFFERS,
						time).commit();
	}

	/** Method to check whether gps access permission dialog should show or not. */
	public static boolean canShowGpsAccessPermissionDialog(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.FLAG_SHOW_GPS_ACCESS_PERMISSION_DIALOG,
				true);
	}

	/** Method to set whether gps access permission dialog should show or not. */
	public static void setGpsAccessPermissionDialogStatus(boolean status,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(
						PreferenceConstants.FLAG_SHOW_GPS_ACCESS_PERMISSION_DIALOG,
						status).commit();
	}

	/** Method to get user email address. */
	public static String getUserEmailAddress(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.USER_EMAIL_ADDRESS, "");
	}

	/** Method to set user email address. */
	public static void setUserEmailAddress(String emailAddress, Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.USER_EMAIL_ADDRESS, emailAddress)
				.commit();
	}

	/** Method to get Login Token. */
	public static String getLoginToken(Context context) {
		return getInstance(context).getString(PreferenceConstants.LOGIN_TOKEN,
				"");
	}

	/** Method to set Login Token. */
	public static void setLoginToken(String loginToken, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LOGIN_TOKEN, loginToken)
				.commit();
	}

	/** Method to get Session Id. */
	public static String getSessionId(Context context) {
		return getInstance(context).getString(PreferenceConstants.SESSION_ID,
				"");
	}

	/** Method to set Session Id. */
	public static void setSessionId(String sessionId, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.SESSION_ID, sessionId).commit();
	}

	/** Method to get Email Screen shown status. */
	public static boolean isEmailScreenShown(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.EMAIL_SCREEN_SHOWN, false);
	}

	/** Method to set Email Screen shown status. */
	public static void setEmailScreenShown(boolean emailScreenShown,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.EMAIL_SCREEN_SHOWN,
						emailScreenShown).commit();
	}

	/** Method to get Token Screen visible status. */
	public static boolean isTokenScreenVisible(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.TOKEN_SCREEN_VISIBLE, false);
	}

	/** Method to set Token Screen visible status. */
	public static void setTokenScreenVisiblity(boolean visibility,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.TOKEN_SCREEN_VISIBLE,
						visibility).commit();
	}

	/** Method to get Home Zip Screen visible status. */
	public static boolean isHomeZipScreenVisible(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.HOMEZIP_SCREEN_VISIBLE, false);
	}

	/** Method to set Home Zip Screen visible status. */
	public static void setHomeZipScreenVisiblity(boolean visibility,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.HOMEZIP_SCREEN_VISIBLE,
						visibility).commit();
	}

	/** Method to get Email signup Screen visible status. */
	public static boolean isEmailScreenVisible(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.EMAIL_SCREEN_VISIBLE, false);
	}

	/** Method to set Email signup Screen visible status. */
	public static void setEmailScreenVisiblity(boolean visibility,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.EMAIL_SCREEN_VISIBLE,
						visibility).commit();
	}

	/** Method to get HomeZipCode Screen shown status. */
	public static boolean isHomeZipCodeScreenShown(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.HOME_ZIPCODE_SCREEN_SHOWN, false);
	}

	/** Method to set HomeZipCode Screen shown status. */
	public static void setHomeZipCodeScreenShown(
			boolean homeZipCodeScreenShown, Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.HOME_ZIPCODE_SCREEN_SHOWN,
						homeZipCodeScreenShown).commit();
	}

	/** Method to set Email signup Screen visible status. */
	public static void setHomeScreenClickVisiblity(boolean visibility,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.HOME_SCREEN_CLICK, visibility)
				.commit();
	}

	/** Method to get Email signup Screen visible status. */
	public static boolean isHomelScreenClickVisible(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.HOME_SCREEN_CLICK, true);
	}

	/** Method to check if user is valid app user. */
	public static boolean isValidUser(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.FLAG_VALID_APP_USER, false);
	}

	/** Method to set if user is valid or not to use the app. */
	public static void setUserValidity(final boolean isValidUser,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.FLAG_VALID_APP_USER,
						isValidUser).commit();
	}

	/**
	 * Method to get the current download mode for offer fetch.
	 * 
	 * @return the Download Mode. Modes can be {@link DownloadMode#MODE_GPS},
	 *         {@link DownloadMode#MODE_HOME_ZIPCODE},
	 *         {@link DownloadMode#MODE_ZIPCODE} or
	 *         {@link DownloadMode#MODE_NONE}.
	 */
	// public static byte getDownloadMode(Context context) {
	// return (byte)
	// getInstance(context).getInt(PreferenceConstants.OFFER_DOWNLOAD_MODE,
	// DownloadMode.MODE_GPS);
	// }

	/**
	 * Method to set the current download mode for offer fetch.
	 * 
	 * @param mDownloadMode
	 *            the Download Mode to set. Modes can be
	 *            {@link DownloadMode#MODE_GPS},
	 *            {@link DownloadMode#MODE_HOME_ZIPCODE},
	 *            {@link DownloadMode#MODE_ZIPCODE} or
	 *            {@link DownloadMode#MODE_NONE}.
	 */
	public static void setDownloadMode(byte downloadMode, Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.OFFER_DOWNLOAD_MODE, downloadMode)
				.commit();
	}

	public static void setDownloadModeHome(byte downloadMode, Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.OFFER_DOWNLOAD_MODE_HOME,
						downloadMode).commit();
	}

	// public static byte getDownloadModeHome(Context context) {
	// return (byte)
	// getInstance(context).getInt(PreferenceConstants.OFFER_DOWNLOAD_MODE_HOME,
	// DownloadMode.MODE_NONE);
	// }

	/**
	 * Method to check the status of favorite offer sync is done or not at very
	 * first app launch.
	 */
	public static boolean isFavoriteOffersFirstSyncDone(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.FLAG_FIRST_FAVORITE_OFFERS_SYNC_STATUS,
				false);
	}

	/**
	 * Method to set the status of favorite offer sync is done or not at very
	 * first app launch.
	 */
	public static void setFavoriteOffersFirstSyncStatus(boolean status,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(
						PreferenceConstants.FLAG_FIRST_FAVORITE_OFFERS_SYNC_STATUS,
						status).commit();
	}

	/** Method to get showing category status. */
	public static boolean isShowCatogory(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.SHOW_CATEGORY, true);
	}

	/** Method to set showing category status. */
	public static void setShowCategory(final boolean showCategory,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.SHOW_CATEGORY, showCategory)
				.commit();
	}

	/** Method to get enable/disable status of push notification. */
	public static boolean isEnableNotification(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.SET_NOTIFICATION, false);
	}

	/** Method to set enable/disable status of push notification. */
	public static void setEnableNotification(final boolean enableNotification,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.SET_NOTIFICATION,
						enableNotification).commit();
	}

	/**
	 * Method to check the status of app configuration download is done or not
	 * at app launch.
	 */
	public static boolean isAppConfigDownloaded(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.FLAG_APP_CONFIG_DOWNLOAD_STATUS, false);
	}

	/**
	 * Method to set the status of app configuration download is done or not at
	 * app launch.
	 */
	public static void setAppConfigDownloadStatus(boolean status,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(
						PreferenceConstants.FLAG_APP_CONFIG_DOWNLOAD_STATUS,
						status).commit();
	}

	// /** Method to get refresh interval of the offers. */
	// public static long getOfferRefreshInterval(Context context) {
	// return
	// getInstance(context).getLong(PreferenceConstants.OFFER_REFRESH_INTERVAL,
	// BusinessLogicConfig.REFRESH_OFFERS_THRESHOLD);
	// }
	//
	/** Method to set refresh interval of the offers. */
	public static void setOfferRefreshInterval(int inMins, Context context) {
		getInstance(context)
				.edit()
				.putLong(PreferenceConstants.OFFER_REFRESH_INTERVAL,
						(1000 * 60 * inMins)).commit();
	}

	/** Method to get the Push Token sent by push server. */
	public static String getPushToken(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.USER_PUSH_TOKEN, "");
	}

	/** Method to set the Push Token got from push server. */
	public static void setPushToken(String loginToken, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.USER_PUSH_TOKEN, loginToken)
				.commit();
	}

	/** Method to get lat for zipcode. */
	public static String getLatForZipCode(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.LAT_FOR_ZIPCODE, "");
	}

	/** Method to set lat for zipcode. */
	public static void setLatForZipCode(String lat, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LAT_FOR_ZIPCODE, lat).commit();
	}

	/** Method to get lon for zipcode. */
	public static String getLonForZipCode(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.LON_FOR_ZIPCODE, "");
	}

	/** Method to set lot for zipcode. */
	public static void setLonForZipCode(String lon, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LON_FOR_ZIPCODE, lon).commit();
	}

	// /** Method to check if timestamp for all category is expired or not. */
	// public static boolean isAllCategoryTimestampExpired(Context context) {
	// return ((System.currentTimeMillis() - getAllCategoryTimestamp(context))
	// > BusinessLogicConfig.REFRESH_ALL_CATEGORY_THRESHOLD);
	// }

	/** Method to get refresh timestamp of all category download. */
	public static long getAllCategoryTimestamp(Context context) {
		return getInstance(context).getLong(
				PreferenceConstants.TIME_STAMP_REFRESH_ALL_CATEGORIES, 0);
	}

	/** Method to set timestamp for all category download. */
	public static void setAllCategoryTimestamp(long time, Context context) {
		getInstance(context)
				.edit()
				.putLong(PreferenceConstants.TIME_STAMP_REFRESH_ALL_CATEGORIES,
						time).commit();
	}

	/** A method to set app background tracking time stamp. **/
	public static void setAppBackgroundTrackTimestamp(final long timestamp,
			Context context) {
		getInstance(context)
				.edit()
				.putLong(PreferenceConstants.TIME_STAMP_APP_BACKGROUND,
						timestamp).commit();
	}

	/** A method to get app background tracking time stamp. **/
	public static long getAppBackgroundTrackTimestamp(Context context) {
		return PreferenceConfig.getInstance(context).getLong(
				PreferenceConstants.TIME_STAMP_APP_BACKGROUND, 0);
	}

	// /** Method to check whether session is expired or not. **/
	// public static boolean isSessionIdExpired(Context context) {
	// long currentTime = System.currentTimeMillis();
	// if ((currentTime - getAppBackgroundTrackTimestamp(context))
	// > BusinessLogicConfig.APP_BACKGROUND_THRESHOLD) {
	// return true;
	// }
	// return false;
	// }
	//
	/** A method to set radius for offers proximity. */
	public static void setAdminOffersProximityRadius(final int radius,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.ADMIN_OFFERS_PROXIMITY_RADIUS,
						radius).commit();
	}

	/** A method to get radius for offers proximity. Default radius is -1 miles. */
	public static int getAdminOffersProximityRadius(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.ADMIN_OFFERS_PROXIMITY_RADIUS, -1);
	}

	/** A method to set radius for offers proximity. */
	public static void setOffersProximityRadius(final int radius,
			Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.OFFERS_PROXIMITY_RADIUS, radius)
				.commit();
	}

	/** A method to get radius for offers proximity. Default radius is -1 miles. */
	public static int getOffersProximityRadius(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.OFFERS_PROXIMITY_RADIUS, -1);
	}

	/** A method to set notification radius for offers proximity. */
	public static void setOffersNotificationProximityRadius(final int radius,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.OFFERS_NOTIFICATION_PROXIMITY_RADIUS,
						radius).commit();
	}

	// /** A method to get notification radius for offers proximity.
	// * Default radius is {@link
	// BusinessLogicConfig#DEFAULT_OFFER_PROXIMITY_RADIUS} miles. */
	// public static int getOffersNotificationProximityRadius(Context context) {
	// return
	// PreferenceConfig.getInstance(context).getInt(PreferenceConstants.OFFERS_NOTIFICATION_PROXIMITY_RADIUS,
	// BusinessLogicConfig.DEFAULT_OFFER_PROXIMITY_RADIUS);
	// }

	/** A method to set personal offer count. */
	public static void setPersonalOfferCount(final int personalOfferCount,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.PERSONAL_OFFER_COUNT,
						personalOfferCount).commit();
	}

	/** A method to get personal offer count. */
	public static int getPersonalOfferCount(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.PERSONAL_OFFER_COUNT, 0);
	}

	/** A method to set common offer count. */
	public static void setCommonOfferCount(final int commonOfferCount,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.COMMON_OFFER_COUNT,
						commonOfferCount).commit();
	}

	/** A method to get common offer count. */
	public static int getCommonOfferCount(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.COMMON_OFFER_COUNT, 0);
	}

	/** A method to get Marketing offer count. */
	public static int getMarketingMsgCount(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.MARKETING_MSG_COUNT, 0);
	}

	/** A method to set Marketing offer count. */
	public static void setMarketingMsgCount(final int marketingOfferCount,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.MARKETING_MSG_COUNT,
						marketingOfferCount).commit();
	}

	/** A method to set favorite offer count. */
	public static void setFavoriteOfferCount(final int favoriteOfferCount,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.FAVORITE_OFFER_COUNT,
						favoriteOfferCount).commit();
	}

	/** A method to get favorite offer count. */
	public static int getFavoriteOfferCount(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.FAVORITE_OFFER_COUNT, 0);
	}

	/** A method to set store locator count. */
	public static void setStoreLocatorCount(final int favoriteOfferCount,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.STORE_LOCATOR_COUNT,
						favoriteOfferCount).commit();
	}

	/** A method to get store locator count. */
	public static int getStoreLocatorCount(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.STORE_LOCATOR_COUNT, 0);
	}

	/** A method to set the app version code. */
	public static void setAppVersionCode(final int appVersionCode,
			Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.APP_VERSION_CODE, appVersionCode)
				.commit();
	}

	/** A method to get the app version code. */
	public static int getAppVersionCode(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.APP_VERSION_CODE, 0);
	}

	/** A method to set whether the app version code and name is set or not */
	public static void setIsAppVersionSet(final Boolean appVersionCode,
			Context context) {
		getInstance(context).edit().putBoolean(
				PreferenceConstants.APP_VERSION_SET, appVersionCode);
	}

	/** A method to get whether the app version code and name is set or not */
	public static boolean getIsAppVersionSet(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.APP_VERSION_SET, false);
	}

	/** A method to set the old app version code. */
	public static void setEarlierAppVersionCode(final int appVersionCode,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.EARLIER_APP_VERSION_CODE,
						appVersionCode).commit();
	}

	/** A method to get the old app version code. */
	public static int getEarlierAppVersionCode(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.EARLIER_APP_VERSION_CODE, 0);
	}

	/** A method to set the old app version code. */
	public static void setAppVersionName(final String appVersionCode,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.APP_VERSION_NAME, appVersionCode)
				.commit();
	}

	/** A method to get the old app version code. */
	public static String getAppVersionName(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.APP_VERSION_NAME, "");
	}

	/** A method to set the old app version code. */
	public static void setEarlierAppVersionName(final String appVersionCode,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.EARLIER_APP_VERSION_NAME,
						appVersionCode).commit();
	}

	/** A method to get the old app version code. */
	public static String getEarlierAppVersionName(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.EARLIER_APP_VERSION_NAME, "");
	}

	/** A method to set launch from notification flag. */
	public static void setIsLaunchFromNotification(
			final boolean isLaunchFromNotification, Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.IS_LAUNCH_FROM_NOTIFICATION,
						isLaunchFromNotification).commit();
	}

	/** A method to get launch from notification flag. */
	public static boolean getIsLaunchFromNotification(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.IS_LAUNCH_FROM_NOTIFICATION, false);
	}

	/** A method to set screen launch from notification flag. */
	public static void setLaunchScreenFromNotification(
			final String launchScreenFromNotification, Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LAUNCH_SCREEN_FROM_NOTIFICATION,
						launchScreenFromNotification).commit();
	}

	// /** A method to get screen launch from notification flag. */
	// public static String getLaunchScreenFromNotification(Context context) {
	// return
	// PreferenceConfig.getInstance(context).getString(PreferenceConstants.LAUNCH_SCREEN_FROM_NOTIFICATION,
	// OfferNotificationType.COMMON_OFFER);
	// }

	/** A method to set app is running flag. */
	public static void setAppIsRunning(final boolean appIsRunning,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.APP_IS_RUNNING, appIsRunning)
				.commit();
	}

	/** A method to get app is running flag. */
	public static boolean getAppIsRunning(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.APP_IS_RUNNING, false);
	}

	/** A method to set category filter id. */
	public static void setCategoryFilterId(final String categoryFilterId,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.CATEGORY_FILTER_ID_LIST,
						categoryFilterId).commit();
	}

	/** A method to get category filter id. */
	public static String getCategoryFilterId(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.CATEGORY_FILTER_ID_LIST, "");
	}

	/** A method to set category filter id. */
	public static void setcoming_from_offer(final Boolean categoryFilterId,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.COMING_FROM_OFFER,
						categoryFilterId).commit();
	}

	/** A method to get category filter id. */
	public static Boolean getcoming_from_offer(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.CATEGORY_FILTER_ID_LIST, false);
	}

	/** A method to set category filter id. */
	public static void setPreferenceFilterId(final String categoryFilterId,
			Context context) {
		getInstance(context)
				.edit()
				.putString(
						PreferenceConstants.CATEGORY_FILTER_ID_LIST_PREFERENCE,
						categoryFilterId).commit();
	}

	/** A method to get category filter id. */
	public static String getPreferenceFilterId(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.CATEGORY_FILTER_ID_LIST_PREFERENCE, "");
	}

	/** A method to set expand filter id. */
	public static void setCategoryExpandFilterId(final String categoryFilterId,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.EXPAND_CATEGORY_FILTER_ID_LIST,
						categoryFilterId).commit();
	}

	/** A method to get expand filter id. */
	public static String getCategoryExpandFilterId(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.EXPAND_CATEGORY_FILTER_ID_LIST, "");
	}

	/** A method to set geo significant distance value. */
	public static void setGeoSignificantDistance(final String distance,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.GEO_SIGNIFICANT_DISTANCE,
						distance).commit();
	}

	/** A method to get geo significant distance value. */
	public static String getGeoSignificantDistance(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.GEO_SIGNIFICANT_DISTANCE, "0");
	}

	/** A method to set active triggers list value. */
	public static void setActiveTriggersList(final String triggersList,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.ACTIVE_TRIGGERS_LIST,
						triggersList).commit();
	}

	/** A method to get active triggers list value. */
	public static String getActiveTriggersList(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.ACTIVE_TRIGGERS_LIST, null);
	}

	/** A method to set geo significant frequency value. */
	public static void setGeoSignificantFrequency(final String triggersList,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.GEO_SIGNIFICANT_FREQUENCY,
						triggersList).commit();
	}

	/** A method to get geo significant frequency value. */
	public static String getGeoSignificantFrequency(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.GEO_SIGNIFICANT_FREQUENCY, null);
	}

	/** A method to set geo significant frequency value. */
	public static void setLoyaltyCardFirstName(final String firstName,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_FIRST_NAME,
						firstName).commit();
	}

	/** A method to get geo significant frequency value. */
	public static String getLoyaltyCardFirstName(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_FIRST_NAME, "");
	}

	/** A method to set loyalty card email value. */
	public static void setLoyaltyCardEmail(final String email, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LOYALTY_CARD_USER_EMAIL, email)
				.commit();
	}

	/** A method to get loyalty card email value. */
	public static String getLoyaltyCardEmail(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_USER_EMAIL, "");
	}

	/** A method to set loyalty card image url value. */
	public static void setLoyaltyCardImageUrl(final String imageUrl,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_IMAGE_URL, imageUrl)
				.commit();
	}

	/** A method to get loyalty card image url value. */
	public static String getLoyaltyCardImageUrl(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_IMAGE_URL, null);
	}

	/** A method to set loyalty card total rewards day value. */
	public static void setLoyaltyCardTotalRewardsDay(
			final String totalRewardsDay, Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_TOTAL_REWARDS_DAY,
						totalRewardsDay).commit();
	}

	/** A method to get loyalty card total rewards day value. */
	public static String getLoyaltyCardTotalRewardsDay(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_TOTAL_REWARDS_DAY, "");
	}

	/** A method to set loyalty card total rewards value. */
	public static void setLoyaltyCardTotalRewards(final String totalRewards,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_TOTAL_REWARDS,
						totalRewards).commit();
	}

	/** A method to get loyalty card total rewards value. */
	public static String getLoyaltyCardTotalRewards(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_TOTAL_REWARDS, "");
	}

	/** A method to set loyalty card expiry days value. */
	public static void setLoyaltyCardExpiryDays(final String expiryDays,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_EXPIRY_DAYS,
						expiryDays).commit();
	}

	/** A method to get loyalty card expiry days value. */
	public static String getLoyaltyCardExpiryDays(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_EXPIRY_DAYS, "");
	}

	/** A method to set loyalty card expiry rewards value. */
	public static void setLoyaltyCardExpiryRewards(final String expiryRewards,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_EXPIRY_REWARDS,
						expiryRewards).commit();
	}

	/** A method to get loyalty card expiry rewards value. */
	public static String getLoyaltyCardExpiryRewards(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_EXPIRY_REWARDS, "");
	}

	/** A method to set loyalty card transaction id value. */
	public static void setLoyaltyCardTransactionId(final String transactionId,
			Context context, int index) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_TRANSACTION_ID,
						transactionId).commit();
	}

	/** A method to get loyalty card transaction id value. */
	public static String getLoyaltyCardTransactionId(Context context, int index) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_TRANSACTION_ID + index, "");
	}

	/** A method to set loyalty card date value. */
	public static void setLoyaltyCardDate(final String date, Context context,
			int index) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LOYALTY_CARD_DATE + index, date)
				.commit();
	}

	/** A method to get loyalty card date value. */
	public static String getLoyaltyCardDate(Context context, int index) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_DATE + index, "");
	}

	/** A method to set loyalty card reward value. */
	public static void setLoyaltyCardRewards(final String rewards,
			Context context, int index) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_REWARDS + index,
						rewards).commit();
	}

	/** A method to get loyalty card rewards value. */
	public static String getLoyaltyCardRewards(Context context, int index) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_REWARDS + index, "");
	}

	/** A method to set loyalty card history count value. */
	public static void setLoyaltyCardHistoryCount(final int historyCount,
			Context context) {
		getInstance(context)
				.edit()
				.putInt(PreferenceConstants.LOYALTY_CARD_HISTORY_COUNT,
						historyCount).commit();
	}

	/** A method to get loyalty card history count value. */
	public static int getLoyaltyCardHistoryCount(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.LOYALTY_CARD_HISTORY_COUNT, 0);
	}

	/** A method to set loyalty card history count created flag. */
	public static void setIsLoyaltyCardCreated(
			final boolean isLoyaltyCardCreated, Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.LOYALTY_CARD_CREATED,
						isLoyaltyCardCreated).commit();
	}

	/** A method to get loyalty card history count created flag. */
	public static boolean getIsLoyaltyCardCreated(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.LOYALTY_CARD_CREATED, false);
	}

	/**
	 * Method to get the current loyalty card worker mode to take action for
	 * Loyalty Card details screen.
	 * 
	 * @return the Loyalty Card worker Mode. Modes can be
	 *         {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_SCAN},
	 *         {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_DELETE},
	 *         {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_JOIN_PROGRAM}
	 *         , {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_DISPLAY},
	 *         {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_MANUAL_ADD}
	 */
	// public static byte getLoyaltyCardWorkerMode(Context context) {
	// return (byte)
	// getInstance(context).getInt(PreferenceConstants.LOYALTY_CARD_WORKER_MODE,
	// LoyaltyCardWorkerMode.WORKER_MODE_LOYALTY_CARD_DISPLAY);
	// }

	/**
	 * Method to set the current Loyalty Card worker mode to take action for
	 * Loyalty Card details screen.
	 * 
	 * @param mode
	 *            Loyalty Card worker Mode. Modes can be
	 *            {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_SCAN},
	 *            {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_DELETE},
	 *            {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_JOIN_PROGRAM}
	 *            ,
	 *            {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_DISPLAY}
	 *            ,
	 *            {@link LoyaltyCardWorkerMode#WORKER_MODE_LOYALTY_CARD_MANUAL_ADD}
	 */
	public static void setLoyaltyCardWorkerMode(byte mode, Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.LOYALTY_CARD_WORKER_MODE, mode)
				.commit();
	}

	/** Method to set loyalty card number value. */
	public static void setLoyaltyCardNumber(final String number, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LOYALTY_CARD_NUMBER, number)
				.commit();
	}

	/** Method to get loyalty card number value. */
	public static String getLoyaltyCardNumber(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_NUMBER, null);
	}

	/** A method to set loyalty card image path. */
	public static void setLoyaltyCardImagePath(
			final String loyaltyCardImagePath, Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.LOYALTY_CARD_IMAGE_PATH,
						loyaltyCardImagePath).commit();
	}

	/** A method to get loyalty card image path. */
	public static String getLoyaltyCardImagePath(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.LOYALTY_CARD_IMAGE_PATH, "");
	}

	/** Method to set to launch loyalty card details screen. */
	public static void setLaunchLoyaltyCardDetailsScreen(final boolean flag,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(
						PreferenceConstants.LOYALTY_CARD_LAUNCH_DETAIL_SCREEN,
						flag).commit();
	}

	/** Method to get loyalty card details launch flag. */
	public static boolean getLaunchLoyaltyCardDetailsScreen(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.LOYALTY_CARD_LAUNCH_DETAIL_SCREEN, false);
	}

	// /** Method to get the status of app configuration download tims-stamp. */
	// public static boolean isAppConfigExpired(Context context) {
	// return ((System.currentTimeMillis() - getAppConfigTimestamp(context))
	// > BusinessLogicConfig.APP_CONFIG_THRESHOLD);
	// }

	/** Method to get the status of app configuration download time-stamp. */
	public static long getAppConfigTimestamp(Context context) {
		return getInstance(context).getLong(
				PreferenceConstants.FLAG_APP_CONFIG_EXPIRED, 0);
	}

	/** Method to set time-stamp for Personal offers download. */
	public static void setAppConfigTimestamp(long time, Context context) {
		getInstance(context).edit()
				.putLong(PreferenceConstants.FLAG_APP_CONFIG_EXPIRED, time)
				.commit();
	}

	/** Method to get the first launch status of loyalty card. */
	public static boolean getFirstLaunchLoyaltyCardStatus(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.FLAG_FIRST_LAUNCH_LOYALTY_CARD, true);
	}

	/** Method to set the first launch status of loyalty card. */
	public static void setFirstLaunchLoyaltyCardStatus(boolean status,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.FLAG_FIRST_LAUNCH_LOYALTY_CARD,
						status).commit();
	}

	/** Method to set if all category filter is selected or not. */
	public static void setAllCategoryFiltersSelected(final boolean flag,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.ALL_CATEGORY_IS_SELECTED, flag)
				.commit();
	}

	/** Method to get if all category filter is selected or not. */
	public static boolean getAllCategoryFiltersSelected(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.ALL_CATEGORY_IS_SELECTED, false);
	}

	/** A method to set application update check status flag. */
	public static void setIsAppUpdateChecked(final boolean status,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.APP_UPDATE_CHECKED, status)
				.commit();
	}

	/** A method to get application update check status flag. */
	public static boolean isAppUpdateChecked(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.APP_UPDATE_CHECKED, false);
	}

	/** A method to set application update availability status flag. */
	public static void setIsAppUpdateAvailable(final boolean status,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.APP_UPDATE_AVAILABLE, status)
				.commit();
	}

	/** A method to get application update check status flag. */
	public static boolean isAppUpdateAvailable(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.APP_UPDATE_AVAILABLE, false);
	}

	/** A method to set application update message coming from server. */
	public static void setAppUpdateMessage(final String msg, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.APP_UPDATE_MESSAGE, msg)
				.commit();
	}

	/** A method to get saved application update message. */
	public static String getAppUpdateMessage(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.APP_UPDATE_MESSAGE, "");
	}

	/**
	 * A method to set application update type coming from server. Value can be
	 * Optional or Mandatory.
	 */
	public static void setAppUpdateType(final String msg, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.APP_UPDATE_TYPE, msg).commit();
	}

	/**
	 * A method to get saved application update type. Value can be Optional or
	 * Mandatory.
	 */
	public static String getAppUpdateType(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.APP_UPDATE_TYPE, "");
	}

	/**
	 * A method to set a flag that indicates whether app supports redemption or
	 * not.
	 */
	public static void setIsAppSupportRedemption(final boolean flag,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.FLAG_IS_APP_SUPPORT_REDEMPTION,
						flag).commit();
	}

	/**
	 * A method to get flag that indicates whether app supports redemption or
	 * not.
	 */
	public static boolean getIsAppSupportRedemption(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.FLAG_IS_APP_SUPPORT_REDEMPTION, false);
	}

	/**
	 * A method to set row background color code for Marketing message coming
	 * from server configuration.
	 */
	public static void setComontopBgColorCode(int colorCode, Context context) {
		// int colorId = Color.parseColor("#a6a4a4");
		// colorCode = Color.parseColor(String.valueOf(R.color.top_bar_bg));
		getInstance(context).edit()
				.putInt(PreferenceConstants.TOPBARCOLOR_CODE, colorCode)
				.commit();
	}

	/**
	 * A method to get row background color code for Marketing message coming
	 * from server configuration.
	 */
	public static int getComontopBgColorCode(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.TOPBARCOLOR_CODE, -1);
	}

	/**
	 * A method to set row background color code for Marketing message coming
	 * from server configuration.
	 */
	public static void setMarketingMsgBgColorCode(int colorCode, Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.COLOR_CODE, colorCode).commit();
	}

	/**
	 * A method to get row background color code for Marketing message coming
	 * from server configuration.
	 */
	public static int getMarketingMsgBgColorCode(Context context) {
		return PreferenceConfig.getInstance(context).getInt(
				PreferenceConstants.COLOR_CODE, -1);
	}

	/** Call to get the home zip/city code from server. */
	public static String getHomeZipcodeFromServer(Context context) {
		return getInstance(context).getString(PreferenceConstants.ZIP, "zip");
	}

	/** Call to set the home zip/city code from server. */
	public static void setHomeZipcodeFromServer(String zipcode, Context context) {

		if (zipcode.equals("")) {
			getInstance(context).edit()
					.putString(PreferenceConstants.ZIP, "zip").commit();
		} else {
			getInstance(context).edit()
					.putString(PreferenceConstants.ZIP, zipcode).commit();
		}
	}

	/**
	 * A method to set search column (zip / city) recieved from server
	 * configuration.
	 */
	public static void setSearchColumn(final String searchColumn,
			Context context) {

		getInstance(context).edit()
				.putString(PreferenceConstants.SEARCH_COLUMN, searchColumn)
				.commit();
	}

	public static void setLoyaltyCardEnabled(final boolean lmsIntegrated,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.LMS_INTEGRATED, lmsIntegrated)
				.commit();
	}

	public static boolean isloyaltyCardEnabled(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.LMS_INTEGRATED, true);
	}

	public static void setAllCategoryLink(final String categoryLink,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.ALL_CATEGORIES_S3_URL,
						categoryLink).commit();
	}

	public static String getAllCategoryLink(final Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.ALL_CATEGORIES_S3_URL, "");
	}

	/** A method to get a search column (zip / city). */
	public static String getSearchColumn(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.SEARCH_COLUMN, "zip");
	}

	/** A method to set user specific offer list design . */
	public static void setOfferListTypeEnabled(final boolean lmsIntegrated,
			Context context) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.CONFIG_OFFER_LIST,
						lmsIntegrated).commit();
	}

	/** A method to get user specific offer list design . */
	public static boolean getOfferListTypeEnabled(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.CONFIG_OFFER_LIST, true);
	}

	/** A method to set user home template config flag . */
	public static void setHomeTabEnabled(final boolean homeTabConfig,
			Context context) {

		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.HOME_PAGE_CONFIG_STATUS,
						homeTabConfig).commit();
	}

	/** A method to get user home template config flag. */
	public static boolean getHomeTabEnabled(Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.HOME_PAGE_CONFIG_STATUS, false);
	}

	/**
	 * A method to set market message image url recieved from server
	 * configuration.
	 */
	public static void setMaketMessageImageUrl(final String imageUrl,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.MARKETING_MESSAGE_IMAGE_URL,
						imageUrl).commit();
	}

	/** A method to get a market message image url from server configuration. */
	public static String getMaketMessageImageUrl(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.MARKETING_MESSAGE_IMAGE_URL, "");
	}

	/** Method to set barcode type. */
	public static void setBarCodeType(final int barCodeType, Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.BARCODE_TYPE, barCodeType).commit();
	}

	/** Method to get barcode type. */
	public static int getBarCodeType(Context context) {
		return getInstance(context)
				.getInt(PreferenceConstants.BARCODE_TYPE, -1);
	}

	/**
	 * A Method to set minimum range of barcode value used as Loyalty card
	 * number.
	 */
	public static void setBarCodeMinRange(final int barCodeMinRange,
			Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.BARCODE_MIN_RANGE, barCodeMinRange)
				.commit();
	}

	// /** A Method to get minimum range of barcode value used as Loyalty card
	// number. */
	// public static int getBarCodeMinRange(Context context) {
	// return getInstance(context).getInt(PreferenceConstants.BARCODE_MIN_RANGE,
	// BusinessLogicConfig.DEFAULT_BARCODE_MIN_RANGE);
	// }

	/**
	 * A Method to set maximum range of barcode value used as Loyalty card
	 * number.
	 */
	public static void setBarCodeMaxRange(final int barCodeMaxRange,
			Context context) {
		getInstance(context).edit()
				.putInt(PreferenceConstants.BARCODE_MAX_RANGE, barCodeMaxRange)
				.commit();
	}

	// /** A Method to get maximum range of barcode value used as Loyalty card
	// number. */
	// public static int getBarCodeMaxRange(Context context) {
	// return getInstance(context).getInt(PreferenceConstants.BARCODE_MAX_RANGE,
	// BusinessLogicConfig.DEFAULT_BARCODE_MAX_RANGE);
	// }
	//
	// /** A method to set code red key. */
	public static void setCodeRedKey(final byte[] code, Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.CODE_RED,
						Base64.encodeToString(code, Base64.NO_WRAP)).commit();
	}

	/** A method to get code red key. */
	public static byte[] getCodeRedKey(Context context) {
		String code = PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.CODE_RED, null);
		if (!TextUtils.isEmpty(code)) {
			return Base64.decode(code, Base64.NO_WRAP);
		}
		return null;
	}

	/** A method to set code red IV key. */
	public static void setCodeRedIVKey(final byte[] code, Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.CODE_RED_IVECTOR,
						Base64.encodeToString(code, Base64.NO_WRAP)).commit();
	}

	/** A method to get code red IV key. */
	public static byte[] getCodeRedIVKey(Context context) {
		String code = PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.CODE_RED_IVECTOR, null);
		if (!TextUtils.isEmpty(code)) {
			return Base64.decode(code, Base64.NO_WRAP);
		}
		return null;
	}

	/** A method to set code red pass. */
	public static void setCodeRedPass(final String passphraseOrPin,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.CODE_RED_PASSWD, passphraseOrPin)
				.commit();
	}

	/** A method to get saved code red pass. */
	public static String getCodeRedPass(Context context) {
		return PreferenceConfig.getInstance(context).getString(
				PreferenceConstants.CODE_RED_PASSWD, null);
	}

	/**
	 * A method to set original default GPS status when Loyalty 247 was
	 * launched.
	 */
	public static void setDefaultGPSStatus(final Context context) {
		LocationManager locationManager = (LocationManager) context
				.getSystemService(Activity.LOCATION_SERVICE);
		getInstance(context)
				.edit()
				.putBoolean(
						PreferenceConstants.DEFAULT_GPS_STATUS,
						locationManager
								.isProviderEnabled(LocationManager.GPS_PROVIDER))
				.commit();
	}

	/**
	 * A method to get original default GPS status when Loyalty 247 was
	 * launched..
	 */
	public static Boolean isDefaultGPSStatus(final Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.DEFAULT_GPS_STATUS, true);
	}

	/** A method to get current GPS status. */
	public static Boolean getCurrentGPSStatus(final Context context) {
		LocationManager locationManager = (LocationManager) context
				.getSystemService(Activity.LOCATION_SERVICE);
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	/** A method to get whether we are coming from Home Icon Click.. */
	public static Boolean isComingFromHomeIcon(final Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.HOME_ICON, false);
	}

	/** A method to put the value when we will click on Home Icon */
	public static void putComingFromHomeIcon(final Context context,
			final boolean comingFromHome) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.HOME_ICON, comingFromHome)
				.commit();
	}

	/** A method to get whether we are accessing first time */
	public static Boolean isFirstTimeAccess(final Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.FIRST_TIME_ACCESS, false);
	}

	/** A method to put whether we are accessing first time or not */
	public static void putFirstTimeAccess(final Context context,
			final boolean comingFromHome) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.FIRST_TIME_ACCESS,
						comingFromHome).commit();
	}

	/** A method to get whether we are accessing first time */
	public static Boolean isFirstTimeAccessFilter(final Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.FIRST_TIME_ACCESS_FILTER, false);
	}

	/** A method to put whether we are accessing first time or not */
	public static void putFirstTimeAccessFilter(final Context context,
			final boolean comingFromHome) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.FIRST_TIME_ACCESS_FILTER,
						comingFromHome).commit();
	}

	/**
	 * A method to get whether the filter is getting loaded for first time or
	 * not
	 **/
	public static Boolean getFirstLoadFilter(final Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.LOAD_FILTER_FIRST, true);
	}

	/**
	 * A method to put whether the filter is getting loaded for first time or
	 * not
	 **/
	public static void setFirstLoadFilter(final Context context,
			final boolean comingFromHome) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.LOAD_FILTER_FIRST,
						comingFromHome).commit();
	}

	/** Call to get the user store search mode */
	public static String getStoreSearchType(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.STORE_SEARCH_TYPE, "gps");
	}

	/** Call to set the user store search mode */
	public static void setStoreSearchType(String type, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.STORE_SEARCH_TYPE, type)
				.commit();
	}

	/** Call to get whether we are coming from Store Locator page */
	public static boolean getComingFromStoreLocator(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.COMING_FROM_SCREEN, false);
	}

	/** Call to set whether coming from Store Locator page */
	public static void setComingFromStoreLocator(boolean type, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.COMING_FROM_SCREEN, type)
				.commit();
	}

	/** Call to get the user store search mode */
	public static String getPreviousStoreSearchType(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.PREVIOUS_STORE_SEARCH_TYPE, "gps");
	}

	/** Call to set the user store search mode */
	public static void setPreviousStoreSearchType(String type, Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.PREVIOUS_STORE_SEARCH_TYPE, type)
				.commit();
	}

	/** Call to get the user store search mode */
	public static boolean getComingFromStore(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.COMING_FROM_STORE, false);
	}

	/** Call to set the user store search mode */
	public static void setComingFromStore(Boolean type, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.COMING_FROM_STORE, type)
				.commit();
	}

	/** Call to get the user store search mode */
	public static boolean getComingFromOffer(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.COMING_FROM_OFFER1, false);
	}

	/** Call to set the user store search mode */
	public static void setComingFromOffer(Boolean type, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.COMING_FROM_OFFER1, type)
				.commit();
	}

	/** Call to get the user store search mode */
	public static Boolean getFirstTimeClick(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.FIRST_TIME_CLICKED, false);
	}

	/** Call to set the user store search mode */
	public static void setFirstTimeClick(Boolean type, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.FIRST_TIME_CLICKED, type)
				.commit();
	}

	/** Call to get the latest clicked tab name */
	public static String getLatestTabClick(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.STORE_TAB_NAME, "list");
	}

	/** Call to set the latest clicked tab name */
	public static void setLatestTabClick(String type, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.STORE_TAB_NAME, type).commit();
	}

	/** Call to get userId for flurry */
	public static String getFlurryUserId(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.FLURRY_USERID, "");
	}

	/** Call to set the userId for flurry */
	public static void setFlurryUserId(String userID, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.FLURRY_USERID, userID).commit();
	}

	/** Call to get userId for flurry */
	public static String getPiwikUserId(Context context) {
		return getInstance(context).getString(PreferenceConstants.PIWIK_USERID,
				"");
	}

	/** Call to set the userId for flurry */
	public static void setPiwikUserId(String userID, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.PIWIK_USERID, userID).commit();
	}

	/** Call to get the location zip latitude set by user. */
	public static String getlocationzipLatitude(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.LOCATIO_ZIP_LATI, "0.0");
	}

	/** Call to set the location zip latitude code set by user. */
	public static void setlocationzipLatitude(String latitude, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LOCATIO_ZIP_LATI, latitude)
				.commit();
	}

	/** Call to get the location zip longitude set by user. */
	public static String getlocationzipLongitude(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.LOCATIO_ZIP_LONG, "0.0");
	}

	/** Call to set the location zip longitude code set by user. */
	public static void setlocationzipLongitude(String longitude, Context context) {
		getInstance(context).edit()
				.putString(PreferenceConstants.LOCATIO_ZIP_LONG, longitude)
				.commit();
	}

	public static void showTurnOnDialog(boolean b, Context context) {
		// TODO Auto-generated method stub
		LocationManager locationManager = (LocationManager) context
				.getSystemService(Activity.LOCATION_SERVICE);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			getInstance(context).edit()
					.putBoolean(PreferenceConstants.SHOW_TURN_ON, false)
					.commit();
		} else {
			getInstance(context).edit()
					.putBoolean(PreferenceConstants.SHOW_TURN_ON, true)
					.commit();
		}
	}

	public static boolean canShowTurnOnDialog(Context context) {
		// TODO Auto-generated method stub
		LocationManager locationManager = (LocationManager) context
				.getSystemService(Activity.LOCATION_SERVICE);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			return false;
		} else {
			return getInstance(context).getBoolean(
					PreferenceConstants.SHOW_TURN_ON, false);
		}
	}

	/** A method to get whether to show splash screen */
	public static Boolean isShowSplashScreen(final Context context) {
		return PreferenceConfig.getInstance(context).getBoolean(
				PreferenceConstants.SHOW_SPLASH_SCREEN, false);
	}

	/** A method to put whether to show splash screen */
	public static void showSplashScreen(final Context context,
			final boolean showSplashScreen) {
		getInstance(context)
				.edit()
				.putBoolean(PreferenceConstants.SHOW_SPLASH_SCREEN,
						showSplashScreen).commit();
	}

	/** Method to set trigger type should be GL */
	public static void setFirstTimeGL(boolean time, Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.FIRST_TIME_GL, time).commit();
	}

	/** Method to set whether trigger type should be GL or not */
	public static boolean isFirstTimeGL(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.FIRST_TIME_GL, false);
	}

	/** A method to set marketing message config flag . */
	public static void setMarketingMsgTabEnabled(
			final Boolean marketingTabConfig, Context context) {

		getInstance(context)
				.edit()
				.putBoolean(
						PreferenceConstants.MARKETING_MESSAGE_LINK_ENABLE_IN_APP,
						marketingTabConfig).commit();
	}

	/** A method to get marketing message config flag . */
	public static Boolean getMarketingMsgTabEnabled(Context context) {
		return PreferenceConfig
				.getInstance(context)
				.getBoolean(
						PreferenceConstants.MARKETING_MESSAGE_LINK_ENABLE_IN_APP,
						false);
	}

	/** Call to get whether we are coming from Marketing Message page */
	public static boolean getComingFromMarketingMsgTab(Context context) {
		return getInstance(context).getBoolean(
				PreferenceConstants.COMING_FROM_MARKETINGMSG, false);
	}

	/** Call to set whether coming from Marketing Message page */
	public static void setComingFromMarketingMsgTab(boolean type,
			Context context) {
		getInstance(context).edit()
				.putBoolean(PreferenceConstants.COMING_FROM_MARKETINGMSG, type)
				.commit();
	}

	/** Call to get the s3 bucket file name set by user. */
	public static String getS3BucketCategoryfilename(Context context) {
		return getInstance(context).getString(
				PreferenceConstants.S3_BUCKET_CATEGORIES_FILE_NAME, "");
	}

	/** Call to set the s3 bucket filename set by user. */
	public static void setS3BucketCategoryfilename(String filename,
			Context context) {
		getInstance(context)
				.edit()
				.putString(PreferenceConstants.S3_BUCKET_CATEGORIES_FILE_NAME,
						filename).commit();
	}

}
