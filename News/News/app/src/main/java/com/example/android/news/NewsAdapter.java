package com.example.android.news;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rk on 25-01-2017.
 */
public class NewsAdapter extends ArrayAdapter<NewsClass> {
    public NewsAdapter(Activity context, List<NewsClass> word) {
        super(context, 0, word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        NewsClass currentClass = getItem(position);


        TextView date = (TextView) listItemView.findViewById(R.id.date);
        String date1 = currentClass.getDate();
        date.setText(date1);

        TextView sectionName = (TextView) listItemView.findViewById(R.id.sectionName);
        String sectionName1 = currentClass.getSectionName();
        sectionName.setText(sectionName1);

        TextView webTitle = (TextView) listItemView.findViewById(R.id.webTitle);
        String webTitle1 = currentClass.getWebTitle();
        webTitle.setText(webTitle1);
        Log.i("adapter", "list view returned");
        return listItemView;
    }
}

