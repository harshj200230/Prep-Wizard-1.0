package com.example.minor_project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder> {

    private Context context;
    private List<pdfClass> pdfFiles;
    private OnItemClickListener onItemClickListener;

    public BookmarkAdapter(Context context, List<pdfClass> pdfFiles, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.pdfFiles = pdfFiles;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);
        return new BookmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
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

    private void showBookmarkDialog(pdfClass pdfFile, BookmarkViewHolder holder) {
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

    public static class BookmarkViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView bookmarkImage;

        public BookmarkViewHolder(@NonNull View itemView) {
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
        // Update the bookmark status in SharedPreferences
        SharedPreferences preferences = context.getSharedPreferences("BookmarkPrefs", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(pdfFile.getName(), pdfFile.isBookmarked()).apply();

        if (!pdfFile.isBookmarked()) {
            int position = pdfFiles.indexOf(pdfFile);
            if (position != -1) {
                pdfFiles.remove(position);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    notifyItemRemoved(position);
                } else {
                    // If not on the main thread, post to the main thread for UI updates
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(() -> notifyItemRemoved(position));
                }
            }
        }
    }
}

