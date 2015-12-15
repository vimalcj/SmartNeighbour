package com.mycommunityapp;

import com.mycommunityapp.config.PreferenceConfig;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ViewVehicleFragment extends Fragment {
	private TextView txt;

	public ViewVehicleFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_viewvehicle, container, false);
//		txt=(TextView)rootView.findViewById(R.id.txtLabel);
//		if(PreferenceConfig.getvehicleAdded(getActivity())){
//			txt.setText("Failed  to load vehile Details");
//		}
//		else{
//			
//		}

		return rootView;
	}

}
