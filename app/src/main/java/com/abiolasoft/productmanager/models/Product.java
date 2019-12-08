package com.abiolasoft.productmanager.models;

import java.util.ArrayList;
import java.util.List;


public class Product {

    private int id;
    private String name;
    private String description;
    private float  price;
    private List<ProductPropertyReference> propertyReferences;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  Product(){
        propertyReferences = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void addProperty(ProductPropertyReference newProperty) {
        propertyReferences.add(newProperty);
    }

    public void removeProperty(CategoryProperty property) {
        propertyReferences.remove(property);
    }

    public List<ProductPropertyReference> getPropertyReferences() {
        return propertyReferences;
    }
}
