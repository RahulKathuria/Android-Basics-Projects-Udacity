package com.example.android.musicplayerapp;

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
        TextView NowPlaying = (TextView) findViewById(R.id.NowPlaying);
        NowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNowPlaying = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(iNowPlaying);
            }
        });
        TextView Artist = (TextView) findViewById(R.id.artist);
        Artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iArtists = new Intent(MainActivity.this, Artist.class);
                startActivity(iArtists);
            }
        });
        TextView Album = (TextView) findViewById(R.id.albums);
        Album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAlbum = new Intent(MainActivity.this, Albums.class);
                startActivity(iAlbum);
            }
        });
        TextView Favourites = (TextView) findViewById(R.id.favourites);
        Favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFavourites = new Intent(MainActivity.this, Favourites.class);
                startActivity(iFavourites);
            }
        });
        TextView Tracks = (TextView) findViewById(R.id.tracks);
        Tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itracks = new Intent(MainActivity.this, Tracks.class);
                startActivity(itracks);
            }
        });
    }
}
