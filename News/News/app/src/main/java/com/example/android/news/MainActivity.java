package com.example.android.news;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsClass>> {
    private String search_url = null;
    private static final int News_Loader_ID = 1;
    private NewsAdapter mAdapter;
    private TextView mEmptyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView newsListView = (ListView) findViewById(R.id.list);
        mEmptyTextView = (TextView) findViewById(R.id.empty_view);
        mAdapter = new NewsAdapter(MainActivity.this, new ArrayList<NewsClass>());
        newsListView.setAdapter(mAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NewsClass mClass = mAdapter.getItem(i);
                Uri newsUri = Uri.parse(mClass.getUrl());
                Intent newsIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(Intent.createChooser(newsIntent, "open with"));
            }
        });

        search_url = "http://content.guardianapis.com/search?from-date=2005-12-07&q=" +
                "cricket&api-key=465c3257-be44-4291-a719-9fed82089931";
        android.app.LoaderManager loaderManager;
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            mEmptyTextView.setVisibility(View.GONE);
            loaderManager = getLoaderManager();
            loaderManager.initLoader(News_Loader_ID, null, MainActivity.this);
        } else {

            View loadingIndicator = findViewById(R.id.loadingSpinner);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyTextView.setText("No Internet connection");
        }
    }


    @Override
    public Loader<List<NewsClass>> onCreateLoader(int id, Bundle args) {
        Log.i("MainActivity", "loadercreated");
        return new NewsLoader(this, search_url);

    }


    @Override
    public void onLoadFinished(Loader<List<NewsClass>> loader, List<NewsClass> data) {
        mEmptyTextView.setText("No News Found");
        mAdapter.clear();
        ProgressBar progress = (ProgressBar) findViewById(R.id.loadingSpinner);
        progress.setVisibility(View.GONE);
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
            Log.i("MainActivity", "books added");
        } else mEmptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<List<NewsClass>> loader) {
        mAdapter.clear();
        Log.i("MainActivity", "loaderreset");
    }
}
