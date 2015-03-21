package com.swarup.kayhan.movies;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kayhan on 3/21/2015.
 */
public class Movie extends DialogFragment {

    public final int ALL = 0;
    public final int ACTION = 1;
    public final int ANIMATION = 2;
    public final int COMEDY = 3;
    public final int THRILLER = 4;
    public final int CRIME = 5;

    public int genre;
    public WebView webView;
    public TextView yearTextView;
    public String title;
    public int year;
    public String url;
    View view;

    public Movie(){}

    @SuppressLint("ValidFragment")
    public Movie(String name,int genre,int year,String url){
        this.title = name;
        this.genre = genre;
        this.year = year;
        this.url = url;
//        getDialog().setTitle(title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.movie_layout,container,true);
        yearTextView = (TextView)view.findViewById(R.id.year_textView);
        webView = (WebView)view.findViewById(R.id.image_webView);
        webView.loadUrl(url);
        yearTextView.setText("Year: "+String.valueOf(year));
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

        getDialog().setTitle(title);

        return view;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
        if(webView!=null){

        }

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        this.year = year;
        if(yearTextView!=null)
            yearTextView.setText("Year: "+String.valueOf(year));
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
}
