package com.example.android.googlebooksapi;

public class Book {

    private int mYear;
    private String mTitle;
    private String mAuthor;
    private int mPages;
    private String mLanguage;
    private String mUrl;

    public Book(int Year, String Title, String Author, int Pages, String Language, String Url) {
        mYear = Year;
        mTitle = Title;
        mAuthor = Author;
        mPages = Pages;
        mLanguage = Language;
        mUrl = Url;
    }

    public int getYear() {
        return mYear;
    }
    public String getTitle() {
        return mTitle;
    }
    public String getAuthor() {
        return mAuthor;
    }
    public int getPages() {
        return mPages;
    }
    public String getLanguage() {
        return mLanguage;
    }
    public String getUrl() {
        return mUrl;
    }
}