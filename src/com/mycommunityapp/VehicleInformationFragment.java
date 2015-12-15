package com.mycommunityapp;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressLint("NewApi")
public class VehicleInformationFragment extends Fragment implements OnTabChangeListener{

	private TabHost mTabHost;
	private int mCurrentTab;
	private View rootView;
	private static final String TAG = "FragmentTabs";
	public static final String TAB_NUMBERS  = "Add My Vehicles";
	public static final String TAB_WORDS = "View My Vehicles";

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// View rootView = inflater.inflate(R.layout.fragment_read, container,
		// false);
		rootView = inflater.inflate(R.layout.fragment_store_tab, null);
		mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
		setupTabs();
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);

		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(mCurrentTab);
		// manually start loading stuff in the first tab
		updateTab(TAB_WORDS, R.id.tab_1);
	}

	private void setupTabs() {
		mTabHost.setup(); // you must call this before adding your tabs!
		mTabHost.addTab(newTab(TAB_WORDS, R.string.View, R.id.tab_1));
		mTabHost.addTab(newTab(TAB_NUMBERS, R.string.Add, R.id.tab_2));
	}

	private TabSpec newTab(String tag, int labelId, int tabContentId) {

		View indicator = LayoutInflater.from(getActivity()).inflate(
				R.layout.store_tab_layout,
				(ViewGroup) rootView.findViewById(android.R.id.tabs), false);
		final TextView viewVehicle =(TextView) indicator.findViewById(R.id.list);
		final TextView addVehicle =(TextView) indicator.findViewById(R.id.map);
		viewVehicle.setText(labelId);
		viewVehicle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm = getFragmentManager();
				Fragment frag = new ViewVehicleFragment();
				android.app.FragmentTransaction ft = fm.beginTransaction();
				ft.remove(frag);
				ft.replace(R.id.tab_1, frag);
				ft.commit();
				mTabHost.setCurrentTab(0);
				mCurrentTab = 0;
				viewVehicle.setBackgroundResource(R.drawable.map_store_tab);
				addVehicle.setBackgroundResource(R.drawable.list_store_tab_second);
			}
		});
		addVehicle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm = getFragmentManager();
				Fragment frag = new AddVehicleFragment();
				android.app.FragmentTransaction ft = fm.beginTransaction();
				ft.remove(frag);
				ft.replace(R.id.tab_2, frag);
				ft.commit();
				mTabHost.setCurrentTab(1);
				mCurrentTab = 1;
				viewVehicle.setBackgroundResource(R.drawable.map_store_tab_second);
				addVehicle.setBackgroundResource(R.drawable.list_store_tab);
			}
		});

		TabSpec tabSpec = mTabHost.newTabSpec(tag);
		tabSpec.setIndicator(indicator);
		tabSpec.setContent(tabContentId);
		return tabSpec;
	}

	public void onTabChanged(String tabId) {
		
		if (TAB_WORDS.equals(tabId)) {
			updateTab(tabId, R.id.tab_1);
			mCurrentTab = 0;
			return;
		}
		if (TAB_NUMBERS.equals(tabId)) {
			updateTab(tabId, R.id.tab_2);
			mCurrentTab = 1;
			return;
		}
	}

	private void updateTab(String tabId, int placeholder) {
		if (tabId.equalsIgnoreCase(TAB_WORDS)) {
			FragmentManager fm = getFragmentManager();
			Fragment frag = new ViewVehicleFragment();
			android.app.FragmentTransaction ft = fm.beginTransaction();
			ft.remove(frag);
			ft.replace(placeholder, frag);
			ft.commit();
		} else if (tabId.equalsIgnoreCase(TAB_NUMBERS)) {
			FragmentManager fm = getFragmentManager();
			Fragment frag = new AddVehicleFragment();
			android.app.FragmentTransaction ft = fm.beginTransaction();
			ft.remove(frag);
			ft.replace(placeholder, frag);
			ft.commit();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		}
//		FragmentManager fm = getFragmentManager();
//		if (fm.findFragmentByTag(tabId) == null) {
//			fm.beginTransaction()
//					.replace(placeholder, new MyListFragment(tabId), tabId)
//					.commit();
//		}
	}

}
