package com.example.android.booklisting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rk on 22-01-2017.
 */
public class BookAdapter extends ArrayAdapter<BooksClass> {
    public BookAdapter(Activity context, List<BooksClass> word) {
        super(context, 0, word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        BooksClass currentClass = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.title);
        String output = currentClass.getTitle();
        title.setText(output);

        TextView authors = (TextView) listItemView.findViewById(R.id.author);
        String author = currentClass.getAuthor();
        authors.setText(author);

        TextView publishers = (TextView) listItemView.findViewById(R.id.publisher);
        String publisher = currentClass.getPublisher();
        publishers.setText(publisher);

        TextView eTags = (TextView) listItemView.findViewById(R.id.eTag);
        String eTag = currentClass.getEtag();
        eTags.setText(eTag);

        return listItemView;
    }
}

