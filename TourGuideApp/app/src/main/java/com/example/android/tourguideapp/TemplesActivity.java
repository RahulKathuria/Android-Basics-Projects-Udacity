package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TemplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Tour> Tours = new ArrayList<Tour>();
        Tours.add(new Tour(getString(R.string.lotus)));
        Tours.add(new Tour(getString(R.string.Jama)));
        Tours.add(new Tour(getString(R.string.sahib)));
        Tours.add(new Tour(getString(R.string.akshardham)));
        TourAdapter adapter = new TourAdapter(this, Tours, R.color.category_temples);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }

}
