package com.csitandroiddevelopers.sunstreetcenters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import com.csitandroiddevelopers.sunstreetcenters.Mainscreen;

import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Mainscreen extends Activity {

	
	//Test commit to check network path
	static InputStream is = null;
    static JSONObject jObj = null;
    static String jsonin = "";
	private static final String TAG = "SendingJSON";
	String number;
	ListView list;
	String[] listItems = {
		    "Drug Brochures", 
		    "BAC Calculator",
		    "Info for Parents",
	        "Sliding Puzzle Game",
	        "Locations",
	        "Top News"
		  } ;
	Integer[] imageId = {
		      R.drawable.brochure2d,
		      R.drawable.calculator2d,
		      R.drawable.info_icon2d,
		      R.drawable.control2d,
		      R.drawable.location2d,
		      R.drawable.news2d
		  };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);
		Runtime rt = Runtime.getRuntime();
		long maxMemory = rt.maxMemory();
		Log.d("onCreate", "maxMemory: " + Long.toString(maxMemory));
				CustomList adapter = new
				CustomList(Mainscreen.this, listItems, imageId);
				list=(ListView)findViewById(R.id.list);
		    
		        // Assign adapter to ListView
		        list.setAdapter(adapter); 
		        // ListView Item Click Listener
	            list.setOnItemClickListener(new OnItemClickListener() {
	 
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
							if(position == 0){
								
								Intent features = new Intent(Mainscreen.this,AllBrochures.class);
								startActivity(features);
								
							}
							else if(position == 1){
								Intent features = new Intent(Mainscreen.this,ExtraFeatures.class);
								startActivity(features);
							}
							else if(position == 2){
								Intent parents = new Intent(Mainscreen.this,InfoForParents.class);
								startActivity(parents);
							}
							else if(position == 3){
								Intent game = new Intent(Mainscreen.this,PictureTakerActivity.class);
								startActivity(game);
							}
							else if(position == 4){
								Intent locations = new Intent(Mainscreen.this, Locations.class);
								startActivity(locations);
							}
							else if(position == 5){
								Intent news = new Intent(Mainscreen.this, TopNewsActivity.class);
								startActivity(news);
							}
							
							
					}
	    
	             }); 
	            
	            
	         SharedPreferences prefs;
	   		 prefs = getSharedPreferences("nbRepet", MODE_PRIVATE);      
	   		 int value = prefs.getInt("nbRepet", 0);
	   		 
	   		switch(value)
	   		{
	   		case 1:
	   			sendJson("9-13");
	   			break;
	   		case 2:
	   			sendJson("14-18");
	   			break;
	   		case 3:
	   			sendJson("19+");
	   		}
	         }

	

	@Override

	public void onBackPressed() {
		this.finish();
	}
	
	public String getJson(HttpEntity httpEntity) {				

		try {

			is = httpEntity.getContent();          
			Log.d(TAG, "Got Content from Entity");
           //lists of exceptions
		} catch (UnsupportedEncodingException e) {
			Log.d(TAG, "Caught Exception");
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			Log.d(TAG, "Caught Exception");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d(TAG, "Caught Exception");
			e.printStackTrace();
		}
         
		try {
			//inputsteamreader decondes into 8 single-byte graphic characters
			//and the buffreader reads the text from the input stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			jsonin = sb.toString();
			Log.d(TAG, "String created");
		} catch (Exception e) {
			Log.d(TAG, "Caught Exception");
			Log.e("Buffer Error", "Error converting result " + e.toString());
		}
		Log.d(TAG, "Json String returned");
		return jsonin;
    }
	
	public void sendJson(final String age) {
		Thread t = new Thread() {

			public void run() {
				HttpClient client = new DefaultHttpClient();
				HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
				//HttpResponse response;
	            JSONObject json = new JSONObject();

	            try {
	            	HttpPost post = new HttpPost("http://sunstreetnews.pythonanywhere.com/topnews/requestFromAndroid/");
	            	json.put("Age", age);
	            	StringEntity se = new StringEntity( json.toString());  
	            	se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
	            	post.setEntity(se);
	            	HttpResponse response = 
	            			client.execute(post);
	            	HttpEntity httpEntity = response.getEntity();
	    			jsonin = getJson(httpEntity);     
	            	Log.d(TAG, "JSON file posted");
         

	            } catch(Exception e) {
	            	e.printStackTrace();
	            	//logs to track if connection was established
	            	Log.d(TAG, "Caught Exception");
	            	Log.d(TAG, "Cannot Establish Connection");
	            }

			}
		};
		t.start();      
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
	    	
	    case R.id.website:
			SunsetWebsite websiteLink = new SunsetWebsite();
			startActivity(websiteLink.linkToSite());
	    	       
        default:
            return super.onOptionsItemSelected(item);
	    }
	    
	   
	}
	
	private void callAlertDialog(final String x)
	{
		AlertDialog.Builder builder = new Builder(Mainscreen.this);
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