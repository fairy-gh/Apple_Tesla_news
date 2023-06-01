package com.fereshte.appletesllanews.data.local.model;

import java.util.List;

public class NewsModel {

    private String status;
    private int totalResults;
    private List<ArticlesObjectModel> articles;

    public NewsModel(String status, int totalResults, List<ArticlesObjectModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticlesObjectModel> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesObjectModel> articles) {
        this.articles = articles;
    }
}
