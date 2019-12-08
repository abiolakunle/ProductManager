package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abiolasoft.productmanager.R;

public class MainActivity extends BaseActivity {

    private Button prodBtn, catPropBtn, catBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        prodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prodIntent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(prodIntent);
            }
        });

        catPropBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prodProdIntent = new Intent(MainActivity.this, CategoryPropertyActivity.class);
                startActivity(prodProdIntent);
            }
        });

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent catIntent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(catIntent);
            }
        });


    }

    private void initializeViews(){
        prodBtn = findViewById(R.id.products_btn);
        catPropBtn = findViewById(R.id.category_property_btn);
        catBtn = findViewById(R.id.category_btn);
    }
}
