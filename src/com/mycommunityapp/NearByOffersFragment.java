package com.mycommunityapp;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class NearByOffersFragment extends Fragment {
	private ListView offerList;
	Context context;

	ArrayList prgmName;
	public static int[] prgmImages = { R.drawable.download, R.drawable.flip,
			R.drawable.snap, R.drawable.freec, R.drawable.amaz,
			R.drawable.firstcry, R.drawable.flip,
			R.drawable.download, R.drawable.ic_launcher };
	public static String[] prgmNameList = {
			"SALE ON TOP BRANDS is always a GOOD IDEA 30 - 70 % OFF",
			"Books & Media – Minimum 20% Off On Wide Range Of Collection + Free Shipping",
			"Exicting offers everyday sale @ 95% Off", 
			"DTH Recharge: Flat Rs. 50 Cashback on Rs. 200+ (New users)", 
			"Amazon Big Sale @ 95% off ", 
			"Big Bang Sale: Upto 60% Off + Extra 10% Cashback Using PayUmoney", 
			"Flat 50% off on entire baby care range", 
			"Myntra Coupons: Best Deals & Buy 1 Get 1 Offers | Nov 2015",
			"Upto 50% off on Handpicked products" };
	public static String [] ExdaList={"Expires on 15 days","Expires on 25 days","Expires on 5 days","Expires on 10 days","Expires on 35 days","Expires on 5 days","Expires on 45 days","Expires on 12 days","Expires on 25 days"};

	public NearByOffersFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_nearoffer,
				container, false);
		// Get ListView object from xml
		offerList = (ListView) rootView.findViewById(R.id.list);
		context = getActivity();
		offerList.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages,ExdaList));
		return rootView;
	}

	public class CustomAdapter extends BaseAdapter {
		String[] result;
		Context context;
		int[] imageId;
		private LayoutInflater inflater = null;
		String[] Exresult;
		public CustomAdapter(NearByOffersFragment mainActivity,
				String[] prgmNameList, int[] prgmImages,String[] expList) {
			// TODO Auto-generated constructor stub
			result = prgmNameList;
			context = getActivity();
			imageId = prgmImages;
			Exresult=expList;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return result.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public class Holder {
			TextView tv;
			TextView exp;
			ImageView img;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			Holder holder = new Holder();
			View rowView;
			rowView = inflater.inflate(R.layout.row_for_offers_custom, null);
			holder.tv = (TextView) rowView
					.findViewById(R.id.TextView_offer_name);
			holder.exp = (TextView) rowView
					.findViewById(R.id.TextView_expires_on);
			holder.img = (ImageView) rowView
					.findViewById(R.id.ImageView_offer_logo);
			holder.tv.setText(result[position]);
			holder.img.setImageResource(imageId[position]);
			holder.exp.setText(Exresult[position]);
			rowView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "You Clicked " + result[position],
							Toast.LENGTH_LONG).show();
				}
			});
			return rowView;
		}

	}
}
