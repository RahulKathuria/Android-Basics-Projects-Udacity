package com.example.android.news;

/**
 * Created by Rk on 25-01-2017.
 */

public class NewsClass {
    private String mWebPublicationDate;
    private String mWebUrl;
    private String mSectionName;
    private String mWebTitle;


    public NewsClass(String sectionName, String publicationDate, String webTitle, String webUrl) {
        mWebPublicationDate = publicationDate;
        mWebUrl = webUrl;
        mSectionName = sectionName;
        mWebTitle = webTitle;

    }

    public String getDate() {
        return mWebPublicationDate;
    }

    public String getUrl() {
        return mWebUrl;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getWebTitle() {
        return mWebTitle;
    }

}