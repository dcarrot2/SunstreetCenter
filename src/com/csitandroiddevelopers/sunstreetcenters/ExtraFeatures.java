package com.csitandroiddevelopers.sunstreetcenters;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.csitandroiddevelopers.sunstreetcenters.R;

public class ExtraFeatures extends Activity {
	private static final String WEIGHT = "WEIGHT";
	
	String number;

	private double weight;
	private double bac;
	private EditText weightEditText;
	private EditText beerOz;
	private EditText wineOz;
	private EditText liquorOz;
	private EditText hours;
	private EditText alcoholContent;

	private TextView sex;
	private TextView weightText;
	private TextView beer;
	private TextView wine;
	private TextView liquor;
	private TextView time;
	private TextView bloodAlcohol;

	private int numBeers;
	private int numWine;
	private int numLiquor;
	private int numTime;

	private boolean male;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_extra_features);
		
		
		Button reset = (Button) findViewById(R.id.resetButton);
		Button calculate = (Button) findViewById(R.id.calculateButton);
		Button beerOne = (Button) findViewById(R.id.beerPlusButton);
		Button beerTwo = (Button) findViewById(R.id.beerMinusButton);
		Button wineOne = (Button) findViewById(R.id.winePlusButton);
		Button wineTwo = (Button) findViewById(R.id.wineMinusButton);
		Button liquorOne = (Button) findViewById(R.id.liquorPlusButton);
		Button liquorTwo = (Button) findViewById(R.id.liquorMinusButton);
		Button hoursOne = (Button) findViewById(R.id.timePlusButton);
		Button hoursTwo = (Button) findViewById(R.id.timeMinusButton);
		Switch gender = (Switch) findViewById(R.id.maleFemaleSwitch);

		if (savedInstanceState == null) {
			weight = 0.0;

		} else {
			weight = savedInstanceState.getDouble(WEIGHT);
		}
		// get all the edit text displaying 0's
		beerOz = (EditText) findViewById(R.id.beerEditText);
		wineOz = (EditText) findViewById(R.id.wineEditText);
		liquorOz = (EditText) findViewById(R.id.liquorEditText);
		hours = (EditText) findViewById(R.id.timeEditText);
		alcoholContent = (EditText) findViewById(R.id.bacEditText);
		weightEditText = (EditText) findViewById(R.id.weightEditText);
		
		
		weightEditText.addTextChangedListener(weightEditTextWatcher);
		
		sex = (TextView) findViewById(R.id.sexTextView);
		weightText = (TextView) findViewById(R.id.weightTextView);
		beer = (TextView) findViewById(R.id.beerTextView);
		wine = (TextView) findViewById(R.id.wineTextView);
		liquor = (TextView) findViewById(R.id.LiquorTextView);
		time = (TextView) findViewById(R.id.timeTextView);
		bloodAlcohol = (TextView) findViewById(R.id.bacTextView);

		beerOne.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {

				numBeers++;
				beerOz.setText(String.valueOf(numBeers));

			}
		});
		beerTwo.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {
				if (numBeers == 0) {
					numBeers = 0;
					beerOz.setText(String.valueOf(numBeers));
				} else {
					numBeers--;
					beerOz.setText(String.valueOf(numBeers));
				}
			}
		});
		wineOne.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {

				numWine++;
				wineOz.setText(String.valueOf(numWine));

			}
		});
		wineTwo.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {
				if (numWine == 0) {
					numWine = 0;
					wineOz.setText(String.valueOf(numWine));
				} else {
					numWine--;
					wineOz.setText(String.valueOf(numWine));
				}
			}
		});
		liquorOne.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {
				numLiquor++;
				liquorOz.setText(String.valueOf(numLiquor));
			}
		});
		liquorTwo.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {
				if (numLiquor == 0) {
					numLiquor = 0;
					liquorOz.setText(String.valueOf(numLiquor));
				} else {
					numLiquor--;
					liquorOz.setText(String.valueOf(numLiquor));
				}
			}
		});
		hoursOne.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {
				numTime++;
				hours.setText(String.valueOf(numTime));
			}
		});
		hoursTwo.setOnClickListener(new OnClickListener() {

			// Call website implicit activity when pressed.

			public void onClick(View v) {
				if (numTime == 0) {
					numTime = 0;

				} else {
					numTime--;
					hours.setText(String.valueOf(numTime));
				}
			}
		});

		reset.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				resetNums();
			}
		});

		calculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calculateBloodAcloholContent();
			}
		});

		gender.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					male = true;
				} else
					male = false;
			}
		});
		// weightWatcher handles weight's onTextChanged

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
		AlertDialog.Builder builder = new Builder(ExtraFeatures.this);
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

	private void resetNums() {
		weight = 0.00;
		numBeers = 0;
		numWine = 0;
		numLiquor = 0;
		numTime = 0;
		bac = 0.00;
		weightEditText.setText(String.valueOf(weight));
		beerOz.setText(String.valueOf(numBeers));
		wineOz.setText(String.valueOf(numWine));
		liquorOz.setText(String.valueOf(numLiquor));
		hours.setText(String.valueOf(numTime));
		alcoholContent.setText(String.valueOf(bac));

	}

	private void calculateBloodAcloholContent() {
		double bAC = 0.0;
		double bodyWaterConstant = 0;
		double numDrinks = numBeers + numWine + numLiquor;
		double metabolismConstant = 0;
		double weightInKG = weight / 2.2;
		if (male) {
			bodyWaterConstant = .58;
			metabolismConstant = .015;
		} else {
			bodyWaterConstant = .49;
			metabolismConstant = .017;
		}

		bAC = (.806 * numDrinks * 1.2) / (bodyWaterConstant * weightInKG)
				- (metabolismConstant * numTime);
		alcoholContent.setText(String.format("%.3f", bAC));
	}


	private TextWatcher weightEditTextWatcher = new TextWatcher() {
		// called when the user enters a number
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// convert billEditText's text to a double
			try {
				weight = Double.parseDouble(s.toString());
			} // end try
			catch (NumberFormatException e) {
				weight = 0.0; // default if an exception occurs
			} // end catch

		} // end method onTextChanged

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
	};
}
