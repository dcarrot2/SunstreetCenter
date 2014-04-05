package com.example.sunstreetcenters;

import com.example.sunstreetcenters.Polls;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Polls extends Activity {
	
	CheckBox cb1;
	CheckBox cb2;
	CheckBox cb3;
	CheckBox cb4;
	CheckBox cb5;
	CheckBox cb6;
	CheckBox cb7;
	Button nextB;
	OnClickListener checkBoxListener;
	int checked_boxes = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_polls);
		
		cb1 = (CheckBox) findViewById(R.id.questionACheckBox);
		cb2 = (CheckBox) findViewById(R.id.questionBCheckBox);
		cb3 = (CheckBox) findViewById(R.id.questionCCheckBox);
		cb4 = (CheckBox) findViewById(R.id.questionDCheckBox);
		cb5 = (CheckBox) findViewById(R.id.questionECheckBox);
		cb6 = (CheckBox) findViewById(R.id.questionFCheckBox);
		cb7 = (CheckBox) findViewById(R.id.questionGCheckBox);
		nextB = (Button) findViewById(R.id.nextButton);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.polls, menu);
		return true;
	}
	
	public void onCheckboxClicked(View view) {
		// Is the view now checked?
		boolean checked = ((CheckBox) view).isChecked();

		switch (view.getId()) {

		case R.id.questionACheckBox:
			if (checked) {
				cb1.setChecked(true);
				checked_boxes++;
			}
			else if(!checked) {
				cb1.setChecked(false);
				checked_boxes--;
			}
			break;

		case R.id.questionBCheckBox:
			if (checked) {
				cb2.setChecked(true);
				checked_boxes++;
			}
			else if(!checked) {
				cb2.setChecked(false);
				checked_boxes--;
			}
			break;

		case R.id.questionCCheckBox:
			if (checked) {
				cb3.setChecked(true);
				checked_boxes++;
			}
			else if(!checked) {
				cb3.setChecked(false);
				checked_boxes--;
			}
			break;

		case R.id.questionDCheckBox:
			if (checked) {
				cb4.setChecked(true);
				checked_boxes++;
			}
			else if(!checked) {
				cb4.setChecked(false);
				checked_boxes--;
			}
			break;

		case R.id.questionECheckBox:
			if (checked) {
				cb5.setChecked(true);
				checked_boxes++;
			}
			else if(!checked) {
				cb5.setChecked(false);
				checked_boxes--;
			}
			break;

		case R.id.questionFCheckBox:
			if (checked) {
				cb6.setChecked(true);
				checked_boxes++;
			}
			else if(!checked) {
				cb6.setChecked(false);
				checked_boxes--;
			}
			break;

		case R.id.questionGCheckBox:
			if (checked) {
				cb7.setChecked(true);
				checked_boxes++;
			}
			else if(!checked) {
				cb7.setChecked(false);
				checked_boxes--;
			}
			break;
		}

		nextB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (checked_boxes > 3)
					Toast.makeText(getApplicationContext(),
							"You can only select three answers", Toast.LENGTH_LONG).show();
				else {
					cb1.setEnabled(false);
					cb2.setEnabled(false);
					cb3.setEnabled(false);
					cb4.setEnabled(false);
					cb5.setEnabled(false);
					cb6.setEnabled(false);
					cb7.setEnabled(false);
				}
			}
		});

	}

}
