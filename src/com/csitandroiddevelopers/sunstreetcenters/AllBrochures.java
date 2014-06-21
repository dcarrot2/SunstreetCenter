package com.csitandroiddevelopers.sunstreetcenters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AllBrochures extends Activity {
	ListView list;
	String[] listItems = {
		    "Alcohol", 
		    "Marijuana",
		    "Prescription",
	        "Tobacco"
		  } ;
		  Integer[] imageId = {
		      R.drawable.beer2d,
		      R.drawable.marijuana2d,
		      R.drawable.prescription_drugs2d,
		      R.drawable.cigarrette2d
		  };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_brochures);
				CustomList adapter = new
				CustomList (AllBrochures.this, listItems, imageId);
				list = (ListView)findViewById(R.id.brochureList);
				// Assign adapter to ListView
		        list.setAdapter(adapter); 
		        // ListView Item Click Listener
	            list.setOnItemClickListener(new OnItemClickListener() {
	 
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
							if(position == 0){
								Intent alcohol = new Intent(AllBrochures.this,Alcohol_brochure.class);
								startActivity(alcohol);
							}
							else if(position == 1){
								Intent features = new Intent(AllBrochures.this,Marijuana_brochure.class);
								startActivity(features);
							}
							else if(position == 2){
								Intent parents = new Intent(AllBrochures.this,Prescriptiondrugs_brochures.class);
								startActivity(parents);
							}
							else if(position == 3){
								Intent game = new Intent(AllBrochures.this,Cigarettes_brochure.class);
								startActivity(game);
							}
							
					}
	    
	             }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_brochures, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
