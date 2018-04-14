package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView categoryMuseums = (TextView) findViewById(R.id.category_museums);
        TextView categoryLandmarks = (TextView) findViewById(R.id.category_landmarks);
        TextView categoryShopping = (TextView) findViewById(R.id.category_shopping);
        TextView categotyParties = (TextView) findViewById(R.id.category_parties);

        //Create onClickListeners for the Museums Category TextView
        categoryMuseums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start a new intent to get into the MuseumsActivity
                Intent museumsIntent = new Intent(MainActivity.this, MuseumsActivity.class);
                startActivity(museumsIntent);
            }
        });

        //Create onClickListeners for the Landmarks Category TextView
        categoryLandmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start a new intent to get into the LandmarksActivity
                Intent landmarksIntent = new Intent(MainActivity.this, LandmarksActivity.class);
                startActivity(landmarksIntent);
            }
        });

        //Create onClickListeners for the Shopping Category TextView
        categoryShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start a new intent to get into the ShoppingActivity
                Intent shoppingIntent = new Intent(MainActivity.this, ShoppingActivity.class);
                startActivity(shoppingIntent);
            }
        });
        //Create onClickListeners for the Parties Category TextView
        categotyParties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start a new intent to get into the PartiesActivity
                Intent partiesIntent = new Intent(MainActivity.this, PartiesActivity.class);
                startActivity(partiesIntent);
            }
        });


    }
}
