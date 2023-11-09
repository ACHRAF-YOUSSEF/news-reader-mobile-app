package com.example.newsapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.models.NewsArticles;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    private NewsArticles acticles;
    private TextView text_title, text_author, text_time, text_detail, text_content;
    private ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        text_title = findViewById(R.id.text_detail_title);
        text_author = findViewById(R.id.text_detail_author);
        text_time = findViewById(R.id.text_detail_time);
        text_detail = findViewById(R.id.text_detail_detail);
        text_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);

        acticles = (NewsArticles) getIntent().getSerializableExtra("data");

        text_title.setText(acticles.getTitle());
        text_author.setText(acticles.getAuthor());
        text_time.setText(acticles.getPublishedAt());
        text_detail.setText(acticles.getDescription());
        text_content.setText(acticles.getContent());

        Picasso.get().load(acticles.getUrlToImage()).into(img_news);
    }
}