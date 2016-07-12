package com.example.cs275;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.Button;

public class videoview extends Activity{

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_layout);
		
		final Bundle b = getIntent().getExtras();
		String videoId = b.getString("videoId");
		WebView v = (WebView) findViewById(R.id.webView1);
		v.getSettings().setJavaScriptEnabled(true);
		v.getSettings().setPluginState(PluginState.ON);
		v.loadUrl("http://www.youtube.com/embed/"+videoId+"?autoplay=1&vq=small");
		v.setWebChromeClient(new WebChromeClient());
		
		Button back = (Button) findViewById(R.id.back_menu_button);
		
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent next = new Intent("android.intent.action.MENU");
				Bundle a = new Bundle();
				a.putString("id", b.getString("id"));
				a.putString("title", b.getString("title"));
				v = null;
				next.putExtras(a);
				startActivity(next);
			}
			
		});
		
		Button home = (Button) findViewById(R.id.home_button);
		
		home.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v= null;
				Intent main = new Intent("android.intent.action.MAINACTIVITY");
				startActivity(main);
			}
			
		});
		
		
		
	}

}
