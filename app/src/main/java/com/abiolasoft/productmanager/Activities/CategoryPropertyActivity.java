package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abiolasoft.productmanager.Adapters.CategoryPropertyAdapter;
import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.CategoryPropertyService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryPropertyActivity extends AppCompatActivity {

    private RecyclerView catPropRv;
    private Button addCatPropPageBtn;

    private CategoryPropertyAdapter propertyAdapter;

    private CategoryPropertyService propertyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_property);

        initializeViews();
        addCatPropPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCatPropIntent = new Intent(CategoryPropertyActivity.this, AddCategoryPropertyActivity.class);
                Toast.makeText(CategoryPropertyActivity.this, "Clicked me", Toast.LENGTH_LONG).show();
                startActivity(addCatPropIntent);
            }
        });

        propertyService = new CategoryPropertyService(this);

        propertyAdapter = new CategoryPropertyAdapter(propertyService.getAll());

        catPropRv.setAdapter(propertyAdapter);
        catPropRv.setLayoutManager(new LinearLayoutManager(this));


    }

    private void initializeViews(){
        catPropRv = findViewById(R.id.prod_prop_rv);
        addCatPropPageBtn = findViewById(R.id.cat_prop_new_btn);
    }
}
