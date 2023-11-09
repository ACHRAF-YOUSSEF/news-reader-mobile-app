package com.example.newsapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.customs.CustomAdapter;
import com.example.newsapp.interfaces.OnFetchDataListener;
import com.example.newsapp.interfaces.SelectListener;
import com.example.newsapp.manager.RequestManager;
import com.example.newsapp.models.NewsApiResponse;
import com.example.newsapp.models.NewsArticles;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private RequestManager requestManager;
    private ProgressDialog dialog;
    private Button b1, b2, b3, b4, b5, b6, b7;
    private SearchView searchView;
    private String category = "general";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching news articles of " + query);
                dialog.show();

                requestManager = new RequestManager(HomeActivity.this);

                requestManager.getNewsArticles(listener, category, query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news articles of general");
        dialog.show();

        b1 = findViewById(R.id.btn_1);
        b2 = findViewById(R.id.btn_2);
        b3 = findViewById(R.id.btn_3);
        b4 = findViewById(R.id.btn_4);
        b5 = findViewById(R.id.btn_5);
        b6 = findViewById(R.id.btn_6);
        b7 = findViewById(R.id.btn_7);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

        requestManager = new RequestManager(this);

        requestManager.getNewsArticles(listener, "general", null);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        category = button.getText().toString();

        dialog.setTitle("Fetching news articles of " + category);
        dialog.show();

        requestManager = new RequestManager(this);

        requestManager.getNewsArticles(listener, category, null);
    }

    @Override
    public void OnNewsClicked(NewsArticles articles) {
        startActivity(
                new Intent(HomeActivity.this, DetailsActivity.class)
                        .putExtra("data", articles)
        );
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsArticles> list, String message) {
            if (list.isEmpty()) {
                Toast.makeText(HomeActivity.this, "No data found!!!", Toast.LENGTH_SHORT).show();
            } else {
                showNews(list);

                dialog.dismiss();
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(HomeActivity.this, "An Error Occurred!!!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsArticles> list) {
        recyclerView = findViewById(R.id.recycler_main);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        adapter = new CustomAdapter(this, list, this);

        recyclerView.setAdapter(adapter);
    }
}