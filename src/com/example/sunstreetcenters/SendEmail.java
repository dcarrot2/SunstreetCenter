package com.example.sunstreetcenters;

import android.content.Intent;

public class SendEmail {
	static private final String CHOOSER_TEXT = "Send email with: ";
	
	protected Intent sendEmailSunset()
	{
		Intent newEmail = new Intent(android.content.Intent.ACTION_SEND);
		
		newEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"info@sunstreet.org"});
		//newEmail.putExtra(Intent.EXTRA_SUBJECT,);
		newEmail.setType("plain/text");
		Intent createChooser = Intent.createChooser(newEmail, CHOOSER_TEXT);
		return createChooser;
	}
}
