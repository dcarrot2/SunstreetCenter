package com.example.sunstreetcenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

	private final int SPLASH_DISPLAY_LENGHT = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* New Handler to start the Menu-Activity 
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
            	SharedPreferences prefs;
            	SharedPreferences.Editor editor;
            	
            	prefs = Splash.this.getSharedPreferences("nbRepet", MODE_PRIVATE);      
            	int value = prefs.getInt("nbRepet", 0);
            	
            	if(value<1)
            	{
            		Intent mainIntent = new Intent(Splash.this,FrontPage.class);
	                Splash.this.startActivity(mainIntent);
	                Splash.this.finish();
	                prefs = getSharedPreferences("nbRepet",Context.MODE_PRIVATE);
	                editor = prefs.edit();
	                editor.putInt("nbRepet", 1);
	                editor.commit();
            	}
            	
            	else
            	{
            		Intent mainIntent = new Intent(Splash.this, Mainscreen.class);
	                Splash.this.startActivity(mainIntent);
	                Splash.this.finish();
            	}
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
