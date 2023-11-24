package com.example.minor_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

        // Set long-press listener for bookmarking
        holder.itemView.setOnLongClickListener(view -> {
            // Show an alert dialog for bookmarking
            showBookmarkDialog(pdfFile, holder);

            return true;
        });

        // Set bookmark visibility
        holder.bookmarkImage.setVisibility(pdfFile.isBookmarked() ? View.VISIBLE : View.GONE);
    }

// ...

    private void showBookmarkDialog(pdfClass pdfFile, MainViewHolder holder) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Bookmark PDF");

        if (pdfFile.isBookmarked()) {
            builder.setMessage("Remove from bookmarks?");
            builder.setPositiveButton("Remove", (dialog, which) -> {
                // Toggle bookmark visibility
                pdfFile.setBookmarked(!pdfFile.isBookmarked());
                holder.bookmarkImage.setVisibility(View.GONE);

                // TODO: Update the bookmark status in your database or storage
                updateBookmarkStatus(pdfFile);
            });
        } else {
            builder.setMessage("Do you want to bookmark this PDF?");
            builder.setPositiveButton("Bookmark", (dialog, which) -> {
                // Toggle bookmark visibility
                pdfFile.setBookmarked(!pdfFile.isBookmarked());
                holder.bookmarkImage.setVisibility(View.VISIBLE);

                // TODO: Update the bookmark status in your database or storage
                updateBookmarkStatus(pdfFile);
            });
        }

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    @Override
    public int getItemCount() {
        return pdfFiles.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView bookmarkImage;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.pdfTextName);
            bookmarkImage = itemView.findViewById(R.id.bookmark);
        }
    }

    // Interface to handle item clicks
    public interface OnItemClickListener {
        void onItemClick(pdfClass pdfFile);
    }

    private void updateBookmarkStatus(pdfClass pdfFile) {
        // TODO: Update the bookmark status in your database or storage
    }
}
