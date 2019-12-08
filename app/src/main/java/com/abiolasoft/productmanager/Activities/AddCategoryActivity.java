package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abiolasoft.productmanager.Adapters.CheckPropertyAdapter;
import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.CategoryPropertyService;
import com.abiolasoft.productmanager.Services.CategoryService;
import com.abiolasoft.productmanager.models.Category;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddCategoryActivity extends AppCompatActivity {

    private TextView catNameEtv;
    private Button addCatBtn;
    private RecyclerView propRv;


    private CategoryService categoryService;
    private CategoryPropertyService categoryPropertyService;
    private Category category;
    private List<Integer> selectedProp;
    private CheckPropertyAdapter checkPropertyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        initializeViews();


        categoryService = new CategoryService(this);
        categoryPropertyService = new CategoryPropertyService(this);

        category = new Category();

        selectedProp = new ArrayList<>();

        checkPropertyAdapter = new CheckPropertyAdapter(categoryPropertyService.getAll(), selectedProp);
        propRv.setAdapter(checkPropertyAdapter);
        propRv.setLayoutManager(new LinearLayoutManager(this));


        addCatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = catNameEtv.getText().toString();
                category.setName(name);

                for (int propId : selectedProp) {
                    category.addProperty(propId);
                }
                categoryService.add(category);
                Intent catIntent = new Intent(AddCategoryActivity.this, CategoryActivity.class);
                startActivity(catIntent);
            }
        });

    }


    private void initializeViews() {
        catNameEtv = findViewById(R.id.add_cat_name_etv);
        addCatBtn = findViewById(R.id.add_cat_btn);
        propRv = findViewById(R.id.add_cat_prop_rv);
    }
}
