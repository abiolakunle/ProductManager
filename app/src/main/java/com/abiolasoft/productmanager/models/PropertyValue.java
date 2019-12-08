package com.abiolasoft.productmanager.models;

public class PropertyValue {

    private static int count;
    private int id;
    private String value;

    public PropertyValue() {
        id = count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
