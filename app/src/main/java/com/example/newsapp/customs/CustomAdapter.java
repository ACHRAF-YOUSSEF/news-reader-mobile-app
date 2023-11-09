package com.example.newsapp.customs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.interfaces.SelectListener;
import com.example.newsapp.models.NewsArticles;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsArticles> articles;
    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsArticles> articles, SelectListener listener) {
        this.context = context;
        this.articles = articles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.article_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.getText_title().setText(articles.get(position).getTitle());
        holder.getText_source().setText(articles.get(position).getSource().getName());

        if (articles.get(position).getUrlToImage() != null) {
            Picasso
                    .get()
                    .load(articles.get(position).getUrlToImage())
                    .into(holder.getImg_headline());
        }

        holder.getCardView().setOnClickListener(v -> {
            listener.OnNewsClicked(articles.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}