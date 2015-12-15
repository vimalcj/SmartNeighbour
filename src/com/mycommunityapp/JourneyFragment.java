package com.mycommunityapp;

import java.util.List;
import java.util.Locale;


import com.communityapp.service.GpsListener;
import com.mycommunityapp.activity.DropJoinActivity;
import com.mycommunityapp.activity.ReturnJoinActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("NewApi")
public class JourneyFragment extends Fragment {
	private Button dropJourney, returnJourney;
	protected LocationManager locationManager;
	protected LocationListener locationListener;
	protected Context context;
	public JourneyFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_journeyshare,
				container, false);
		dropJourney = (Button) rootView.findViewById(R.id.findDrop);
		returnJourney = (Button) rootView.findViewById(R.id.findReturn);
		dropJourney.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getActivity(),DropJoinActivity.class);
				getActivity().startActivity(intent);
			}
		});
		returnJourney.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getActivity(),ReturnJoinActivity.class);
				getActivity().startActivity(intent);
			}
		});
		
	
		
		return rootView;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		LocationManager locationManager = (LocationManager) getActivity().getSystemService(Activity.LOCATION_SERVICE);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			getGPSLocation();
		}else{
			GpsListener gps = new GpsListener(getActivity());
			gps.showSettingsAlert();
		}
	}

	
	public void getGPSLocation(){
		GpsListener gps = new GpsListener(getActivity());
		double latitude = 0,longitude = 0;
	    System.out.println("GpsListener-------------");
		// check if GPS enabled
		if (gps.canGetLocation()) {
			latitude = gps.getLatitude();
			longitude = gps.getLongitude();
			String uLatitude= Double.toString(latitude);
			String uLongitude= Double.toString(longitude);
			 System.out.println("GpsListener-------------if");
			 System.out.println("GpsListener-------------"+uLatitude+"-----"+uLongitude);
			Toast.makeText(getActivity(), "uLatitude:" + uLatitude + ", uLongitude:" + uLongitude, Toast.LENGTH_SHORT).show();
		} else {
			gps.showSettingsAlert();
			 System.out.println("GpsListener-------------else");
		}
		
		try {
			Geocoder geocoder = new Geocoder(
					getActivity(), Locale.getDefault());

			List<Address> addresses = geocoder.getFromLocation(
					latitude, longitude, 1);
			
		} catch (Exception e) {
			//System.out.println("errror");
		}
	}
		

}
