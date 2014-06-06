package com.example.sunstreetcenters;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseExpandableListAdapter {
	private Locations locations;
	String []parentList={"ADMINISTRATION","MEN’S RESIDENTIAL PROGRAM AND SEVEN SUNS TRANSITIONAL HOUSING","COUNSELING SERVICES","PREVENTION CENTERS","PUEBLO DEL MAR FAMILY RECOVERY COMMUNITY","DRIVING UNDER THE INFLUENCE PROGRAM"};
	static String [][]childList={
			{
				"11 Peach Drive, Salinas, CA 93901\nPhone: 831.753.5135\nHours: Mon-Fri 8:00 am to 5:00 pm"
			},
			{
				"8 Sun Street, Salinas, CA 93901\nPhone: 831.753.5145\nHours: Open 24 hours per day, 7 days per week"
			},
			{
				"11 Peach Drive, Salinas, CA 93901\nPhone: 831.753.6001\nHours: Mon-Fir 9:00 am to 7:00 pm",
				"1760 Fremont Blvd. Suite E1, Seaside, CA 93955\nPhone: 831.753.6001\nHours: Mon-Thur 4:30 pm to 7:30 pm\n(NO walk-in at this site MUST contact  Office)"
			},
			{
				"128 East Alisal Street, Salinas, CA\nPhone: 831.753.5150\nHours: Mon-Fri 9:00 am to 6:00 pm",
				"1760 Fremont Blvd Suite E1, Seaside, CA 93955\nPhone: 831.899.6577\nHours: Mon-Fri 8:00 am to 5:00 pm",
				"2167 H. De La Rosa Sr. St., Soledad, CA 93960\nPhone: 831.385.0100\nHours: Mon-Fri 8:30 am to 5:30 pm"
			},
			{
				"3043 MacArthur Drive, Marina, CA 93933\nPhone: 831-582-9461\nHours: Mon-Fri 8:00 am to 6:00 pm"
			},
			{
				"11 Peach Drive, Salinas, CA 93901\nPhone: 831.753.5140\nHours: Mon-Fri 8:00 am to 5:45 pm",
				"1760 Fremont Blvd, Suite E-1, Seaside, CA 93955\nPhone: 831.393.9316\nHours: Mon-Fri 9:00 am to 5:45 pm",
				"2167 H. De La Rosa Sr. St., Soledad, CA 93960\nPhone: 831.385.0187\nOffice Hours: Mon-Fri 8:30 am to 5:30 pm\nPlease register for classes at 11 Peach Drive, Salinas CA 93901"
			}
	};

		public MyAdapter(Locations locations) {
			// TODO Auto-generated constructor stub
			this.locations = locations;
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			TextView tv = new TextView(locations);
			tv.setText(childList[groupPosition][childPosition]);
			tv.setPadding(30, 10, 10, 10);
			tv.setTextSize(25);	
			//tv.setTextColor(Color.parseColor("#E66954"));
			//tv.setTextColor(Color.parseColor("#666666"));
			tv.setTextColor(Color.parseColor("#336699"));
			return tv;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			return childList[groupPosition].length;
		}

		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return parentList.length;
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			TextView tv = new TextView(locations);
			tv.setText(parentList[groupPosition]);
			tv.setPadding(70, 10, 10, 10);
			tv.setTextSize(30);	
			//tv.setTextColor(Color.parseColor("#336699"));
			tv.setTextColor(Color.parseColor("#666666"));
			tv.setTypeface(null, Typeface.BOLD);
			return tv;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;
		}

}
