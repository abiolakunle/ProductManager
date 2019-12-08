package com.abiolasoft.productmanager.Services;

import android.content.Context;

import com.abiolasoft.productmanager.models.Product;
import com.google.common.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ProductService extends RepositoryService<Product> {

    public ProductService(Context context) {
        persistence = new SharedPrefService<>(context, "PRODUCTS", new TypeToken<List<Product>>() {
        });
        if (persistence.getObject() == null)
            persistence.setObject(new ArrayList<Product>());
    }

    @Override
    public void setId(Product item) {
        List<Product> products = persistence.getObject();
        item.setId(products.size() + 1);
    }
}
