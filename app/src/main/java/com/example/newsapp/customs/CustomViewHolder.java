package com.example.newsapp.customs;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    private TextView text_title, text_source;
    private ImageView img_headline;
    private CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_source);
        img_headline = itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);
    }

    public TextView getText_title() {
        return text_title;
    }

    public void setText_title(TextView text_title) {
        this.text_title = text_title;
    }

    public TextView getText_source() {
        return text_source;
    }

    public void setText_source(TextView text_source) {
        this.text_source = text_source;
    }

    public ImageView getImg_headline() {
        return img_headline;
    }

    public void setImg_headline(ImageView img_headline) {
        this.img_headline = img_headline;
    }

    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }
}