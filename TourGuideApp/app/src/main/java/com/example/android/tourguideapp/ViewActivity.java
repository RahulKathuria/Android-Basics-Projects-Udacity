package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        TextView monuments = (TextView) findViewById(R.id.monuments);
        TextView museum = (TextView) findViewById(R.id.museum);
        TextView markets = (TextView) findViewById(R.id.markets);
        TextView temples = (TextView) findViewById(R.id.temples);

        monuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monumentIntent = new Intent(ViewActivity.this, MonumentsActivity.class);
                startActivity(monumentIntent);
            }

        });
        markets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent marketIntent = new Intent(ViewActivity.this, MarketActivity.class);
                startActivity(marketIntent);
            }

        });
        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent museumIntent = new Intent(ViewActivity.this, MuseumActivity.class);
                startActivity(museumIntent);
            }

        });
        temples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent templesIntent = new Intent(ViewActivity.this, TemplesActivity.class);
                startActivity(templesIntent);
            }

        });


    }

}
