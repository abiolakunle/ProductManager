package com.abiolasoft.productmanager.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductProperty implements Serializable {

    private String name;
    private List<PropertyValue> values;

    public ProductProperty() {
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

}
