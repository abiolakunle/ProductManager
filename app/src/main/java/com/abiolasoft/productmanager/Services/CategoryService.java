package com.abiolasoft.productmanager.Services;

import android.content.Context;

import com.abiolasoft.productmanager.models.Category;
import com.google.common.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CategoryService extends RepositoryService<Category> {

    public CategoryService(Context context) {
        persistence = new SharedPrefService<>(context, "CATEGORY", new TypeToken<List<Category>>() {
        });

        if (persistence.getObject() == null)
            persistence.setObject(new ArrayList<Category>());
    }

    @Override
    public void setId(Category item) {
        List<Category> properties = persistence.getObject();
        item.setId(properties.size() + 1);
    }
}
