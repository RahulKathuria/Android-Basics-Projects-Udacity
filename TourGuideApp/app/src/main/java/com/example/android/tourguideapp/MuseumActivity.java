package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Tour> Tours = new ArrayList<Tour>();
        Tours.add(new Tour(getString(R.string.Rail)));
        Tours.add(new Tour(getString(R.string.gallery)));
        Tours.add(new Tour(getString(R.string.smriti)));
        Tours.add(new Tour(getString(R.string.force)));
        TourAdapter adapter = new TourAdapter(this, Tours, R.color.category_museum);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}

