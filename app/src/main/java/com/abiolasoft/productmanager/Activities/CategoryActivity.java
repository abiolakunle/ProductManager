package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.CategoryService;
import com.abiolasoft.productmanager.models.Category;
import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    private ListView categoryLv;
    private Button newCatBtn;

    private CategoryService categoryService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initializeViews();

        categoryService = new CategoryService(this);

        ArrayList<String> catStrings = new ArrayList<>();

        Log.d("FINDEX", new Gson().toJson(categoryService.getAll()));

        for (Category cat : categoryService.getAll()) {
            catStrings.add(cat.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catStrings);

        categoryLv.setAdapter(arrayAdapter);

        newCatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newCatIntent = new Intent(CategoryActivity.this, AddCategoryActivity.class);
                startActivity(newCatIntent);
            }
        });
    }

    private void initializeViews() {
        categoryLv = findViewById(R.id.category_lv);
        newCatBtn = findViewById(R.id.category_new_btn);
    }
}
