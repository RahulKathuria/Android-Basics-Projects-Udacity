package com.example.android.booklisting;

/**
 * Created by Rk on 22-01-2017.
 */
public class BooksClass {
    private String mTitle;
    private String mAuthor;
    private String mPublisher;
    private String mEtag;


    public BooksClass(String title, String author, String publisher, String eTag) {
        mTitle = title;
        mAuthor = author;
        mPublisher = publisher;
        mEtag = eTag;

    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public String getEtag() {
        return mEtag;
    }

}
