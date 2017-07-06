package com.example.android.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rk on 22-01-2017.
 */

public class BookLoader extends AsyncTaskLoader<List<BooksClass>> {
    private String mUrl;

    public BookLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<BooksClass> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<BooksClass> books = null;

        try {
            books = BookUtils.fetchBooksData(mUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}

