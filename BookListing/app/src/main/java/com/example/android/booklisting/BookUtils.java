package com.example.android.booklisting;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rk on 22-01-2017.
 */
public class BookUtils {
    private static final String LOG_TAG = BookUtils.class.getSimpleName();

    private BookUtils() {

    }

    public static List<BooksClass> fetchBooksData(String mUrl) throws IOException {
        URL url = createUrl(mUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }
        List<BooksClass> books = extractFeatureFromJson(jsonResponse);
        return books;

    }

    private static List<BooksClass> extractFeatureFromJson(String booksJSON) {
        if (TextUtils.isEmpty(booksJSON)) {
            return null;
        }
        List<BooksClass> books = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(booksJSON);
            JSONArray booksArray = baseJsonResponse.getJSONArray("items");

            for (int i = 0; i < booksArray.length(); i++) {
                JSONObject firstFeature = booksArray.getJSONObject(i);
                JSONObject items = firstFeature.getJSONObject("volumeInfo");
                String title = items.getString("title");
                String eTag = firstFeature.getString("etag");
                String publisher = items.getString("publisher");
                String author = items.getString("authors");

                books.add(new BooksClass(title, author, publisher, eTag));
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the books JSON results", e);
        }
        return books;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = null;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error Response Code :" + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the books json results", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;

    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


    private static URL createUrl(String mUrl) {
        URL url = null;
        try {
            url = new URL(mUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the Url", e);
        }
        return url;
    }
}
