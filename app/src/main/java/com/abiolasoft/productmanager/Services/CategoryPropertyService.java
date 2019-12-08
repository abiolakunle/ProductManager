package com.abiolasoft.productmanager.Services;

import android.content.Context;

import com.abiolasoft.productmanager.models.CategoryProperty;
import com.google.common.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CategoryPropertyService extends RepositoryService<CategoryProperty> {

    public CategoryPropertyService(Context context) {
        persistence = new SharedPrefService<>(context, "CATEGORY_PROPERTIES", new TypeToken<List<CategoryProperty>>() {
        });
        if (persistence.getObject() == null)
            persistence.setObject(new ArrayList<CategoryProperty>());
    }

    @Override
    public void setId(CategoryProperty item) {
        List<CategoryProperty> properties = persistence.getObject();
        item.setId(properties.size() + 1);
    }
}
