package com.fereshte.appletesllanews.data.local.model;

import java.util.List;

public class ArticleModel {

    private List<ArticlesObjectModel> articles;

    public ArticleModel(List<ArticlesObjectModel> articles) {
        this.articles = articles;
    }

    public List<ArticlesObjectModel> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesObjectModel> articles) {
        this.articles = articles;
    }
}
