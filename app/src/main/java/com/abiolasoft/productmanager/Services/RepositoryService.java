package com.abiolasoft.productmanager.Services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositoryService<T> implements Serializable {
    private List<T> items;

    public RepositoryService(){
        items = new ArrayList<T>();
    }

    public void add(T newProduct){
        items.add(newProduct);
    }

    public void remove(T product){
        items.remove(product);
    }
    public List<T> getAll(){
        return items;
    }

    public T get(int index){
        return items.get(index);
    }
}
