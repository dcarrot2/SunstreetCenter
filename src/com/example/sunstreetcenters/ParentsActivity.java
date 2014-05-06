package com.example.sunstreetcenters;

import com.example.sunstreetcenters.InfoForParents;

import com.example.sunstreetcenters.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ParentsActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_for_parents);
		Intent newInt = new Intent(ParentsActivity.this, InfoForParents.class);
		startActivity(newInt);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		finish();
	}
}
