package com.abiolasoft.productmanager.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.abiolasoft.productmanager.models.Category;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categories;
    private Context context;

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View singleItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            singleItemView = itemView.findViewById(android.R.layout.simple_list_item_1);
        }
    }
}
