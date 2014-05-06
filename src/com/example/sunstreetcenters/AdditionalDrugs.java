package com.example.sunstreetcenters;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class AdditionalDrugs extends Activity {
	CVSAdapter mAdapter;
	private static final String EXT = "additionaldrugs.csv";
	private static final String lol = "s";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_additional_drugs);
		
		ListView mythList = (ListView) findViewById(R.id.listView1);
		
		mAdapter = new CVSAdapter(this, -1, EXT);
		mythList.setAdapter(mAdapter);

		mythList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos,long id) {
				Toast.makeText(v.getContext(), mAdapter.getItem(pos).getCapital(), Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.additional_drugs, menu);
		return true;
	}
}
