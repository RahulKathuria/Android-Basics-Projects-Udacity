package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Tour> Tours = new ArrayList<Tour>();
        Tours.add(new Tour(getString(R.string.canaught)));
        Tours.add(new Tour(getString(R.string.Chandni)));
        Tours.add(new Tour(getString(R.string.Palika)));
        Tours.add(new Tour(getString(R.string.Kipps)));
        TourAdapter adapter = new TourAdapter(this, Tours, R.color.category_markets);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
