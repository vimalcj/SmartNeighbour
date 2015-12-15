package com.mycommunityapp.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mycommunityapp.R;
import com.mycommunityapp.R.id;
import com.mycommunityapp.R.layout;
import com.mycommunityapp.config.PreferenceConfig;

public class UserDetailsActivity extends Activity{
	private RelativeLayout block1,block2;
	private Button next,back;
	private EditText name,email,phoneno,dob;
	private EditText blockNo,flatNo,floorNo,tower;
	private Context context=this;
	private RadioGroup rGroup1,rGroup2;
	private RadioButton owner,tenant;
	private RadioButton male,female;
	private String genType="Male",resType="Owner";	
	private Calendar myCalendar;
	private int requestCode=-1;
	private String emailOrPhone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userdetails_screen);
	    block1=(RelativeLayout)findViewById(R.id.rel_center);
	    block2=(RelativeLayout)findViewById(R.id.rel_center2);
	    next=(Button)findViewById(R.id.button_done);
	    back=(Button)findViewById(R.id.back);
	    name=(EditText)findViewById(R.id.editText_Name);
	    email=(EditText)findViewById(R.id.editText_Email);
	    phoneno=(EditText)findViewById(R.id.editText_phone);
	    dob=(EditText)findViewById(R.id.editText_dob);
	    blockNo=(EditText)findViewById(R.id.editText_block);
	    flatNo=(EditText)findViewById(R.id.editText_flat);
	    floorNo=(EditText)findViewById(R.id.editText_floor);
	    tower=(EditText)findViewById(R.id.editText_tower);
	    rGroup1=(RadioGroup)findViewById(R.id.sex);
	    rGroup2=(RadioGroup)findViewById(R.id.rType);
	    male=(RadioButton)findViewById(R.id.Male);
	    female=(RadioButton)findViewById(R.id.female);
	    owner=(RadioButton)findViewById(R.id.owner);
	    tenant=(RadioButton)findViewById(R.id.tenant);
	    
	    emailOrPhone=PreferenceConfig.getUserName(context);
		if (!emailOrPhone.isEmpty()) {
			try {
				Long phoneLong = Long.parseLong(emailOrPhone);
				if (null != phoneLong) {
					phoneno.setText(emailOrPhone);
				}
			} catch (Exception e) {
				email.setText(emailOrPhone);
			}
		}
	    next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				block1.setVisibility(View.GONE);
				block2.setVisibility(View.VISIBLE);				
				if(next.getText().toString().equals("Done")){				
					//next.setText("Next");					
					PreferenceConfig.setTower(tower.getText().toString(), context);
					PreferenceConfig.setFlatNo(flatNo.getText().toString(), context);
					PreferenceConfig.setFloorNo(floorNo.getText().toString(), context);
					PreferenceConfig.setBlockNo(blockNo.getText().toString(), context);
					PreferenceConfig.setResType(resType.toString(), context);
					PreferenceConfig.setIsAppLogOut(true, getApplicationContext());
					Intent intent=new Intent(UserDetailsActivity.this,HomeActivity.class);
					startActivity(intent);
					finish();
					
				}else if(next.getText().toString().equals("Next")){
					block1.setVisibility(View.GONE);
					block2.setVisibility(View.VISIBLE);
					next.setText("Done");
					genType=male.getText().toString();
					PreferenceConfig.setName(name.getText().toString(), context);
					PreferenceConfig.setPhoneNo(phoneno.getText().toString(), context);
					PreferenceConfig.setDOB(dob.getText().toString(), context);
					PreferenceConfig.setGenType(genType.toString(), context);
					PreferenceConfig.setUserName(email.getText().toString(), context);
				}
			}
		});
	    back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PreferenceConfig.setIsAppLogOut(true, getApplicationContext());
				if(next.getText().toString().equals("Next")){								
					genType=male.getText().toString();
					PreferenceConfig.setName(name.getText().toString(), context);
					PreferenceConfig.setPhoneNo(phoneno.getText().toString(), context);
					PreferenceConfig.setDOB(dob.getText().toString(), context);
					PreferenceConfig.setGenType(genType.toString(), context);
					PreferenceConfig.setUserName(email.getText().toString(), context);
				    Intent intent=new Intent(UserDetailsActivity.this,SignUpActivity.class);
				    startActivity(intent);
				    finish();
				}else if(next.getText().toString().equals("Done")){
					block1.setVisibility(View.VISIBLE);
					block2.setVisibility(View.GONE);
					next.setText("Next");
					PreferenceConfig.setName(name.getText().toString(), context);
					PreferenceConfig.setPhoneNo(phoneno.getText().toString(), context);
					PreferenceConfig.setDOB(dob.getText().toString(), context);
					PreferenceConfig.setGenType(genType.toString(), context);
					PreferenceConfig.setUserName(email.getText().toString(), context);
					name.setText(PreferenceConfig.getName(context));
					email.setText(PreferenceConfig.getUserName(context));
					phoneno.setText(PreferenceConfig.getPhoneNo(context));
					dob.setText(PreferenceConfig.getDOB(context));
					male.setText(PreferenceConfig.getGenType(context));
					
					
				}
				
			}
		});
	   
	    /* Attach CheckedChangeListener to radio group */
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if(null!=rb && checkedId > -1){
                    Toast.makeText(UserDetailsActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    genType=rb.getText().toString();
                }

            }
        });	  
        /* Attach CheckedChangeListener to radio group */
        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if(null!=rb && checkedId > -1){
                    Toast.makeText(UserDetailsActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    resType=rb.getText().toString();
                }

            }
        });	  
        
        myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear,
                    int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                datePicker.setMaxDate(myCalendar.getTimeInMillis());
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                dob.setText(sdf.format(myCalendar.getTime()));
               
            }

        };

           dob.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(UserDetailsActivity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });

             
	}
	
	 
	}

