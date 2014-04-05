package com.example.sunstreetcenters;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.sunstreetcenters.R;

public class ExtraFeatures extends Activity {
	private static final String WEIGHT = "WEIGHT";

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

	private Switch gender;

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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.extra_features, menu);
		return true;
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
