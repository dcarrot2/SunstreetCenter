package com.example.sunstreetcenters;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

import com.example.sunstreetcenters.R;

public class InfoForParents extends Activity {

	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_for_parents);
		TextView txtScroll = (TextView) findViewById(R.id.tabOneTextView);
		TextView txtScroll2 = (TextView) findViewById(R.id.tab2TextView);
		txtScroll.setMovementMethod(new ScrollingMovementMethod());
		txtScroll2.setMovementMethod(new ScrollingMovementMethod());
		
		TabHost th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		TabSpec tab = th.newTabSpec("tag 1");
		tab.setContent(R.id.tab1);
		tab.setIndicator("Signs of child abusing prescription drugs");
		th.addTab(tab);
		
		tab = th.newTabSpec("tag 2");
		tab.setContent(R.id.tab2);
		tab.setIndicator("Most common abused Prescription drugs");
		th.addTab(tab);
		
	}
}
