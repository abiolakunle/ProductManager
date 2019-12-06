package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.ProductPropertyService;
import com.abiolasoft.productmanager.models.ProductProperty;
import com.abiolasoft.productmanager.models.PropertyValue;

public class AddProductPropertyActivity extends BaseActivity {

    private TextView propNameEtv, propValueEtv;
    private Button addPropBtn, addPropValueBtn;

    private ProductProperty property;
    private ProductPropertyService propertyService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_property);
        initializeViews();

        property = new ProductProperty();
        propertyService = new ProductPropertyService(this);
        Log.d("ABIOLZZ", propertyService.getAll().toString());

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

                Intent propIntent = new Intent(AddProductPropertyActivity.this, ProductPropertyActivity.class);
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

        Log.d("ABIOLZZ", propertyService.getAll().toString());
    }
}
