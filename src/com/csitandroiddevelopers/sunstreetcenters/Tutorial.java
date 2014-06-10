package com.csitandroiddevelopers.sunstreetcenters;

import com.csitandroiddevelopers.sunstreetcenters.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class Tutorial extends Activity {

	 int click = 0;
	 

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_tutorial);
	  final Button btn1 = (Button) findViewById(R.id.Button1);
	  btn1.setBackgroundResource(R.drawable.demo);
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
            	finish();
			}
		}
	});
	  
	  

	 }
}
