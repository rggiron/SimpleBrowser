package com.rafael.simplebrowser;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.URL;


public class BrowserActivity extends ActionBarActivity {

    public final static String GOOGLE_SEARCH_URL = "http://www.google.com/search?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get the info we need for this screen
        String search_text = this.getIntent().getStringExtra(MainActivity.INTENTS_EXTRA_SEARCH_TEXT);
        Log.d(this.getLocalClassName(),search_text);
        //Toast.makeText(this,search_text,Toast.LENGTH_LONG).show();

        //set content of the view
        setContentView(R.layout.activity_browser);
        //getActionBar().setTitle(search_text);

        launchBrowser(search_text);

    }

    private void launchBrowser(String url)
    {
        WebView browser = (WebView)findViewById(R.id.browser);

        final Activity activity = this;
        browser.setWebViewClient(new WebViewClient(){


        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
        }});

        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setBuiltInZoomControls(true);
        browser.getSettings().setDomStorageEnabled(true);

        browser.loadUrl(getFinalUrl(url));

    }

    private String getFinalUrl(String url)
    {
        return (url.startsWith("http://") || url.startsWith("https://")) ? url : GOOGLE_SEARCH_URL + url;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_browser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
