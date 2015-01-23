package com.rafael.simplebrowser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.rafael.simplebrowser.model.Favorite;

import java.util.ArrayList;

/**
 * Created by htpc on 23/01/2015.
 */

public class FavsAdapter extends ArrayAdapter<Favorite> {

    public FavsAdapter(Context context, ArrayList<Favorite> favs) {
        super(context, 0, favs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Favorite fav = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.favs_list_item, parent, false);
        }

        // Lookup view for data population
        Button bt_fav_item = (Button) convertView.findViewById(R.id.bt_fav_item);
        bt_fav_item.setOnClickListener(new FavButtonListener());
        bt_fav_item.setTag(fav);

        // Populate the data into the template view using the data object
        //bt_fav_item.setText(fav.getId() + " || " + fav.getName() + " || " + fav.getUrl() );
        bt_fav_item.setText(fav.getName());

        // Return the completed view to render on screen
        return convertView;
    }

    private class FavButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Favorite fav = (Favorite) v.getTag();

            Intent intent = new Intent(getContext(), BrowserActivity.class);
            intent.putExtra(MainActivity.INTENTS_EXTRA_SEARCH_TEXT, fav.getUrl());
            getContext().startActivity(intent);
        }


    }
}
