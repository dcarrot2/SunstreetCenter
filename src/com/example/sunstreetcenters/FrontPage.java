package com.example.sunstreetcenters;

import android.os.Bundle;
import com.example.sunstreetcenters.Mainscreen;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FrontPage extends Activity implements RadioGroup.OnCheckedChangeListener{
	
Button btn1;
Button submit;
RadioButton female;
RadioButton male;
RadioGroup rg1;
ImageView image;
public static int age = 0;
public static char choice = 'n';
//Test
SharedPreferences prefs;
SharedPreferences.Editor editor;
	
	



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//tests
		prefs = FrontPage.this.getSharedPreferences("nbRepet", MODE_PRIVATE);      
		int value = prefs.getInt("nbRepet", 0);
		prefs = getSharedPreferences("nbRepet",Context.MODE_PRIVATE);
	    editor = prefs.edit();
	    editor.putInt("nbRepet", 0);
	    editor.commit();
	//************
	
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_front_page);
		female = (RadioButton)findViewById(R.id.radioButton1);
		male = (RadioButton)findViewById(R.id.radioButton2);
		rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
		btn1 = (Button)findViewById(R.id.btn);
		submitMessageButton();
		rg1.setOnCheckedChangeListener(this);
		btn1.setOnClickListener(new View.OnClickListener() {
		
			
			@Override
			public void onClick(View v) {
				registerForContextMenu(btn1); 
				openContextMenu(v);
			}
		});
		
	}


	@Override
	public void onCheckedChanged(RadioGroup rg1 , int i) {
		// TODO Auto-generated method stub
		if(i==female.getId())
		{
			com.example.sunstreetcenters.FrontPage.choice = 'f';
		}
		
		else if (i==male.getId())
		{
			com.example.sunstreetcenters.FrontPage.choice  = 'm';
		}
	
}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainscreen, menu);
		return true;
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		//Assign age group:
		//1. 9 - 13
		//2. 13 - 18
		//3. 19+
		
		switch(item.getItemId()){
		case R.id.item1:
			btn1.setText("9 - 13");
			com.example.sunstreetcenters.FrontPage.age = 1;
			break;
		case R.id.item2:
			btn1.setText("13 - 18");
			com.example.sunstreetcenters.FrontPage.age = 2;
			break;
		case R.id.item3:
			btn1.setText("19+");
			com.example.sunstreetcenters.FrontPage.age = 3;
			break;
		
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.context,menu);
	}

	private void submitMessageButton() {
		// TODO Auto-generated method stub
			submit = (Button)findViewById(R.id.btn2);
			submit.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (age == 0 && choice == 'n')
						Toast.makeText(getApplicationContext(), "Missing age and gender.", Toast.LENGTH_SHORT).show();
					else if(age == 0)
						Toast.makeText(getApplicationContext(), "Missing age", Toast.LENGTH_SHORT).show();
					else if(choice == 'n')
						Toast.makeText(getApplicationContext(), "Missing gender", Toast.LENGTH_SHORT).show();
					else
					{
						prefs = getSharedPreferences("nbRepet",Context.MODE_PRIVATE);
		                editor = prefs.edit();
		                editor.putInt("nbRepet", 1);
		                editor.commit();
						Intent intent = new Intent(v.getContext(), Mainscreen.class);
						startActivityForResult(intent,0);
						finish();
					}
				}	
			});
			
			
		}

	
	
	
	
	
	
	
	
	
	
}