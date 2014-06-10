package com.csitandroiddevelopers.sunstreetcenters;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.csitandroiddevelopers.sunstreetcenters.R;

public class TopNewsActivity extends Activity {
	private static final String[] links = 
		{"http://www.nytimes.com/2014/02/11/health/prescription-painkillers-seen-as-a-gateway-to-heroin.html?ref=prescriptiondrugabuse&_r=0",
		"http://www.nbcsandiego.com/news/local/Unwanted-Guests-Prescription-Drug-Thieves-Coming-to-Open-Houses-249638161.html#ixzz2vnMYIuIX",
		"http://www.nbcbayarea.com/news/california/CVS-Allegations-of-Missing-Hydrocodone-Prescription-Drugs-at-California-Pharmacies-249579241.html",
		"http://www.kionrightnow.com/news/local-news/santa-cruz-dad-explains-dangerous-affects-of-prescription-drug-abuse/24894156",
		"http://finance.yahoo.com/news/millennium-labs-helps-launch-coalition-234300591.html"};
		
	String number;
	
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
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.mainscreen, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {	
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	    
	    case R.id.salinasAdmin:
	    	
	    	number = "8317535135";
	    	callAlertDialog(number);
	    	return true;

	    case R.id.salinasResidential:
	    	
	    	number = "8317535145";
	    	callAlertDialog(number);
	    	return true;
	    
	    case R.id.salinasCounseling:
	    	
	    	number = "8317536001";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.salinasPrevention:
	    	
	    	number = "8317535150";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.seasidePrevention:
	    	
	    	number = "8318996577";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.soledadPrevention:
	    	
	    	number = "8313850100";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.marinaPueblo:
	    	
	    	number = "8315829461";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.salinasDUI:
	    	
	    	number = "8317535140";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.seasideDUI:
	    	
	    	number = "8313939316";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.soledadDUI:
	    	
	    	number = "8313850187";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.action_mail:
	    	Intent intent = new Intent(
	    		    Intent.ACTION_SENDTO,
	    		    Uri.parse("mailto:info@sunstreet.org")
	    		);
	    		startActivity(intent);
	    	return true;
	    	
	    case R.id.facebook:
	    	try {
	    	    Intent intentFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/286851634055"));
	    	    startActivity(intentFacebook);
	    	    return true;
	    	} catch(Exception e) {
	    	    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/SunStreetCenters")));
	    	    return true;
	    	}
		    
	    case R.id.twitter:
		    Intent intentTwitter = null;
		    try {
		        // get the Twitter app if possible
		        this.getPackageManager().getPackageInfo("com.twitter.android", 0);
		        intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=1648349780"));
		        intentTwitter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    } catch (Exception e) {
		        // no Twitter app, revert to browser
		        intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/SunStreetTweet"));
		        
		    }
		    this.startActivity(intentTwitter);
		    return true;
		    
	    case R.id.instagram:
	    	Uri uri = Uri.parse("http://instagram.com/_u/instasteps");
	        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

	        likeIng.setPackage("com.instagram.android");

	        try {
	            startActivity(likeIng);
	            return true;
	        } catch (ActivityNotFoundException e) {
	            startActivity(new Intent(Intent.ACTION_VIEW,
	                    Uri.parse("http://instagram.com/instasteps")));
	            return true;
	        }
	    case R.id.youtube:
	    	Intent intentYoutube=null;     
	    	try {
	    	        intentYoutube =new Intent(Intent.ACTION_VIEW);
	    	        intentYoutube.setPackage("com.google.android.youtube");
	    	        intentYoutube.setData(Uri.parse("http://www.youtube.com/user/SunStreetCentersORG/videos"));
	    	        startActivity(intentYoutube);
	    	        return true;
	    	    } catch (ActivityNotFoundException e) {
	    	        intentYoutube = new Intent(Intent.ACTION_VIEW);
	    	        intentYoutube.setData(Uri.parse("http://www.youtube.com/user/SunStreetCentersORG/videos"));
	    	        startActivity(intentYoutube);
	    	        return true;
	    	    }
	    	
	    	
	    case R.id.action_info:
	    	Intent location = new Intent(TopNewsActivity.this, Locations.class);
			startActivity(location);
	    	return true;
	    
	       
        default:
            return super.onOptionsItemSelected(item);
	    }
	    
	   
	}
	
	private void callAlertDialog(final String x)
	{
		AlertDialog.Builder builder = new Builder(TopNewsActivity.this);
		builder.setMessage("Are you sure you want to launch your phone app?");
		builder.setTitle("Confirmation:");


		builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});	

		builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
		    	intent.setData(Uri.parse("tel:"+ x));
		    	startActivity(intent); 
			}
		});	
		

		builder.create().show();
	}
	
	private void openLink(String url){
		Uri newsPage = Uri.parse(url);
		Intent visitTwitter = new Intent(Intent.ACTION_VIEW, newsPage);
		String textChooser = "Load " + url + " with:";
		Intent chooseTweet = Intent.createChooser(visitTwitter, textChooser);
		startActivity(chooseTweet);
	}
}
