package com.example.cs275;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.temboo.Library.YouTube.PlaylistItems.ListItemsByPlaylist;
import com.temboo.Library.YouTube.PlaylistItems.ListItemsByPlaylist.ListItemsByPlaylistInputSet;
import com.temboo.Library.YouTube.PlaylistItems.ListItemsByPlaylist.ListItemsByPlaylistResultSet;
import com.temboo.core.TembooSession;




public class Menu extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_layout);
		
		
		final Bundle b = getIntent().getExtras();
		final String value = b.getString("id");
		String tutorial = b.getString("title");
		tutorial = tutorial.trim();
		ListView l = (ListView)findViewById(R.id.listView1);
		final ArrayList<String> videos = new ArrayList<String>();
		ArrayList<String> titles = new ArrayList<String>();
		
		try{
			TextView t = (TextView)findViewById(R.id.textView2);
			
			JSONObject response;
			ListItemsByPlaylistInputSet listItemsByPlaylistInputs;
			
			TembooSession session = new TembooSession("aa3268", "myFirstApp", "522716fffec34ab1961d61113bea0f34");
			ListItemsByPlaylist listItemsByPlaylistChoreo = new ListItemsByPlaylist(session);

			// Get an InputSet object for the choreo
			listItemsByPlaylistInputs = listItemsByPlaylistChoreo.newInputSet();

			// Set credential to use for execution
			listItemsByPlaylistInputs.setCredential("youtube");

			// Set inputs
			listItemsByPlaylistInputs.set_PlaylistID(value);
			listItemsByPlaylistInputs.set_MaxResults("50");

			// Execute Choreo
			ListItemsByPlaylistResultSet listItemsByPlaylistResults = listItemsByPlaylistChoreo.execute(listItemsByPlaylistInputs);
			
			response = new JSONObject(listItemsByPlaylistResults.get_Response());
				
			JSONArray items = response.getJSONArray("items");
			
			String videoId = "";
			String title = "";
			
			for(int i = 0; i < items.length(); i++)
			{
				JSONObject item = items.getJSONObject(i);
				JSONObject snippet = item.getJSONObject("snippet");
				JSONObject resource = snippet.getJSONObject("resourceId");
				videoId = resource.getString("videoId");
				title = snippet.getString("title");
				title = title.substring(title.lastIndexOf("- ") + 2, title.length());
				
				titles.add(title);
				videos.add(videoId);
			}
			
			
			if(response.has("nextPageToken"))
			{
				while(response.has("nextPageToken") == true)
				{
				
					session = new TembooSession("aa3268", "myFirstApp", "522716fffec34ab1961d61113bea0f34");
					listItemsByPlaylistChoreo = new ListItemsByPlaylist(session);

					// Get an InputSet object for the choreo
					listItemsByPlaylistInputs = listItemsByPlaylistChoreo.newInputSet();

					// Set credential to use for execution
					listItemsByPlaylistInputs.setCredential("youtube");

					// Set inputs
					listItemsByPlaylistInputs.set_PlaylistID(value);
					listItemsByPlaylistInputs.set_MaxResults("50");
					listItemsByPlaylistInputs.set_PageToken(response.get("nextPageToken").toString());

					// Execute Choreo
					listItemsByPlaylistResults = listItemsByPlaylistChoreo.execute(listItemsByPlaylistInputs);
					
					response = new JSONObject(listItemsByPlaylistResults.get_Response());
						
					items = response.getJSONArray("items");
					
					videoId = "";
					title = "";
					
					for(int i = 0; i < items.length(); i++)
					{
						JSONObject item = items.getJSONObject(i);
						JSONObject snippet = item.getJSONObject("snippet");
						JSONObject resource = snippet.getJSONObject("resourceId");
						videoId = resource.getString("videoId");
						title = snippet.getString("title");
						title = title.substring(title.lastIndexOf("- ") + 2, title.length());
						
						titles.add(title);
						videos.add(videoId);
					}
				}
			}


			
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, titles);
			
			l.setAdapter(adapter);
			t.setText(tutorial + " Tutorials: " + titles.size() + " Videos" );
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		Button back = (Button)findViewById(R.id.back_button);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent prev = new Intent("android.intent.action.MAINACTIVITY");
				startActivity(prev);
				
			}
			
		});
		
		l.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String id = videos.get(arg2);
				Intent next = new Intent("android.intent.action.VIDEOVIEW");
				
				Bundle a = new Bundle();
				a.putString("videoId", id);
				a.putString("id", b.getString("id"));
				a.putString("title", b.getString("title"));
				
				
				
				next.putExtras(a);
				startActivity(next);
				
			}
			
		});
		
		
		
	}

}
