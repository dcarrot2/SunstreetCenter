package com.example.sunstreetcenters;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;
import android.content.Intent;

public class Tutorial extends Activity {

	 int click = 0;
	 

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_tutorial);
	  final ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton1);
	  btn1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			if (click == 0)
			{
				btn1.setBackgroundResource(R.drawable.demo2);
				click++;
			}
			else
			{
				Intent intent = new Intent(Tutorial.this, Mainscreen.class);
            	Tutorial.this.startActivity(intent);
			}
		}
	});
	  
	  

	 }
}
