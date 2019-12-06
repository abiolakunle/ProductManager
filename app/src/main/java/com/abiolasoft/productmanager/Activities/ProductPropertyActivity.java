package com.abiolasoft.productmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.abiolasoft.productmanager.Adapters.ProductPropertyAdapter;
import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.ProductPropertyService;
import com.abiolasoft.productmanager.Services.ProductService;

public class ProductPropertyActivity extends BaseActivity {

    private RecyclerView prodPropRv;
    private ProductPropertyAdapter propertyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_property);

        initializeViews();

        Intent intent = getIntent();
        productService = (ProductService) intent.getSerializableExtra(PROD_SERVICE);
        propertyService = (ProductPropertyService) intent.getSerializableExtra(PROP_SERVICE);

        propertyAdapter = new ProductPropertyAdapter(propertyService.getAll());

        prodPropRv.setAdapter(propertyAdapter);
        prodPropRv.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initializeViews(){
        prodPropRv = findViewById(R.id.prod_prop_rv);
    }
}
