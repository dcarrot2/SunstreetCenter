package com.example.sunstreetcenters;

import android.os.Bundle;

import com.example.sunstreetcenters.Mainscreen;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class FrontPage extends Activity implements RadioGroup.OnCheckedChangeListener{
	

Button btn1;
Button submit;
RadioButton female;
RadioButton male;
RadioGroup rg1;
ImageView image;
Spinner spinner;

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
		btn1 = (Button) findViewById(R.id.btn);
		btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = view.getResources().getStringArray(R.array.agearray);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(FrontPage.this, android.R.layout.simple_spinner_dropdown_item, items);
                new AlertDialog.Builder(FrontPage.this).setTitle("Choose your age:").setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    	
                    	
                    	btn1.setText(items[which]);
                        
                        switch(which){
                		case 0:
                			com.example.sunstreetcenters.FrontPage.age = 1;
                			break;
                		case 1:
                			com.example.sunstreetcenters.FrontPage.age = 2;
                			break;
                		case 2:
                			com.example.sunstreetcenters.FrontPage.age = 3;
                			break;
                		
                		}
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });  
		submitMessageButton();
		rg1.setOnCheckedChangeListener(this);
		
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

//	@Override
//	public void onCreateContextMenu(ContextMenu menu, View v,
//			ContextMenuInfo menuInfo) {
//		// TODO Auto-generated method stub
//		super.onCreateContextMenu(menu, v, menuInfo);
//		MenuInflater inflate = getMenuInflater();
//		inflate.inflate(R.menu.context,menu);
//	}

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
						AlertDialog.Builder builder = new Builder(FrontPage.this);
						builder.setMessage("Are you sure you want to continue? You cannot go back.");
						builder.setTitle("Confirmation:");

						builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								
								prefs = getSharedPreferences("nbRepet",Context.MODE_PRIVATE);
				                editor = prefs.edit();
				                editor.putInt("nbRepet", 1);
				                editor.commit();
								Intent intent = new Intent(FrontPage.this, Tutorial.class);
								startActivityForResult(intent,0);
								finish();
							}
						});	

						builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								dialog.cancel();
							}
						});	

						builder.create().show();	
					}
						
						
						
					
				}	
			});
			
			
		}

	
}