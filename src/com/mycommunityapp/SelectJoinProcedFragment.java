package com.mycommunityapp;

import com.mycommunityapp.config.PreferenceConfig;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectJoinProcedFragment extends Fragment{
	private AutoCompleteTextView communityName;
	private AutoCompleteTextView address;
	private Button proceed,done,addfile;
	private RelativeLayout rel1,rel2;
	private RadioGroup rGroup1,rGroup2;
	private RadioButton owner,tenant;
	private AutoCompleteTextView blockNo,flatNo,floorNo,tower;
	private String resType="Owner";
	private static int LOAD_IMAGE_RESULTS = 1;
	private int RESULT_OK=1;
	private ImageView image;
	private ScrollView scl;
	private  String imagePath;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	

	@Override
    public View onCreateView(LayoutInflater inflater, 
              ViewGroup container, Bundle savedInstanceState) {
		
		 String[] community = { "SFS", "Concore", "Slapuria", "Prestige", "Marigold", "Perl",
	                "Embassy", "Small-Talk", "URC", "Ruby", "ASP", "Bhagirth" };
		 String[] addressCommunity = { "Madiwala", "Sarjapur", "BenargattaRoad", "Aalappy", "Chennai", "Domlur",
	                "Madurai", "Ooty", "RamanNagar", "Ruby", "Hosur", "Audigodi" }; 

        View view = inflater.inflate(R.layout.join_proceed_fragment, 
                   container, false);
        
        rel1=(RelativeLayout)view.findViewById(R.id.rr1);
        rel2=(RelativeLayout)view.findViewById(R.id.rr2);
        scl=(ScrollView)view.findViewById(R.id.scroll);
        communityName = (AutoCompleteTextView)view. findViewById(R.id.autocompleteCommunityName);
        address = (AutoCompleteTextView)view. findViewById(R.id.autocompleteAddress);
        proceed=(Button)view.findViewById(R.id.proceed);
        done=(Button)view.findViewById(R.id.done);
        blockNo=(AutoCompleteTextView)view.findViewById(R.id.editText_block);
	    flatNo=(AutoCompleteTextView)view.findViewById(R.id.editText_flat);
	    floorNo=(AutoCompleteTextView)view.findViewById(R.id.editText_floor);
	    //tower=(AutoCompleteTextView)view.findViewById(R.id.editText_tower);
	    rGroup1=(RadioGroup)view.findViewById(R.id.sex);
	    rGroup2=(RadioGroup)view.findViewById(R.id.rType);
	    owner=(RadioButton)view.findViewById(R.id.owner);
	    tenant=(RadioButton)view.findViewById(R.id.tenant);
	    addfile=(Button)view.findViewById(R.id.addIDFile);
	    image=(ImageView)view.findViewById(R.id.dTxt);
	    


        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,community);
        //Used to specify minimum number of 
               //characters the user has to type in order to display the drop down hint.
        communityName.setThreshold(1);
        //Setting adapter
        communityName.setAdapter(adapter);
             
        ArrayAdapter adapteraddress = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,addressCommunity);
        //Used to specify minimum number of 
               //characters the user has to type in order to display the drop down hint.
        address.setThreshold(1);
        //Setting adapter
        address.setAdapter(adapteraddress);
       // rel1.setVisibility(View.VISIBLE);
       // rel2.setVisibility(View.GONE);
       
        
        
        proceed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rel1.setVisibility(View.GONE);
				scl.setVisibility(View.VISIBLE);
				done.setVisibility(View.VISIBLE);
				
			}
		});
        
        done.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//rel1.setVisibility(View.GONE);
				//PreferenceConfig.setTower(tower.getText().toString(), getActivity());
				PreferenceConfig.setFlatNo(flatNo.getText().toString(), getActivity());
				PreferenceConfig.setFloorNo(floorNo.getText().toString(), getActivity());
				PreferenceConfig.setBlockNo(blockNo.getText().toString(), getActivity());
				PreferenceConfig.setResType(resType.toString(), getActivity());
				PreferenceConfig.setIDFilePath(imagePath, getActivity());
				PreferenceConfig.setIsJoinStatus(true, getActivity());
				getActivity().finish();
				
			}
		});
        addfile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				 Intent intent = new Intent();
//                 intent.setType("image/*");
//                 intent.setAction(Intent.ACTION_GET_CONTENT);
//                 startActivityForResult(Intent.createChooser(intent,
//                         "Select Picture"), LOAD_IMAGE_RESULTS);
                 Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                 photoPickerIntent.setType("image/*");
                 startActivityForResult(photoPickerIntent, LOAD_IMAGE_RESULTS);
			}
		});
        return view;
    }

	 
	 @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        System.out.println("requestCode------------"+requestCode);
	        System.out.println("resultCode------------"+resultCode);
	        System.out.println("data------------"+data);
	         
	        // Here we need to check if the activity that was triggers was the Image Gallery.
	        // If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
	        // If the resultCode is RESULT_OK and there is some data we know that an image was picked.
	        if (requestCode == LOAD_IMAGE_RESULTS  && data != null) {
	            // Let's read picked image data - its URI
	            Uri pickedImage = data.getData();
	            // Let's read picked image path using content resolver
	            String[] filePath = { MediaStore.Images.Media.DATA };
	            Cursor cursor =getActivity().getContentResolver().query(pickedImage, filePath, null, null, null);
	            cursor.moveToFirst();
	            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));
	            Toast.makeText(getActivity(), "Image Path"+imagePath, Toast.LENGTH_SHORT).show(); 
	           
	            // Now we need to set the GUI ImageView data with data read from the picked file.
	            image.setImageBitmap(BitmapFactory.decodeFile(imagePath));
	            addfile.setText("Change file");
//	            if(PreferenceConfig.isJoinStatus(getActivity())){
	            	rel1.setVisibility(View.GONE);
	    			scl.setVisibility(View.VISIBLE);
	    			done.setVisibility(View.VISIBLE);		
//	            	
//	            }
//	            else{
//	            	scl.setVisibility(View.GONE);
//	            	rel1.setVisibility(View.VISIBLE);
//	            	done.setVisibility(View.GONE);
//	            }
	             
	            // At the end remember to close the cursor or you will end with the RuntimeException!
	            cursor.close();
	        }
	    }
}
