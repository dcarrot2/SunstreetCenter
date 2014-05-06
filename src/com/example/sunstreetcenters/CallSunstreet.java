package com.example.sunstreetcenters;

import android.content.Intent;
import android.net.Uri;

public class CallSunstreet {
	protected Intent callSunsetCenter(){
		
		Intent newCall = new Intent(android.content.Intent.ACTION_CALL);
		newCall.setData(Uri.parse("tel:8317535135"));
		return newCall;
		}
}
