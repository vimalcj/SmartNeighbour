package com.mycommunityapp;

import com.mycommunityapp.activity.SelectJoinActivity;
import com.mycommunityapp.config.PreferenceConfig;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class JoinCommunityFragment extends Fragment {
	private TextView pStatus;;
	private RelativeLayout rel1;
	public JoinCommunityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_joincommunity, container, false);
		Button joinBtn=(Button)rootView.findViewById(R.id.joinButton);
		pStatus=(TextView)rootView.findViewById(R.id.status);
		rel1=(RelativeLayout)rootView.findViewById(R.id.rr1);

		if(PreferenceConfig.isJoinStatus(getActivity())){
        	pStatus.setVisibility(View.VISIBLE);
        	rel1.setVisibility(View.GONE);			
        	
        }
        else{
        	pStatus.setVisibility(View.GONE);
        	rel1.setVisibility(View.VISIBLE);
        }
		joinBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getActivity(),SelectJoinActivity.class);
				getActivity().startActivity(intent);
			}
		});

		return rootView;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onPause();
		if(PreferenceConfig.isJoinStatus(getActivity())){
        	pStatus.setVisibility(View.VISIBLE);
        	rel1.setVisibility(View.GONE);			
        	
        }
        else{
        	pStatus.setVisibility(View.GONE);
        	rel1.setVisibility(View.VISIBLE);
        }
	}

}
