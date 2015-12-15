package com.mycommunityapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.mycommunityapp.config.PreferenceConfig;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ToggleButton;

@SuppressLint("NewApi")
public class MyAccountFragment extends Fragment {
	private EditText firstName, phoneno,lastName;
	private RadioGroup rGroup1;
	private String genType = "Male";
	private Calendar myCalendar;
	private Button addInfo,dob;
	private RadioButton male;
	private RelativeLayout rel1;
	private ScrollView scl;
	private ToggleButton save;
	private AutoCompleteTextView bloodGroup;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// getActivity().setTitle(Html.fromHtml("<font color='#ffffff'>"+""+" </font>"));
		/* Attach CheckedChangeListener to radio group */

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_myaccount,
				container, false);
		firstName = (EditText) rootView.findViewById(R.id.editText_FirstName);
		lastName = (EditText) rootView.findViewById(R.id.editText_LastName);
		phoneno = (EditText) rootView.findViewById(R.id.editText_phone);
		dob = (Button) rootView.findViewById(R.id.editText_dob);
		rGroup1 = (RadioGroup) rootView.findViewById(R.id.sex);
		save = (ToggleButton) rootView.findViewById(R.id.done);
		male = (RadioButton) rootView.findViewById(R.id.Male);
		rel1 = (RelativeLayout) rootView.findViewById(R.id.rr1);
		scl = (ScrollView) rootView.findViewById(R.id.scroll);
		addInfo = (Button) rootView.findViewById(R.id.addinfo);
		bloodGroup = (AutoCompleteTextView) rootView.findViewById(R.id.editText_BloodGroup);
		if (PreferenceConfig.getMyaccountSaveStatus(getActivity())) {
			scl.setVisibility(View.VISIBLE);
			rel1.setVisibility(View.GONE);
			save.setVisibility(View.VISIBLE);			
			firstName.setText(PreferenceConfig.getName(getActivity()));
			lastName.setText(PreferenceConfig.getLastName(getActivity()));
			phoneno.setText(PreferenceConfig.getPhoneNo(getActivity()));
			dob.setText(PreferenceConfig.getDOB(getActivity()));
			//save.setText("Edit");
			
			dob.setEnabled(false);
						
			firstName.setFocusable(false);
			firstName.setEnabled(false);
			firstName.setCursorVisible(false);
			firstName.setKeyListener(null);
			
			lastName.setFocusable(false);
			lastName.setEnabled(false);
			lastName.setCursorVisible(false);
			lastName.setKeyListener(null);
			//firstName.setBackgroundColor(Color.TRANSPARENT); 
			
			phoneno.setFocusable(false);
			phoneno.setEnabled(false);
			phoneno.setCursorVisible(false);
			phoneno.setKeyListener(null);
			
			bloodGroup.setFocusable(false);
			bloodGroup.setEnabled(false);
			bloodGroup.setCursorVisible(false);
			bloodGroup.setKeyListener(null);
			
			
			//save.setText("Edit");
			save.setChecked(true);
			

		} else {
			scl.setVisibility(View.GONE);
			rel1.setVisibility(View.VISIBLE);
			save.setVisibility(View.GONE);

			// male.setId(id)(PreferenceConfig.getGenType(getActivity()));
		}
		addInfo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scl.setVisibility(View.VISIBLE);
				rel1.setVisibility(View.GONE);
				save.setVisibility(View.VISIBLE);

			}
		});
		rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rb = (RadioButton) group.findViewById(checkedId);
				if (null != rb && checkedId > -1) {
					// Toast.makeText(, rb.getText(),
					// Toast.LENGTH_SHORT).show();
					genType = rb.getText().toString();
				}

			}
		});

		dob.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Calendar c = Calendar.getInstance();
				int mYear = c.get(Calendar.YEAR);
				int mMonth = c.get(Calendar.MONTH);
				int mDay = c.get(Calendar.DAY_OF_MONTH);

				DatePickerDialog dpd = new DatePickerDialog(getActivity(),
						new DatePickerDialog.OnDateSetListener() {

							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								dob.setText(dayOfMonth + "-"
										+ (monthOfYear + 1) + "-" + year);

							}
						}, mYear, mMonth, mDay);
				dpd.show();

			}
		});
		save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
			
				if (isChecked) {
					Toast.makeText(getActivity(), "save", Toast.LENGTH_SHORT).show();
					genType = male.getText().toString();
					PreferenceConfig.setName(firstName.getText().toString(),
							getActivity());
					PreferenceConfig.setPhoneNo(phoneno.getText().toString(),
							getActivity());
					PreferenceConfig.setDOB(dob.getText().toString(),
							getActivity());
					PreferenceConfig.setGenType(genType.toString(),
							getActivity());
					PreferenceConfig.setLastName(lastName.getText().toString(),
							getActivity());
					PreferenceConfig
							.setMyaccountSaveStatus(true, getActivity());
					dob.setEnabled(false);
					
					firstName.setFocusable(false);
					firstName.setEnabled(false);
					firstName.setCursorVisible(false);
					firstName.setKeyListener(null);
					
					lastName.setFocusable(false);
					lastName.setEnabled(false);
					lastName.setCursorVisible(false);
					lastName.setKeyListener(null);
					//firstName.setBackgroundColor(Color.TRANSPARENT); 
					
					phoneno.setFocusable(false);
					phoneno.setEnabled(false);
					phoneno.setCursorVisible(false);
					phoneno.setKeyListener(null);
					
					bloodGroup.setFocusable(false);
					bloodGroup.setEnabled(false);
					bloodGroup.setCursorVisible(false);
					bloodGroup.setKeyListener(null);
					


				} else {
					//save.setText("Edit");
					Toast.makeText(getActivity(), "Edit", Toast.LENGTH_SHORT).show();					
					dob.setEnabled(true);										
					firstName.setFocusable(true);
					firstName.setEnabled(true);
					firstName.setCursorVisible(true);
					firstName.setKeyListener(null);
					
					lastName.setFocusable(true);
					lastName.setEnabled(true);
					lastName.setCursorVisible(true);
					lastName.setKeyListener(null);
					//firstName.setBackgroundColor(Color.TRANSPARENT); 
					
					phoneno.setFocusable(true);
					phoneno.setEnabled(true);
					phoneno.setCursorVisible(true);
					phoneno.setKeyListener(null);
					
					bloodGroup.setFocusable(true);
					bloodGroup.setEnabled(true);
					bloodGroup.setCursorVisible(true);
					bloodGroup.setKeyListener(null);
				}

			}
		});

		return rootView;
	}

}
