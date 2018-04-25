package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class PlacesActivity extends AppCompatActivity {
    final static String PLACE_NAME_KEY = "Name Key";
    final static String PLACE_INFO_KEY = "Info Key";
    final static String PLACE_WORK_TIMES_KEY = "Work Times Key";
    final static String PLACE_IMAGE_RES_ID_KEY = "Image Res Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        Intent placeDetailScreen = getIntent();
        Bundle placeBundle = placeDetailScreen.getExtras();

        TextView nameTextView = (TextView) findViewById(R.id.place_name_textview);
        TextView infoTextView = (TextView) findViewById(R.id.place_info_textview);
        TextView workTimesTextView = (TextView) findViewById(R.id.place_worktime_textview);
        ImageView pictureImageView = (ImageView) findViewById(R.id.place_picture_imageview);

        if (placeBundle != null)
        {
        nameTextView.setText(placeBundle.getString(PLACE_NAME_KEY));
        infoTextView.setText(placeBundle.getString(PLACE_INFO_KEY));
        workTimesTextView.setText(placeBundle.getString(PLACE_WORK_TIMES_KEY));
        pictureImageView.setImageResource(placeBundle.getInt(PLACE_IMAGE_RES_ID_KEY));


    }}
}
