package com.mycommunityapp.activity;

import java.util.Random;

import com.mycommunityapp.R;
import com.mycommunityapp.R.id;
import com.mycommunityapp.R.layout;
import com.mycommunityapp.R.style;
import com.mycommunityapp.config.DialogConfig;
import com.mycommunityapp.config.PreferenceConfig;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class SignInActivity extends Activity {
	private Button signInButton;
	private TextView createAccount, forgotPswd, contactUs;
	private EditText email, password;
	private int requestCode = 0;
	private String uName = null, pswd = null;
	private AlertDialog mAlertDialog;
	final private Context context = this;
	private String testUsername = "abc";
	private String testPassword = "abc";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin_screen);
		signInButton = (Button) findViewById(R.id.signIn);
		createAccount = (TextView) findViewById(R.id.signUp);
		forgotPswd = (TextView) findViewById(R.id.forgot_pswd);
		email = (EditText) findViewById(R.id.editText_phone_no);
		password = (EditText) findViewById(R.id.editText_password);
		contactUs = (TextView) findViewById(R.id.contactUs);
//		Typeface face = Typeface.createFromAsset(getAssets(),
//	            "fonts/txtfont.ttf");
//		signInButton.setTypeface(face);
//		createAccount.setTypeface(face);
//		forgotPswd.setTypeface(face);
//		email.setTypeface(face);
//		password.setTypeface(face);
//		contactUs.setTypeface(face);
		signInButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				uName = PreferenceConfig.getUserName(getApplicationContext());
				pswd = PreferenceConfig.getPassword(getApplicationContext());
				if (testUsername.equalsIgnoreCase(email.getText()
						.toString())
						&& testPassword.equalsIgnoreCase(password.getText()
								.toString())) {
					PreferenceConfig.setUserName(testUsername, context);
					PreferenceConfig.setPassword(testPassword, context);
					PreferenceConfig.setIsAppLogOut(true,
							getApplicationContext());
					Intent intent = new Intent(SignInActivity.this,
							HomeActivity.class);

					startActivity(intent);
					// close this activity
					finish();
				}
			/*	
				if (email.getText().toString().isEmpty()
						|| password.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							"User Name or Password is Empty",
							Toast.LENGTH_SHORT).show();
					return;
				} else if (null == uName || uName.isEmpty() || null == pswd
						|| pswd.isEmpty()) {
					showCustomDialog(DialogConfig.DIALOG_NO_ACCOUNT);
					// Toast.makeText(getApplicationContext(),
					// "User do not have an account please create a new account",
					// Toast.LENGTH_SHORT).show();
					return;
				} else if (testUsername.equalsIgnoreCase(email.getText()
						.toString())
						&& testPassword.equalsIgnoreCase(password.getText()
								.toString())) {
					PreferenceConfig.setUserName(testUsername, context);
					PreferenceConfig.setPassword(testPassword, context);
					PreferenceConfig.setIsAppLogOut(true,
							getApplicationContext());
					Intent intent = new Intent(SignInActivity.this,
							HomeActivity.class);

					startActivity(intent);
					// close this activity
					finish();
				}

				else if (uName.equalsIgnoreCase(email.getText().toString())
						&& pswd.equalsIgnoreCase(password.getText().toString())) {
					// TODO Auto-generated method stub
					PreferenceConfig.setIsAppLogOut(true,
							getApplicationContext());
					Intent intent = new Intent(SignInActivity.this,
							HomeActivity.class);

					startActivity(intent);
					// close this activity
					finish();
				} */else {
					showCustomDialog(DialogConfig.DIALOG_NOT_REGISTERED);
					Toast.makeText(getApplicationContext(),
							"User Name or Password is Invalid",
							Toast.LENGTH_SHORT);
				}

			}
		});
//		signInButton.setOnTouchListener(new OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// TODO Auto-generated method stub
//				getWindow()
//						.setSoftInputMode(
//								WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//				signInButton.setFocusableInTouchMode(true);
//				signInButton.setFocusable(true);
//				return false;
//			}
//		});
		createAccount.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
				startActivity(i);
				// close this activity
				finish();

			}
		});
		forgotPswd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		contactUs.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignInActivity.this,
						ContactUsActivity.class);
				startActivity(intent);
				// finish();
			}
		});

	}

	/** Method to show dialog on the basis of different dialog ids. */
	private void showCustomDialog(final int id) {
		ContextThemeWrapper themedContext;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			themedContext = new ContextThemeWrapper(this, R.style.dialog_theme);
		} else {
			themedContext = new ContextThemeWrapper(this, R.style.popup_theme);
		}
		AlertDialog.Builder dlg = new AlertDialog.Builder(themedContext);
		dlg.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode,
					KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_SEARCH
						&& event.getRepeatCount() == 0) {
					return true;
				}
				return false;
			}
		});

		switch (id) {
		case DialogConfig.DIALOG_NOT_REGISTERED:
			// dlg.setIcon(R.drawable.icon)
			// .setTitle(R.string.app_name)
			dlg.setMessage("User is not registered...")
					.setCancelable(false)
					.setPositiveButton(android.R.string.ok,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
									// SignInActivity.this.finish();
								}
							});
			break;
		case DialogConfig.DIALOG_NO_ACCOUNT:
			// dlg.setIcon(R.drawable.icon)
			// .setTitle(R.string.app_name)
			dlg.setMessage(
					"User do not have an account please create a new account")
					.setCancelable(false)
					.setPositiveButton(android.R.string.ok,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();

								}
							});
			break;
		}
		mAlertDialog = dlg.create();
		mAlertDialog.show();
	}

	/** Method to dismiss any active {@link AlertDialog}. */
	private void dismissActiveDialog() {
		if (mAlertDialog != null && mAlertDialog.isShowing()) {
			mAlertDialog.dismiss();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1) {
			finish();
		}
	}

}
