package com.example.cs275;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

	ListView l ;
	@SuppressWarnings("null")
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		InputStream file = getResources().openRawResource(R.raw.playlists);
		final Map<String, String> idTitle = new HashMap<String, String>();
		final ArrayList<String> items = new ArrayList<String>();
	    l = (ListView)findViewById(R.id.listView2);
		try
		{
			byte[] b = new byte[file.available()];
	        file.read(b);
	        String data = new String(b);
		    JSONObject dat = new JSONObject(data);
		    JSONArray list = dat.getJSONArray("items");
		    
		    JSONObject j;
		    JSONObject snippet;
		    String id;
		    String title;
		   
		    
		  
		    for(int i = 0; i < list.length(); i++)
		    {
		    	j = list.getJSONObject(i);
		    	id = j.getString("id");
		    	snippet = j.getJSONObject("snippet");
		    	title = snippet.getString("title");
		    	
		    	
		    	if(title.contains("Tutorials"))
		    	{
		    		title = title.replace("Tutorials", "");
		    	}
		    	if(title.contains("Tutorial"))
		    	{
		    		title = title.replace("Tutorial", "");
		    	}
		    	if(title.contains("Playlist"))
		    	{
		    		title = title.replace("Playlist", "");
		    	}
		    	idTitle.put(title, id);
		    	items.add(title);
		    }
		    
		    Collections.sort(items);
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
		    l.setAdapter(adapter);
		    
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Button sortAZ = (Button) findViewById(R.id.sort_AZ);
		sortAZ.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Collections.sort(items);
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
				l.setAdapter(adapter);
			}
			
		});
		
		
		Button sortZA = (Button) findViewById(R.id.sort_ZA);
		sortZA.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Collections.sort(items);
				Collections.reverse(items);
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
				l.setAdapter(adapter);
			}
		});
		
		
		Button back = (Button) findViewById(R.id.back_menu_button);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent back = new Intent("android.intent.action.START");
				startActivity(back);
			}
		});
		
		
		l.setClickable(true);
		l.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				
				ConnectivityManager check = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo ni = check.getActiveNetworkInfo();
			
			if (ni.isConnected() == true && ni.isAvailable() == true) {
				try{
					String selectedFromList = idTitle.get(items.get(arg2));
					Intent next = new Intent("android.intent.action.MENU");
					Bundle b = new Bundle();
					b.putString("id", selectedFromList);
					b.putString("title", items.get(arg2));
					
					next.putExtras(b);
					startActivity(next);
					} catch(Exception e){
						e.printStackTrace();
					}
				}
			else
				{
					Toast.makeText(getApplicationContext(), "Device isn't connected to Internet", Toast.LENGTH_LONG).show();
					
				}	
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
