package com.example.sunstreetcenters;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class Tutorial extends Activity {


	 Button buttonPrev, buttonNext;
	 ViewSwitcher viewSwitcher;

	 Animation slide_in_left, slide_out_right;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_tutorial);

	 
	  buttonNext = (Button) findViewById(R.id.next);
	  viewSwitcher = (ViewSwitcher) findViewById(R.id.viewswitcher);

	  slide_in_left = AnimationUtils.loadAnimation(this,
	    android.R.anim.slide_in_left);
	  slide_out_right = AnimationUtils.loadAnimation(this,
	    android.R.anim.slide_out_right);

	  viewSwitcher.setInAnimation(slide_in_left);
	  viewSwitcher.setOutAnimation(slide_out_right);


	  buttonNext.setOnClickListener(new OnClickListener() {

	   @Override
	   public void onClick(View arg0) {
	    viewSwitcher.showNext();
	   }
	  });
	  ;
	 }

}
