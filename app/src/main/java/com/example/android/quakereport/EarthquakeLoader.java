package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<EarthQuake>> {
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthQuake > loadInBackground() {
        // Perform the HTTP request for earthquake data and process the response.
        if (mUrl == null){
            return null;
        }
        List<EarthQuake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }

}

