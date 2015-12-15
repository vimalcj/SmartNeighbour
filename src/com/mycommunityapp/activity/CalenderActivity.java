package com.mycommunityapp.activity;

import com.mycommunityapp.R;
import com.mycommunityapp.R.color;
import com.mycommunityapp.R.id;
import com.mycommunityapp.R.layout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class CalenderActivity extends Activity{
	CalendarView calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//sets the main layout of the activity
		setContentView(R.layout.custom_dialog);
		
		//initializes the calendarview
		initializeCalendar();
	}

	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public void initializeCalendar() {
		calendar = (CalendarView) findViewById(R.id.calendar);

		// sets whether to show the week number.
		calendar.setShowWeekNumber(false);

		// sets the first day of week according to Calendar.
		// here we set Monday as the first day of the Calendar
		calendar.setFirstDayOfWeek(2);

		//The background color for the selected week.
		calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));
		
		//sets the color for the dates of an unfocused month. 
		calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.transparent));
	
		//sets the color for the separator line between weeks.
		calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.transparent));
		
		//sets the color for the vertical bar shown at the beginning and at the end of the selected date.
		calendar.setSelectedDateVerticalBar(R.color.darkgreen);
		
		//sets the listener to be notified upon selected date change.
		calendar.setOnDateChangeListener(new OnDateChangeListener() {
                       //show the selected date as a toast
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
				Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
			}
		});
	}


}
