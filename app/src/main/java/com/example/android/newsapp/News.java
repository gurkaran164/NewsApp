package com.example.android.newsapp;

/**
 * Created by gurkaran on 16-02-2017.
 */

public class News {
    private String msec;
    private String mUrl;
    private String mtitle;
    private String mtime;
    private int mnum;
    public News(int num,String sec,String time,String Url, String title) {
        msec = sec;
        mtime = time;
        mUrl = Url;
        mtitle = title;
       mnum=num;
    }

    public String getsec() {
        return msec;
    }

    public String getUrl() {
        return mUrl;
    }

    public String gettitle() {
        return mtitle;
    }

    public String gettime() {
        return mtime;
    }

    public int getnum() {
        return mnum;
    }
}
