package com.mycommunityapp.activity;

import com.mycommunityapp.R;
import com.mycommunityapp.R.id;
import com.mycommunityapp.R.layout;
import com.mycommunityapp.R.style;
import com.mycommunityapp.config.DialogConfig;
import com.mycommunityapp.config.PreferenceConfig;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends Activity {
	private EditText email, password, confirmPswd;
	private Button signUpButton;
	private AlertDialog mAlertDialog;
	private TextView signin,contactUs;
	private Context context=this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_screen);
		signin = (TextView) findViewById(R.id.signIn);
		email = (EditText) findViewById(R.id.editText_phone_no);
		password = (EditText) findViewById(R.id.editText_enter_pswd);
		confirmPswd = (EditText) findViewById(R.id.confirm_pswd);
		signUpButton = (Button) findViewById(R.id.signupButton);
		contactUs = (TextView) findViewById(R.id.contactUs);

		if(!PreferenceConfig.isApplogOut(context)){
			//return;
		}
		else if(!PreferenceConfig.getPassword(getApplicationContext()).isEmpty()){
			password.setText(PreferenceConfig.getPassword(context));
			email.setText(PreferenceConfig.getUserName(context));
			confirmPswd.setText(PreferenceConfig.getConfirmPassword(context));
		}
		signUpButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (email.getText().toString().isEmpty()
						|| password.getText().toString().isEmpty()
						|| confirmPswd.getText().toString().isEmpty()) {
					showCustomDialog(DialogConfig.DIALOG_VALUE_MISSING);
					return;
				} else if (!password.getText().toString()
						.equals(confirmPswd.getText().toString())) {
					showCustomDialog(DialogConfig.DIALOG_MISMATCH);
					return;
				} else {
					PreferenceConfig.setUserName(email.getText().toString(),
							getApplicationContext());
					PreferenceConfig.setPassword(password.getText().toString(),
							getApplicationContext());
					PreferenceConfig.setConfirmPassword(confirmPswd.getText()
							.toString(), getApplicationContext());
					PreferenceConfig.setIsAppLogOut(true, getApplicationContext());
					Intent intent = new Intent(SignUpActivity.this,
							HomeActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});
		signin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignUpActivity.this,
						SignInActivity.class);
				startActivity(intent);
				finish();
			}
		});

		contactUs.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignUpActivity.this,
						SignInActivity.class);
				startActivity(intent);
				//finish();
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
		case DialogConfig.DIALOG_VALUE_MISSING:
			// dlg.setIcon(R.drawable.icon)
			// .setTitle(R.string.app_name)
			dlg.setMessage("Some value is missing")
					.setCancelable(false)
					.setPositiveButton(android.R.string.ok,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
									//SignUpActivity.this.finish();
								}
							});
			break;
		case DialogConfig.DIALOG_MISMATCH:
			dlg.setMessage("Password and Confirm password are not same")
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

}
