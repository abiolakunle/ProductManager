package com.abiolasoft.productmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.models.CategoryProperty;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheckPropertyAdapter extends RecyclerView.Adapter<CheckPropertyAdapter.ViewHolder> {

    private List<CategoryProperty> properties;
    private List<Integer> selectedProps;
    private Context context;

    public CheckPropertyAdapter(List<CategoryProperty> properties, List<Integer> selectedProps) {
        this.properties = properties;
        this.selectedProps = selectedProps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.check_property_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.propCb.setText(properties.get(position).getName());

        final int positionId = properties.get(position).getId();

        holder.propCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    selectedProps.remove(positionId);
                } else {
                    if (!selectedProps.contains(properties.get(position))) {
                        selectedProps.add(positionId);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return properties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox propCb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView) {
            propCb = itemView.findViewById(R.id.check_prop_cb);
        }
    }
}
