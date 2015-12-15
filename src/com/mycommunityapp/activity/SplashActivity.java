package com.mycommunityapp.activity;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.mycommunityapp.R.layout;
import com.mycommunityapp.config.PreferenceConfig;
import com.mycommunityapp.R;
@SuppressLint("ShowToast")
public class SplashActivity extends Activity{
	// Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private String uName,pswd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		startLanuchingScreen();
	}
	private void startLanuchingScreen() {
	    new Handler().postDelayed(new Runnable() {
			 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
			public void run() {
				uName = PreferenceConfig.getUserName(getApplicationContext());
				pswd = PreferenceConfig.getPassword(getApplicationContext());
				Intent intent = null;
				if(!PreferenceConfig.isApplogOut(getApplicationContext())){
					intent = new Intent(SplashActivity.this,
							SignInActivity.class);
					
				}
				else if (uName.isEmpty()) {
					intent = new Intent(SplashActivity.this,
							SignInActivity.class);
				} else {
					intent = new Intent(SplashActivity.this, HomeActivity.class);
				}
				//intent = new Intent(SplashActivity.this, UserDetailsActivity.class);
				startActivity(intent);

				// close this activity
				finish();
			}
        }, SPLASH_TIME_OUT);
	}
	
	/** A method to start progress bar thread. **/
 	private void startProgressBarThread() {
 	// thread for displaying the SplashScreen
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                	int waited = 30;
                	int elapsedTime = 0;
                	Random random = new Random();
                    while (elapsedTime < 10000) {
                        sleep(500);
                        if (elapsedTime >= 10000) {
                        //	mProgressBarLoading.setProgress(100);
                        	break;
                        }
                        elapsedTime += 500;
                        waited = waited + random.nextInt(20);
                       // mProgressBarLoading.setProgress(waited);
                    }
                } catch(InterruptedException e) {
                    // do nothing
                	//Log.e(LOG_TAG, "Exception Message = " + e.getMessage());
                }
            }
        };
        splashTread.start();
 	}
 	


}

