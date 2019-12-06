package com.abiolasoft.productmanager.Services;

import java.util.List;

public class RepositoryService<T> {

    protected SharedPrefService<List<T>> persistence;

    public RepositoryService() {

    }

    public void add(T newItem) {
        List<T> list = persistence.getObject();
        list.add(newItem);
        persistence.setObject(list);
    }

    public void remove(T item) {
        List<T> list = persistence.getObject();
        list.add(item);
        persistence.setObject(list);

    }
    public List<T> getAll(){
        return persistence.getObject();
    }

    public T get(int index){
        return persistence.getObject().get(index);
    }
}
