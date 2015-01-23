package com.rafael.simplebrowser;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.rafael.simplebrowser.model.Favorite;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public final static String INTENTS_EXTRA_SEARCH_TEXT = "com.rafael.simplebrowser.intents.extra.SEARCH_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FavsAdapter adapter = new FavsAdapter(this, getInitialFavs());

        ListView listView = (ListView) findViewById(R.id.lv_favs_list);
        listView.setAdapter(adapter);

    }

    private ArrayList<Favorite> getInitialFavs() {
        ArrayList<Favorite> myfavs = new ArrayList<Favorite>();
        myfavs.add(new Favorite(1,"Heraldo", "http://www.heraldo.es"));
        myfavs.add(new Favorite(2,"El Pais", "http://www.elpais.com"));
        myfavs.add(new Favorite(3,"El Mundo", "http://www.elmundo.es"));
        myfavs.add(new Favorite(4,"El Confidencial", "http://www.elconfidencial.com"));
        myfavs.add(new Favorite(1,"Marca", "http://www.marca.com"));

        return myfavs;
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
