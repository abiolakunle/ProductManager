package com.abiolasoft.productmanager.models;

import java.util.ArrayList;
import java.util.List;

public class CategoryProperty {

    private int id;
    private String name;
    private List<PropertyValue> values;

    public CategoryProperty() {
        values = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addValue(PropertyValue newValue) {
        values.add(newValue);
    }

    public List<PropertyValue> getValues() {
        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
