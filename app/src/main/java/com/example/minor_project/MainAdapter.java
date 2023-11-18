package com.example.minor_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minor_project.R;
import com.example.minor_project.pdfClass;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context context;
    private List<pdfClass> pdfFiles;
    private OnItemClickListener onItemClickListener;

    public MainAdapter(Context context, List<pdfClass> pdfFiles, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.pdfFiles = pdfFiles;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        pdfClass pdfFile = pdfFiles.get(position);
        holder.txtName.setText(pdfFile.getName());
        holder.txtName.setSelected(true);

        // Set click listener on the item view
        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(pdfFile);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pdfFiles.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.pdfTextName);
        }
    }

    // Interface to handle item clicks
    public interface OnItemClickListener {
        void onItemClick(pdfClass pdfFile);
    }
}
