package com.abiolasoft.productmanager.Services;

import android.content.Context;

import com.abiolasoft.productmanager.models.ProductProperty;
import com.google.common.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ProductPropertyService extends RepositoryService<ProductProperty>  {

    public ProductPropertyService(Context context) {
        persistence = new SharedPrefService<>(context, "PRODUCT_PROPERTIES", new TypeToken<List<ProductProperty>>() {
        });
        if (persistence.getObject() == null)
            persistence.setObject(new ArrayList<ProductProperty>());
    }
}
