package com.example.android.booklisting;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<BooksClass>> {
    private EditText editText;
    String edit = null;
    private String search_url = null;
    private static final int Book_Loader_ID = 1;
    private BookAdapter mAdapter;
    private TextView mEmptyTextView;

    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView bookListView = (ListView) findViewById(R.id.list);
        mEmptyTextView = (TextView) findViewById(R.id.empty_view);
        mAdapter = new BookAdapter(this, new ArrayList<BooksClass>());
        bookListView.setAdapter(mAdapter);
        search = (Button) findViewById(R.id.search_button);
        editText = (EditText) findViewById(R.id.editText);

        search_url = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=10";
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit = editText.getText().toString();
                search_url = "https://www.googleapis.com/books/v1/volumes?q=" + edit + "&maxResults=10";
                LoaderManager loaderManager;
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    mEmptyTextView.setVisibility(View.GONE);
                    loaderManager = getLoaderManager();

                    loaderManager.initLoader(Book_Loader_ID, null, MainActivity.this);
                } else {

                    View loadingIndicator = findViewById(R.id.loadingSpinner);
                    loadingIndicator.setVisibility(View.GONE);

                    mEmptyTextView.setText("No Internet connection");
                }
            }

        });

    }


    @Override
    public Loader<List<BooksClass>> onCreateLoader(int id, Bundle args) {
        Log.i("MainActivity", "loadercreated");
        return new BookLoader(this, search_url);

    }

    @Override
    public void onLoadFinished(Loader<List<BooksClass>> loader, List<BooksClass> data) {
        mEmptyTextView.setText("No Books Found");
        mAdapter.clear();
        ProgressBar progress = (ProgressBar) findViewById(R.id.loadingSpinner);
        progress.setVisibility(View.GONE);
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
            Log.i("MainActivity", "books added");
        }
    }

    @Override
    public void onLoaderReset(Loader<List<BooksClass>> loader) {
        mAdapter.clear();
        Log.i("MainActivity", "loaderreset");
    }
}
