package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandmarksFragment extends Fragment {

    final static String PLACE_NAME_KEY = "Name Key";
    final static String PLACE_INFO_KEY = "Info Key";
    final static String PLACE_WORK_TIMES_KEY = "Work Times Key";
    final static String PLACE_IMAGE_RES_ID_KEY = "Image Res Key";

    public LandmarksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);


        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.aquarium_landmark_name), getString(R.string.aquarium_landmark_work_times),
                R.drawable.aquarium_image, getString(R.string.aquarium_landmark_info)));
        places.add(new Place(getString(R.string.dolphinarium_landmark_name), getString(R.string.dolphinarium_landmark_work_times),
                R.drawable.dolphinarium_image, getString(R.string.dolphinarium_landmark_info)));
        places.add(new Place(getString(R.string.observatory_landmark_name), getString(R.string.observatory_landmark_work_times),
                R.drawable.observatory_varna_image, getString(R.string.observatory_landmark_info)));
        places.add(new Place(getString(R.string.zoo_landmark_name), getString(R.string.zoo_landmark_work_times),
                R.drawable.zoo_varna_image, getString(R.string.zoo_landmark_info)));

// Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), places, R.color.colorCategoryLandmarks);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Place selectedPlace = (Place) listView.getItemAtPosition(position);
                Bundle placeBundle = new Bundle();
                placeBundle.putString(PLACE_NAME_KEY, selectedPlace.getPlaceName());
                placeBundle.putString(PLACE_INFO_KEY, selectedPlace.getPlaceInformation());
                placeBundle.putString(PLACE_WORK_TIMES_KEY, selectedPlace.getPlaceWorkTime());
                placeBundle.putInt(PLACE_IMAGE_RES_ID_KEY, selectedPlace.getPlacePictureResID());
                Intent placeDetailScreen = new Intent(getActivity(), PlacesActivity.class);
                placeDetailScreen.putExtras(placeBundle);
                startActivity(placeDetailScreen);
            }


        });

        return rootView;
    }
}


