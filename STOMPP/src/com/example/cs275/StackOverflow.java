package com.example.cs275;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebSettings.PluginState;
import android.widget.Button;
import android.widget.EditText;


/*	This activity is not finished
	It was suppose to list top rated answers from StackOverflow
	related to a topic the user chooses or searches.
*/
public class StackOverflow extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stackoverflow_layout);
		
		
		final WebView web = (WebView) findViewById(R.id.webView1);
		Button search = (Button) findViewById(R.id.search_button);
		final EditText text = (EditText) findViewById(R.id.editText1);
		
		search.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				web.getSettings().setJavaScriptEnabled(true);
				web.getSettings().setPluginState(PluginState.ON);
				web.loadUrl("https://www.stackoverflow.com/");
				web.setWebChromeClient(new WebChromeClient());
				
			}
			
		});
	
	
	
	}
	

}
