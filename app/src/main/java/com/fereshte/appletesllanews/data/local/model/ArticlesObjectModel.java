package com.fereshte.appletesllanews.data.local.model;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class ArticlesObjectModel {

//    private Source source;
//    private String author;
    private String title;
//    private String description;
//    private String url;
    private String urlToImage;
    private String publishedAt;
//    private String content;


    public ArticlesObjectModel(String title, String urlToImage, String publishedAt) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    @BindingAdapter({"android:imageView"})
    public static void loadNewsImage(ImageView img, String imgLink){
        Picasso
                .get()
                .load(imgLink)
                .into(img);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
