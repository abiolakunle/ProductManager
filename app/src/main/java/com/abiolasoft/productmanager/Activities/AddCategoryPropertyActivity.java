package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.CategoryPropertyService;
import com.abiolasoft.productmanager.models.CategoryProperty;
import com.abiolasoft.productmanager.models.PropertyValue;

public class AddCategoryPropertyActivity extends BaseActivity {

    private TextView propNameEtv, propValueEtv;
    private Button addPropBtn, addPropValueBtn;

    private CategoryProperty property;
    private CategoryPropertyService propertyService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category_property);
        initializeViews();

        property = new CategoryProperty();
        propertyService = new CategoryPropertyService(this);

        addPropValueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String propValue = propValueEtv.getText().toString();

                PropertyValue newValue = new PropertyValue();
                newValue.setValue(propValue);

                property.addValue(newValue);
                propValueEtv.setText("");
            }
        });

        addPropBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = propNameEtv.getText().toString();
                addProperty(name);

                Intent propIntent = new Intent(AddCategoryPropertyActivity.this, CategoryPropertyActivity.class);
                startActivity(propIntent);
            }
        });
    }

    private void initializeViews(){
        propNameEtv = findViewById(R.id.prop_name_etv);
        propValueEtv = findViewById(R.id.prop_value_etv);
        addPropBtn = findViewById(R.id.add_prop_btn);
        addPropValueBtn = findViewById(R.id.add_prop_value_btn);
    }

    private void addProperty(String name) {
        property.setName(name);
        propertyService.add(property);
    }
}
