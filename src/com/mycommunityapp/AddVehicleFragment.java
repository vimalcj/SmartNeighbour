package com.mycommunityapp;

import com.mycommunityapp.config.PreferenceConfig;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("NewApi")
public class AddVehicleFragment extends Fragment {
    private Button done;
	public AddVehicleFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_addvehicle, container, false);
		 done=(Button)rootView.findViewById(R.id.done);
		 done.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PreferenceConfig.setVehicleAdded(true, getActivity());
				Toast.makeText(getActivity(), "Vehicle details added into DB", Toast.LENGTH_SHORT).show();
			}
		});
		return rootView;
	}

}
