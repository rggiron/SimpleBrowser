package com.rafael.simplebrowser;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    public final static String INTENTS_EXTRA_SEARCH_TEXT = "com.rafael.simplebrowser.intents.extra.SEARCH_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    public void bt_search_onclick(View v)
    {
        if (v.getId() == R.id.bt_search)
        {
            //1. Get the text
            String searchText = ((EditText)findViewById(R.id.et_search_field)).getText().toString();

            Log.d("MAIN_ONCLICK","texto a buscar:'" + searchText + "'");


            //2. Launch browser activity passing the text
            Intent intent = new Intent(this, BrowserActivity.class);
            intent.putExtra(INTENTS_EXTRA_SEARCH_TEXT, searchText);
            startActivity(intent);
        }
    }
}
