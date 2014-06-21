package com.csitandroiddevelopers.sunstreetcenters;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csitandroiddevelopers.sunstreetcenters.R;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PictureTakerActivity extends Activity {
	//constants add the type to the intent in order to use within onActivityResult()
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int RESULT_LOAD_IMAGE = 3;
	//This constant is also used within onActivityResult() to authenticate a picture being taken and a result 
	//being returned
	public static final int TAKE_PICTURE = 100;
	
	Button takePictureButton, selectPictureButton;
	//bm holds the bitmap in order for the tile slicer to use, this needs to be public in order for the tile slicer to 
	//use the bitmap image. 
	public static Bitmap bm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture_taker);
		

		takePictureButton = (Button) findViewById(R.id.pictureButton);
		takePictureButton.setTextColor(Color.parseColor("#FFFFFF"));
		selectPictureButton = (Button) findViewById(R.id.galleryButton);
		selectPictureButton.setTextColor(Color.parseColor("#FFFFFF"));
		//set onclick listener for the picture taker button
		takePictureButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//intent creates an intent with the parameter action_image_capture, this causes the application
				//to call the camera that is built in to the android device
				Intent in = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

				//beings the activity
				startActivityForResult(in, TAKE_PICTURE);
			}
		});
		//set the onclicklistener for the select picture button, 
		selectPictureButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//creates an intent with ACTION_PICK specification, this creates a nonspecific intent used to select
				//pictures from the picture gallery
				Intent inB = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(inB, RESULT_LOAD_IMAGE);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.picture_taker, menu);
		return true;
	}
	//method handles the result of the call to the intent 
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == TAKE_PICTURE){
			if(resultCode != RESULT_CANCELED){
				if (resultCode == RESULT_OK){
					try {
						//data.getData() produces an object of type Uri, this Uri is used with a content resolver
						//to return the Bitmap from the Camera. 
						bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
						//creates an intent in order to run the main activity of the game
 						Intent in = new Intent(this, GameMainActivity.class);
						startActivity(in);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}	
		}
		if(requestCode == RESULT_LOAD_IMAGE){
			if(resultCode != RESULT_CANCELED){
				if(resultCode == RESULT_OK){
					try{
						bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
						Intent in = new Intent(this, GameMainActivity.class);
						startActivity(in);
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}