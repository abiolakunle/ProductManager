package com.abiolasoft.productmanager.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.models.CategoryProperty;
import com.abiolasoft.productmanager.models.ProductPropertyReference;
import com.abiolasoft.productmanager.models.PropertyValue;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductPropertyAdapter extends RecyclerView.Adapter<ProductPropertyAdapter.ViewHolder> {

    private List<CategoryProperty> categoryProperties;
    private List<ProductPropertyReference> productPropertyReferences;
    private Context context;

    public ProductPropertyAdapter(List<CategoryProperty> categoryProperties, List<ProductPropertyReference> productPropertyReferences) {
        this.categoryProperties = categoryProperties;
        this.productPropertyReferences = productPropertyReferences;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.add_prod_prop_single, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.propTv.setText(categoryProperties.get(position).getName());

        ArrayList<String> propValues = new ArrayList<>();

        for (PropertyValue propValue : categoryProperties.get(position).getValues()) {
            propValues.add(propValue.getValue());
        }

        ArrayAdapter<String> propValueAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_dropdown_item, propValues);

        holder.propValueSp.setAdapter(propValueAdapter);
        holder.propValueSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int spPosition, long id) {
                productPropertyReferences.get(position).setValueId(categoryProperties.get(position).getValues().get(spPosition).getId());
                Log.d("FINDEX", new Gson().toJson(productPropertyReferences));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryProperties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView propTv;
        private Spinner propValueSp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView) {
            propTv = itemView.findViewById(R.id.single_prop_name_tv);
            propValueSp = itemView.findViewById(R.id.single_prop_value_sp);
        }
    }
}
