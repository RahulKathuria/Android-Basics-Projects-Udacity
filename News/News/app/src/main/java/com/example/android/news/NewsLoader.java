package com.example.android.news;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rk on 25-01-2017.
 */
public class NewsLoader extends AsyncTaskLoader<List<NewsClass>> {
    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<NewsClass> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<NewsClass> news = null;

        try {
            news = NewsUtils.fetchBooksData(mUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return news;
    }
}