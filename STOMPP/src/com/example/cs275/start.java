package com.example.cs275;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_layout);
		
		try{
			Thread.sleep(1000);
			final ArrayList<String> items = new ArrayList<String>();
			
			//Options user can choose from
			items.add("Tutorials");
			items.add("StackOverflow");
			ArrayAdapter t = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, items);
			
			final ListView a = (ListView)findViewById(R.id.listView1);
			a.setAdapter(t);
			a.setOnItemClickListener(new OnItemClickListener(){

				//Starts a new Activity based on user's choice
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					String selected = items.get(arg2);
					if(selected == "Tutorials")
					{
						Intent main = new Intent("android.intent.action.MAINACTIVITY");
						startActivity(main);
					}
					else
					{
						Intent main = new Intent("android.intent.action.STACKOVERFLOW");
						startActivity(main);
					}
				}
				
			});
			

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	
}
