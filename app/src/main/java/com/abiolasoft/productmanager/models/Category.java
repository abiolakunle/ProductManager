package com.abiolasoft.productmanager.models;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String name;
    private List<Integer> properties;

    public Category() {
        properties = new ArrayList<>();
    }

    public List<Integer> getProperties() {
        return properties;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProperty(int newProperty) {
        properties.add(newProperty);
    }

    public void removeProperty(CategoryProperty property) {
        properties.remove(property);
    }

    public int getProperty(int index) {
        return properties.get(index);
    }

//    @Override
//    public String toString() {
//        return name;
//    }
}
