package com.example.minor_project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {

    public TextView txtName;
    public CardView cardView;

    public MainViewHolder(@NonNull View itemView, boolean b) {
        super(itemView);

        txtName=itemView.findViewById(R.id.pdfTextName);
        cardView=itemView.findViewById(R.id.pdfCardView);

    }
}
