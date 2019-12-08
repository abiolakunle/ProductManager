package com.abiolasoft.productmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.models.Product;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context context;
    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.product_single, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.prodNameTv.setText(products.get(position).getName());
        holder.prodDescTv.setText(products.get(position).getName());
        holder.prodPriceTv.setText(String.valueOf(products.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView prodNameTv, prodDescTv, prodPriceTv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView) {
            prodNameTv = itemView.findViewById(R.id.single_prod_name_tv);
            prodDescTv = itemView.findViewById(R.id.single_prod_desc_tv);
            prodPriceTv = itemView.findViewById(R.id.single_prod_price_tv);
        }
    }
}
