package com.abiolasoft.productmanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.abiolasoft.productmanager.Adapters.ProductPropertyAdapter;
import com.abiolasoft.productmanager.R;
import com.abiolasoft.productmanager.Services.CategoryPropertyService;
import com.abiolasoft.productmanager.Services.CategoryService;
import com.abiolasoft.productmanager.Services.ProductService;
import com.abiolasoft.productmanager.models.Category;
import com.abiolasoft.productmanager.models.CategoryProperty;
import com.abiolasoft.productmanager.models.Product;
import com.abiolasoft.productmanager.models.ProductPropertyReference;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddProductActivity extends BaseActivity {

    List<CategoryProperty> categoryProperties;
    private TextView prodNameEtv, prodDescEtv, prodPriceEtv;
    private Button addProdBtn;
    private Spinner catSpin;
    private RecyclerView catPropRv;
    private ProductService productService;
    private CategoryService categoryService;
    private CategoryPropertyService categoryPropertyService;
    private ProductPropertyAdapter productPropertyAdapter;
    private Category category;
    private Product newProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        initializeViews();

        newProduct = new Product();

        productService = new ProductService(this);
        categoryService = new CategoryService(this);
        categoryPropertyService = new CategoryPropertyService(this);

        //will hold properties of currently selected category properties
        categoryProperties = new ArrayList<>();

        final List<Category> allCategories = categoryService.getAll();
        //get cat name strings from cat list for the purpose of use for cat spinner array adapter
        final ArrayList<String> catNames = new ArrayList<>();
        for (Category cat : allCategories) {
            catNames.add(cat.getName());
        }
        ArrayAdapter spinAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, catNames);
        catSpin.setAdapter(spinAdapter);

        //design uses ui (in this case the spinner) to restrict properties that will be assigned to a product
        catSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = allCategories.get(position);
                categoryProperties.clear();

                newProduct.getPropertyReferences().clear();


                List<Integer> categoryIds = category.getProperties();
                //populate category properties list with list of category properties in selected category ids list
                for (int catProdId : categoryIds) {
                    //add property to properties list
                    CategoryProperty catProp = categoryPropertyService.get(categoryIds.indexOf(catProdId));
                    categoryProperties.add(catProp);

                    //populate property reference of newProduct with name and default values of property
                    ProductPropertyReference prodPropRef = new ProductPropertyReference();
                    prodPropRef.setNameId(catProdId);
                    prodPropRef.setValueId(catProp.getValues().get(0).getId());
                    newProduct.addProperty(prodPropRef);
                }

                productPropertyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        category = allCategories.get(catSpin.getSelectedItemPosition());


        productPropertyAdapter = new ProductPropertyAdapter(categoryProperties, newProduct.getPropertyReferences());
        catPropRv.setAdapter(productPropertyAdapter);
        catPropRv.setLayoutManager(new LinearLayoutManager(this));


        addProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prodName = prodNameEtv.getText().toString();
                String prodDesc = prodDescEtv.getText().toString();
                float prodPrice = Float.parseFloat(prodPriceEtv.getText().toString());


                newProduct.setName(prodName);
                newProduct.setDescription(prodDesc);
                newProduct.setPrice(prodPrice);

                productService.add(newProduct);

                Intent prodIntent = new Intent(AddProductActivity.this, ProductActivity.class);
                startActivity(prodIntent);
            }
        });

    }

    private void initializeViews() {
        prodNameEtv = findViewById(R.id.prod_name_etv);
        prodDescEtv = findViewById(R.id.prod_desc_etv);
        prodPriceEtv = findViewById(R.id.prod_price_etv);
        addProdBtn = findViewById(R.id.add_prod_btn);
        catSpin = findViewById(R.id.add_prod_cat_sp);
        catPropRv = findViewById(R.id.add_prod_prop_rv);
    }
}
