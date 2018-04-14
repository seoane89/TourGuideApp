package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlacesActivity extends AppCompatActivity {
    final static String PLACE_NAME_KEY = "Name Key";
    final static String PLACE_INFO_KEY = "Info Key";
    final static String PLACE_WORK_TIMES_KEY = "Work Times Key";
    final static String PLACE_IMAGE_RES_ID_KEY = "Image Res Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        Bundle placeBundle = getIntent().getExtras();
        String placeName = placeBundle.getString(PLACE_NAME_KEY);
        String placeInfo = placeBundle.getString(PLACE_INFO_KEY);
        String placeWorkTime = placeBundle.getString(PLACE_WORK_TIMES_KEY);
        int placeImageResID = placeBundle.getInt(PLACE_IMAGE_RES_ID_KEY);

    }
}
