package com.example.tuniwwayandroid.explore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuniwwayandroid.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<String> categories;
    ArrayList<Integer> icons;

    public CategoryAdapter(Context context, ArrayList<String> categories, ArrayList<Integer> icons) {
        this.context = context;
        this.categories = categories;
        this.icons = icons;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String categoryName = categories.get(position);

        holder.txtCategory.setText(categoryName);
        holder.imgCategory.setImageResource(icons.get(position));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DestinationDetailActivity.class);
            intent.putExtra("category", categoryName);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCategory;
        TextView txtCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCategory = itemView.findViewById(R.id.imgCategory);
            txtCategory = itemView.findViewById(R.id.txtCategory);
        }
    }
}