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
public class NearByHospitalsFragment extends Fragment {
	private ListView offerList;
	Context context;

	ArrayList prgmName;
	// public static int[] prgmImages = { R.drawable.download, R.drawable.flip,
	// R.drawable.snap, R.drawable.freec, R.drawable.amaz,
	// R.drawable.firstcry, R.drawable.flip,
	// R.drawable.download, R.drawable.ic_launcher };
	public static String[] nameList = { "Cloudnine", "Apollo Cradle",
			"Nimhans ", "Manipal Hospital", "Beams Hopital" };
	public static String[] addressList = {
			"No.1533, 9th Main, Jayanagar 3rd Block, Bangalore - 560011, Opposite Clumax ",
			"Seshadripuram #28, Platform Road, Seshadripuram, Bangalore",
			"No.2900, Marimallappa Gowda Road, Hosur Main Road, Bangalore - 560029",
			"No.98, Old Airport Road, Bangalore - 560017",
			"No.640, 12th Main, 80 Feet Road, 4th Block,, Koramangala, Bengaluru, Karnataka 560034" };
	public static String[] phoneList = { "80-16564873", "80-56564830",
			"80-26564811", "80-36164436", "80-76514854" };
	public static String[] timeList = { "6:15 AM - 1:00 PM",
			"9:15 AM - 1:00 PM", "8:00 AM-12:00 AM", "10:15 AM - 3:00 PM",
			"9:15 AM - 10:00 PM" };

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_nearoffer,
				container, false);
		// Get ListView object from xml
		offerList = (ListView) rootView.findViewById(R.id.list);
		context = getActivity();
		offerList.setAdapter(new CustomAdapter(NearByHospitalsFragment.this, nameList, addressList,timeList,phoneList)); 
		return rootView;
	}

	public class CustomAdapter extends BaseAdapter {
		String[] name;
		Context context;
		int[] imageId;
		private LayoutInflater inflater = null;
		String[] address;
		String[] time;
		String[] phone;

		public CustomAdapter(NearByHospitalsFragment mainActivity,
				String[] NameList, String[] AddressList, String[] TimeList,
				String[] phoneList) {
			// TODO Auto-generated constructor stub
			name = NameList;
			context = getActivity();
			// imageId = prgmImages;
			address = AddressList;
			time = TimeList;
			phone = phoneList;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return name.length;
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
			TextView txtName;
			TextView txtPhone;
			TextView txtTime;
			TextView txtAddress;

			// ImageView img;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			Holder holder = new Holder();
			View rowView;
			rowView = inflater.inflate(R.layout.row_for_hospital, null);
			holder.txtName = (TextView) rowView
					.findViewById(R.id.textView_store_name);
			holder.txtAddress = (TextView) rowView
					.findViewById(R.id.textView_store_address);
			holder.txtPhone = (TextView) rowView
					.findViewById(R.id.textView_store_phone_no);
			holder.txtTime = (TextView) rowView
					.findViewById(R.id.textView_open_time);

			holder.txtName.setText(name[position]);
			holder.txtAddress.setText(address[position]);
			holder.txtPhone.setText(phone[position]);
			holder.txtTime.setText(time[position]);
			rowView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// Toast.makeText(context, "You Clicked " +
					// result[position],
					// Toast.LENGTH_LONG).show();
				}
			});
			return rowView;
		}

	}
}
