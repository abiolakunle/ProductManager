package com.abiolasoft.productmanager.Activities;

import android.os.Bundle;
import android.util.Log;

import com.abiolasoft.productmanager.Adapters.ProductPropertyAdapter;
import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.ProductPropertyService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductPropertyActivity extends AppCompatActivity {

    private RecyclerView prodPropRv;
    private ProductPropertyAdapter propertyAdapter;

    private ProductPropertyService propertyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_property);

        initializeViews();

        propertyService = new ProductPropertyService(this);

//        Intent intent = getIntent();
//        productService = (ProductService) intent.getSerializableExtra(PROD_SERVICE);
//        propertyService = (ProductPropertyService) intent.getSerializableExtra(PROP_SERVICE);

        Log.d("ABIOLZ", propertyService.getAll().toString());
        propertyAdapter = new ProductPropertyAdapter(propertyService.getAll());

        prodPropRv.setAdapter(propertyAdapter);
        prodPropRv.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initializeViews(){
        prodPropRv = findViewById(R.id.prod_prop_rv);
    }
}
