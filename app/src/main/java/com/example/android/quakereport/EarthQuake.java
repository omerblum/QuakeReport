package com.example.android.quakereport;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

public class EarthQuake implements Adapter {
    private double mMag;
    private String mLoc;
    private long mTimeInMS;
    private String mURL;

    public EarthQuake(double mag, String loc, long time, String url){
        mMag = mag;
        mLoc = loc;
        mTimeInMS = time;
        mURL = url;
    }

    public String getmURL() {
        return mURL;
    }

    public void setmURL(String mURL) {
        this.mURL = mURL;
    }

    public long getmTimeInMS() {
        return mTimeInMS;
    }

    public void setmTimeInMS(long mTimeInMS) {
        this.mTimeInMS = mTimeInMS;
    }

    public double getmMag() {
        return mMag;
    }

    public void setmMag(double mMag) {
        this.mMag = mMag;
    }

    public String getmLoc() {
        return mLoc;
    }

    public void setmLoc(String mLoc) {
        this.mLoc = mLoc;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
