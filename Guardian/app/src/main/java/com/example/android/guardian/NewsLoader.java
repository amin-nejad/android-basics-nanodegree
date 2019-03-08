package com.example.android.guardian;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        List<News> listOfNews = null;
        if (mUrl == null) {
            return null;
        }
        //URL url = QueryUtils.createUrl();
        listOfNews = QueryUtils.fetchData(mUrl);

        return listOfNews;
    }
}
