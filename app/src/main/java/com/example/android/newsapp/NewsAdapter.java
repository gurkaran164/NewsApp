package com.example.android.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

/**
 * Created by gurkaran on 16-02-2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }
        News currentNews = getItem(position);

        TextView numView=(TextView)listItemView.findViewById(R.id.number);
        String number=String.valueOf(currentNews.getnum());
        numView.setText(number);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String date=(currentNews.gettime());
        String formattedDate = formatDate(date);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(date);
        timeView.setText(formattedTime);

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentNews.getsec());
        TextView titView = (TextView) listItemView.findViewById(R.id.title);
        titView.setText(currentNews.gettitle());

        return listItemView;
    }
    private String formatDate(String dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        Date d=new Date();
        try {
            d=dateFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(d);
    }
    private String formatTime(String dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        Date d=new Date();
        try {
            d=timeFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeFormat.format(d);
    }
}
