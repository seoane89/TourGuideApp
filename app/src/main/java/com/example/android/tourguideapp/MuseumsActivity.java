package com.example.android.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsActivity extends AppCompatActivity {
    final static String PLACE_NAME_KEY = "Name Key";
    final static String PLACE_INFO_KEY = "Info Key";
    final static String PLACE_WORK_TIMES_KEY = "Work Times Key";
    final static String PLACE_IMAGE_RES_ID_KEY = "Image Res Key";
    Bundle placeBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);
        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.archaelogical_museum_name), getString(R.string.arch_museum_work_times),
                R.drawable.arch_museum_image, getString(R.string.archaelogical_museum_info)));
        places.add(new Place(getString(R.string.naval_museum_name), getString(R.string.naval_museum_work_times),
                R.drawable.naval_museum_image, getString(R.string.naval_museum_info)));
// Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        PlacesAdapter adapter = new PlacesAdapter(MuseumsActivity.this, places, R.color.colorCategoryMuseums);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        final ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Place selectedPlace = (Place) listView.getItemAtPosition(position);
                Intent placeDetailScreen = new Intent(MuseumsActivity.this, PlacesActivity.class);
                placeBundle.putString(PLACE_NAME_KEY, selectedPlace.getPlaceName());
                placeBundle.putString(PLACE_INFO_KEY, selectedPlace.getPlaceInformation());
                placeBundle.putString(PLACE_WORK_TIMES_KEY, selectedPlace.getPlaceWorkTime());
                placeBundle.putInt(PLACE_IMAGE_RES_ID_KEY, selectedPlace.getPlacePictureResID());
                placeDetailScreen.putExtras(placeBundle);
                startActivity(placeDetailScreen);
            }


        });
    }
}
