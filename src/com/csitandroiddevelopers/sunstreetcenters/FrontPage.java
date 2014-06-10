package com.csitandroiddevelopers.sunstreetcenters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import com.csitandroiddevelopers.sunstreetcenters.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.util.Log;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
EditText code;
boolean okay;
private static final String TAG = "SendingJSON";

List<String> checks = new ArrayList<String> (Arrays.asList( "93426",  "93450",  "93901",  "93902",  
		"93905",  "93906",  "93907",  "93908",  "93912",  "93915","93920",  "93921",  "93922",  "93923",  
		"93924",  "93925",  "93926",  "93927",  "93928",  "93930","93932",  "93933",  "93940",  "93942", 
		"93943",  "93944",  "93950",  "93953",  "93954",  "93955", "93960",  "93962",  "95004",  "95012",  "95039"));

public static String age = "0";
public static String choice = "n";
//Test
SharedPreferences prefs;
SharedPreferences.Editor editor;
	
	



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//tests
		prefs = FrontPage.this.getSharedPreferences("nbRepet", MODE_PRIVATE);      
		prefs = getSharedPreferences("nbRepet",Context.MODE_PRIVATE);
	    editor = prefs.edit();
	    editor.putInt("nbRepet", 0);
	    editor.commit();
	
	   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_front_page);
		male = (RadioButton)findViewById(R.id.radioButton1);
		female = (RadioButton)findViewById(R.id.radioButton2);
		rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
		code = (EditText) findViewById(R.id.editText1);
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
                			com.csitandroiddevelopers.sunstreetcenters.FrontPage.age = "9-13";
                			break;
                		case 1:
                			com.csitandroiddevelopers.sunstreetcenters.FrontPage.age = "14-18";
                			break;
                		case 2:
                			com.csitandroiddevelopers.sunstreetcenters.FrontPage.age = "19+";
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
			com.csitandroiddevelopers.sunstreetcenters.FrontPage.choice = "Female";
		}
		
		else if (i==male.getId())
		{
			com.csitandroiddevelopers.sunstreetcenters.FrontPage.choice  = "Male";
		}
	
}


	private void submitMessageButton() {
		// TODO Auto-generated method stub
			submit = (Button)findViewById(R.id.btn2);
			submit.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					final String zipCode = code.getText().toString();
					
					if(checks.contains(zipCode))
						okay = true;
					else if (zipCode != "" && !checks.contains(zipCode))
						okay = false;
					
					
					
					if (age == "0" && choice == "n" && !okay)
						Toast.makeText(getApplicationContext(), "Missing age and gender and zip code invalid.", Toast.LENGTH_SHORT).show();
					else if (age == "0" && choice == "n" && zipCode == "")
						Toast.makeText(getApplicationContext(), "Missing age and gender and zip code.", Toast.LENGTH_SHORT).show();
					else if(age == "0" && choice == "n")
						Toast.makeText(getApplicationContext(), "Missing age and gender", Toast.LENGTH_SHORT).show();
					else if(age == "0" && !okay)
						Toast.makeText(getApplicationContext(), "Missing age and zip code invalid", Toast.LENGTH_SHORT).show();
					else if(age == "0" && choice == "")
						Toast.makeText(getApplicationContext(), "Missing age and zip code", Toast.LENGTH_SHORT).show();
					else if(choice == "n" && !okay)
						Toast.makeText(getApplicationContext(), "Missing gender and zip code invalid", Toast.LENGTH_SHORT).show();
					else if(choice == "n" && choice == "")
						Toast.makeText(getApplicationContext(), "Missing gender and zip code", Toast.LENGTH_SHORT).show();
					else if(choice == "n")
						Toast.makeText(getApplicationContext(), "Missing gender", Toast.LENGTH_SHORT).show();
					else if(age == "0")
						Toast.makeText(getApplicationContext(), "Missing age", Toast.LENGTH_SHORT).show();
					else if(zipCode == "")
						Toast.makeText(getApplicationContext(), "Zip code is empty", Toast.LENGTH_SHORT).show();
					else if(!okay)
						Toast.makeText(getApplicationContext(), "Invalid zip code", Toast.LENGTH_SHORT).show();
					else
					{
						AlertDialog.Builder builder = new Builder(FrontPage.this);
						builder.setMessage("Are you sure you want to continue? You cannot go back.");
						builder.setTitle("Confirmation:");

						builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								
								sendJson(zipCode, age, choice);
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
	public void sendJson(final String zip, final String age, final String gender) {
		Thread t = new Thread() {

			public void run() {
				HttpClient client = new DefaultHttpClient();
				HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
				//HttpResponse response;
	            JSONObject json = new JSONObject();

	            try {
	            	HttpPost post = new HttpPost("http://10.26.8.53:8000/demographics/receivedatafromandroid/");
	            	json.put("Zip", zip);
	            	json.put("Age", age);
	            	json.put("Gender", gender);
	            	StringEntity se = new StringEntity( json.toString());  
	            	se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
	            	post.setEntity(se);
	            	//HttpResponse response = 
	            			client.execute(post);
	            	Log.d(TAG, "JSON file posted");
         

	            } catch(Exception e) {
	            	e.printStackTrace();
	            	//logs to track if connection was established
	            	Log.d(TAG, "Caught Exception");
	            	Log.d(TAG, "Cannot Establish Connection");
	            }

			}
		};
		t.start();      
	}

	
}