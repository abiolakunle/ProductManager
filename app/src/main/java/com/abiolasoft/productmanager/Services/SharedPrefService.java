package com.abiolasoft.productmanager.Services;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class SharedPrefService<T> {

    private Editor editor;
    private Context context;
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private String key;

    //https://stackoverflow.com/questions/14503881/strange-behavior-when-deserializing-nested-generic-classes-with-gson/14506181#14506181
    private TypeToken<T> typeToken;


    public SharedPrefService(Context context, String key, TypeToken<T> type) {
        typeToken = type;
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences(key, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        this.key = key;
    }

    public T getObject() {
        String objectJson = sharedPreferences.getString(key, "");
        return gson.fromJson(objectJson, typeToken.getType());
    }

    public void setObject(T newObject) {
        String objectJson = gson.toJson(newObject);
        editor.putString(key, objectJson);
        editor.commit();
    }
}
