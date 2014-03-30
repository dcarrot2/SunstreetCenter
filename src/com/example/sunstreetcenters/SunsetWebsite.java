package com.example.sunstreetcenters;

import android.content.Intent;
import android.net.Uri;

public class SunsetWebsite {
	//parent class for websites
		static private final String URL = "http://sunstreetcenters.org"; //URL STRING
		
		static private final String CHOOSER_TEXT = "Load " + URL + " with:"; //IMPLICIT BOX TEXT
		
		protected Intent linkToSite ()
		{
			Uri webpage = Uri.parse(URL);
			Intent visitWebsite = new Intent(Intent.ACTION_VIEW, webpage);
			
			Intent chooserIntent = Intent.createChooser(visitWebsite, CHOOSER_TEXT);
			return chooserIntent;
		}
}
