package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MonumentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Tour> Tours = new ArrayList<Tour>();
        Tours.add(new Tour(getString(R.string.red_fort), R.drawable.red_fort));
        Tours.add(new Tour(getString(R.string.qutub), R.drawable.qutub_minar));
        Tours.add(new Tour(getString(R.string.India), R.drawable.india_gate));

        TourAdapter adapter = new TourAdapter(this, Tours, R.color.category_monuments);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }

}
