package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.models.ProductProperty;

public class AddProductPropertyActivity extends BaseActivity {

    private TextView propNameEtv, propValueEtv;
    private Button addPropBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_property);
        initializeViews();

        addPropBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = propNameEtv.getText().toString();
                String value = propValueEtv.getText().toString();

                addProperty(name, value);

                Intent propIntent = new Intent(AddProductPropertyActivity.this, ProductPropertyActivity.class);
                baseStartActivity(propIntent);
            }
        });
    }

    private void initializeViews(){
        propNameEtv = findViewById(R.id.prop_name_etv);
        propValueEtv = findViewById(R.id.prop_value_etv);
        addPropBtn = findViewById(R.id.add_prop_btn);
    }

    private void addProperty(String name, String value){

        ProductProperty property = new ProductProperty();
        property.setName(name);
        property.setValue(value);

        propertyService.add(property);
    }
}
