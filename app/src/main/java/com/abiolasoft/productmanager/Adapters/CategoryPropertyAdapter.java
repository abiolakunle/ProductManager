package com.abiolasoft.productmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.models.CategoryProperty;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryPropertyAdapter extends RecyclerView.Adapter<CategoryPropertyAdapter.ViewHolder> {

    private List<CategoryProperty> properties;
    private Context context;

    public CategoryPropertyAdapter(List<CategoryProperty> properties) {
        this.properties = properties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.product_property_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTv.setText(properties.get(position).getName());
        holder.valueTv.setText(properties.get(position).getValues().toString());
    }


    @Override
    public int getItemCount() {
        return properties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv, valueTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.single_name_tv);
            valueTv = itemView.findViewById(R.id.single_value_tv);
        }
    }
}
