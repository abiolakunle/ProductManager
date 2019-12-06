package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abiolasoft.productmanager.R;

public class MainActivity extends BaseActivity {

    private Button prodBtn, prodPropBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        prodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prodIntent = new Intent(MainActivity.this, AddProductActivity.class);
                startActivity(prodIntent);
            }
        });

        prodPropBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prodProdpIntent = new Intent(MainActivity.this, AddProductPropertyActivity.class);
                startActivity(prodProdpIntent);
            }
        });
    }

    private void initializeViews(){
        prodBtn = findViewById(R.id.products_btn);
        prodPropBtn = findViewById(R.id.products_property_btn);
    }
}
