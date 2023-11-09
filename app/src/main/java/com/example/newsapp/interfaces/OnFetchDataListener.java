package com.example.newsapp.interfaces;

import com.example.newsapp.models.NewsArticles;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsArticles> list, String  message);
    void onError(String message);
}