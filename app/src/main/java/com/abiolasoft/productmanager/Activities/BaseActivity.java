package com.abiolasoft.productmanager.Activities;

import android.os.Bundle;

import com.abiolasoft.productmanager.R;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

//    protected ProductService productService;
//    protected CategoryPropertyService propertyService;
//    protected final String PROD_SERVICE = "PROD_SERVICE";
//    protected final String PROP_SERVICE = "PROP_SERVICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

//        productService = new ProductService();
//        propertyService = new CategoryPropertyService();
    }

//    protected void baseStartActivity(Intent intent){
//
////        intent.putExtra(PROD_SERVICE, productService);
////        intent.putExtra(PROP_SERVICE, propertyService);
//        startActivity(intent);
//    }
}
