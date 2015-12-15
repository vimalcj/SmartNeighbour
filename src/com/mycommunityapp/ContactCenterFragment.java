package com.mycommunityapp;

import com.mycommunityapp.activity.FindNeighbourActivity;
import com.mycommunityapp.activity.FindVendorActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("NewApi")
public class ContactCenterFragment extends Fragment {
	private Button findNeighbour, findVendor;
	public ContactCenterFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_contactcenter,
				container, false);
		findNeighbour = (Button) rootView.findViewById(R.id.findDrop);
		findVendor = (Button) rootView.findViewById(R.id.findReturn);
		findNeighbour.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getActivity(),FindNeighbourActivity.class);
				getActivity().startActivity(intent);
			}
		});
		findVendor.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getActivity(),FindVendorActivity.class);
				getActivity().startActivity(intent);
			}
		});
		return rootView;
	}

}