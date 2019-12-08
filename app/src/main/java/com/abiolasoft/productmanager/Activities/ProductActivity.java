package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abiolasoft.productmanager.Adapters.ProductAdapter;
import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.ProductService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button addProdPageBtn;

    private ProductAdapter productAdapter;
    private ProductService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initializeViews();

        addProdPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProdIntent = new Intent(ProductActivity.this, AddProductActivity.class);
                startActivity(addProdIntent);
            }
        });

        service = new ProductService(this);

        productAdapter = new ProductAdapter(service.getAll());

        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initializeViews() {
        recyclerView = findViewById(R.id.product_rv);
        addProdPageBtn = findViewById(R.id.add_prod_page_btn);
    }
}
