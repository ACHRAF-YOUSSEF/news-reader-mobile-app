package com.example.newsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        imageView = findViewById(R.id.image);

        imageView.setOnClickListener(e -> {
            Intent intent = new Intent(this, HomeActivity.class);

            startActivity(intent);
        });
    }
}