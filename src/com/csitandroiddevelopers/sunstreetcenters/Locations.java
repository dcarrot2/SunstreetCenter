package com.csitandroiddevelopers.sunstreetcenters;

import com.csitandroiddevelopers.sunstreetcenters.R;

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
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class Locations extends Activity {

	ExpandableListView exv;
	String number;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locations);
		
		exv = (ExpandableListView)findViewById(R.id.expandableListView1);
		exv.setAdapter(new MyAdapter(this));
		exv.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					final int groupPosition, final int childPosition, long id) {
				
				AlertDialog.Builder builder = new AlertDialog.Builder(Locations.this);
				builder.setMessage("Would you like to get Directions to this address? ");
				builder.setTitle("Confirmation:");
				builder.setIcon(R.drawable.googlemaps_icon);
				
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						String address = MyAdapter.childList[groupPosition][childPosition];
						String temp = "";
						String addressForMap = "";
						int count = 0,
							onlyOnce = 0;
						for(int c = 0; c < address.length(); c++)
						{		
							
							if(address.charAt(c) == ',')
								count++;
							
							if(count == 2)
							{
								for(int i = 0; i < c; i++)
								{
									if(address.charAt(i) == ',' )
									{
										temp += '+';
										i++;
									}
									else
										temp += address.charAt(i);
								}
								break;
							}
						}
						
						for(int g = 0; g < temp.length(); g++)
						{
							if(onlyOnce == 0 && temp.charAt(g) == ' ')
							{
								addressForMap += '+';
								onlyOnce++;
							}
							else
								addressForMap += temp.charAt(g);
						}
						
						Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
								Uri.parse("google.navigation:q=" + addressForMap));
						intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
				        try
				        {
				            startActivity(intent);
				        }
				        catch(ActivityNotFoundException ex)
				        {
				            try
				            {
				                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(addressForMap));
				                startActivity(unrestrictedIntent);
				            }
				            catch(ActivityNotFoundException innerEx)
				            {
				                Toast.makeText(getBaseContext(), "Please install a maps application", Toast.LENGTH_LONG).show();
				            }
				        }
					}
				});	

				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				
				AlertDialog alert11 = builder.create();
	            alert11.show();
				
				return false;
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.locations, menu);
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
	    	
	    case R.id.website:
			SunsetWebsite websiteLink = new SunsetWebsite();
			startActivity(websiteLink.linkToSite());	
	    	
        default:
            return super.onOptionsItemSelected(item);
	    }
	    
	   
	}
	
	private void callAlertDialog(final String x)
	{
		AlertDialog.Builder builder = new Builder(Locations.this);
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
	
}
