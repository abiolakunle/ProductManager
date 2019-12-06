package com.abiolasoft.productmanager.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {

    private String name;
    private String description;
    private float  price;
    private List<ProductProperty> properties;

    public  Product(){
        properties = new ArrayList<ProductProperty>();
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

    public void addProperty(ProductProperty newProperty){
        properties.add(newProperty);
    }

    public void removeProperty(ProductProperty property){
        properties.remove(property);
    }

    public List<ProductProperty> getProperties() {
        return properties;
    }
}
