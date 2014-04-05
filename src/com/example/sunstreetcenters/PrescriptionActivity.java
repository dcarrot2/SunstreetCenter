package com.example.sunstreetcenters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.sunstreetcenters.AdditionalDrugs;
import com.example.sunstreetcenters.ContactInfo;
import com.example.sunstreetcenters.ExtraFeatures;
//import com.example.sunstreetcenters.Mainscreen;
import com.example.sunstreetcenters.MythsAndFacts;
import com.example.sunstreetcenters.PrescriptionActivity;
import com.example.sunstreetcenters.R;
import com.example.sunstreetcenters.TopNewsActivity;

public class PrescriptionActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_prescription_drug);

		Button parentsInformation = (Button) findViewById(R.id.infoForParentsButton);
		Button News = (Button) findViewById(R.id.topNewsButton);
		Button otherDrugs = (Button) findViewById(R.id.additionalDrugsButton);
		Button mythFacts = (Button) findViewById(R.id.mythsAndFactsButton);
		Button ExtraFeatures = (Button) findViewById(R.id.extraInformationButton);
		Button ContactInfo = (Button) findViewById(R.id.contactInformationButton);

		ContactInfo.setOnClickListener(new OnClickListener() {

			// Display Contact Info on Click

			public void onClick(View v) {
				contactActivity();
			}
		});

		mythFacts.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				mythActivity();
			}
		});

		News.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				topNews();
			}
		});
		otherDrugs.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startOtherDrugs();
			}
		});
		parentsInformation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startParentsInformation();

			}
		});
		ExtraFeatures.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				startExtraFeatures();
			}
		});

	}

	private void contactActivity() {
		Intent contactIn = new Intent(PrescriptionActivity.this,
				ContactInfo.class);
		startActivity(contactIn);
		// finish();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	private void mythActivity() {
		Intent seeMyths = new Intent(PrescriptionActivity.this,
				MythsAndFacts.class);
		startActivity(seeMyths);
	}

	private void topNews() {
		Intent seeNews = new Intent(PrescriptionActivity.this,
				TopNewsActivity.class);
		startActivity(seeNews);
	}

	private void startOtherDrugs() {
		Intent drugs = new Intent(PrescriptionActivity.this,
				AdditionalDrugs.class);
		startActivity(drugs);
	}

	private void startParentsInformation() {
		Intent parents = new Intent(PrescriptionActivity.this,
				ParentsActivity.class);
		startActivity(parents);
	}

	private void startExtraFeatures() {
		Intent features = new Intent(PrescriptionActivity.this,
				ExtraFeatures.class);
		startActivity(features);
	}
}
