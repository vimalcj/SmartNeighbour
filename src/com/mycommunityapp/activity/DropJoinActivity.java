package com.mycommunityapp.activity;

import com.mycommunityapp.R;
import com.mycommunityapp.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;

public class DropJoinActivity extends FragmentActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drop_activity);
		getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>"+"Find Drop Journey"+" </font>"));
	}

}
