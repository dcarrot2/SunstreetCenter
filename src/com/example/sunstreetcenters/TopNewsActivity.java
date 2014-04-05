package com.example.sunstreetcenters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.sunstreetcenters.R;

public class TopNewsActivity extends Activity {
	private static final String[] links = 
		{"http://www.nytimes.com/2014/02/11/health/prescription-painkillers-seen-as-a-gateway-to-heroin.html?ref=prescriptiondrugabuse&_r=0",
		"http://www.nbcsandiego.com/news/local/Unwanted-Guests-Prescription-Drug-Thieves-Coming-to-Open-Houses-249638161.html#ixzz2vnMYIuIX",
		"http://www.nbcbayarea.com/news/california/CVS-Allegations-of-Missing-Hydrocodone-Prescription-Drugs-at-California-Pharmacies-249579241.html",
		"http://www.kionrightnow.com/news/local-news/santa-cruz-dad-explains-dangerous-affects-of-prescription-drug-abuse/24894156",
		"http://finance.yahoo.com/news/millennium-labs-helps-launch-coalition-234300591.html"};
		
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top_news);
		Button linkOneButton = (Button) findViewById(R.id.linkOneButton);
		Button linkTwoButton = (Button) findViewById(R.id.linkTwoButton);
		Button linkThreeButton = (Button) findViewById(R.id.linkThreeButton);
		Button linkFourButton = (Button) findViewById(R.id.linkFourButton);
		Button linkFiveButton = (Button) findViewById(R.id.linkFiveButton);

		linkOneButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openLink(links[0]);
			}
		});

		linkTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openLink(links[1]);
			}
		});
		linkThreeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openLink(links[2]);
			}
		});
		linkFourButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openLink(links[3]);
			}
		});
		
		linkFiveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openLink(links[4]);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.top_news, menu);
		return true;
	}
	
	private void openLink(String url){
		Uri newsPage = Uri.parse(url);
		Intent visitTwitter = new Intent(Intent.ACTION_VIEW, newsPage);
		String textChooser = "Load " + url + " with:";
		Intent chooseTweet = Intent.createChooser(visitTwitter, textChooser);
		startActivity(chooseTweet);
	}
}
