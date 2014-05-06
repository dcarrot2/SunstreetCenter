package com.example.sunstreetcenters;


	import android.os.Bundle;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.Button;
	//import android.widget.TextView;
	import android.app.Activity;

public class ContactInfo extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.contact_info);

		Button visitSunStreet = (Button) findViewById(R.id.visitWebsite);
		Button emailSunStreet = (Button) findViewById(R.id.contactEmail);
		Button callSunStreet = (Button) findViewById(R.id.callNumber);
		//TextView contentTitle = (TextView) findViewById(R.id.contactInformationTextView);

		visitSunStreet.setOnClickListener(new OnClickListener() {

			// Call prescriptionActivity when pressed.

			public void onClick(View v) {
				createWebLink();
			}
		});

		emailSunStreet.setOnClickListener(new OnClickListener() {
			// Send email to SunsetStreet
			public void onClick(View v) {
				sendEmail();
			}
		});

		callSunStreet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callNumber();
			}
		});

	}

	private void createWebLink() {
		SunsetWebsite secondLink = new SunsetWebsite();
		startActivity(secondLink.linkToSite());
	}

	private void sendEmail() {
		SendEmail emailSunStreet = new SendEmail();
		startActivity(emailSunStreet.sendEmailSunset());
	}

	private void callNumber() {
		CallSunstreet makeCall = new CallSunstreet();
		startActivity(makeCall.callSunsetCenter());
	}

}
