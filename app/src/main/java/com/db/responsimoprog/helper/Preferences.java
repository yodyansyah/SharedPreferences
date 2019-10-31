package com.db.responsimoprog.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static Preferences INSTANCE;
    private SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("simple.android.app",Context.MODE_PRIVATE);
    }

    public static Preferences getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new Preferences(context);
        }
        return INSTANCE;
    }
    public SharedPreferences Pref(){
        return sharedPreferences;
    }

    public Boolean isLogin(){
        return sharedPreferences.getBoolean("isLogin",false);
    }

    public void setLogin(Boolean isCall){
        sharedPreferences.edit().putBoolean("isLogin", isCall).apply();
    }

    public void setName(String isName){
        sharedPreferences.edit().putString("isName", isName).apply();
    }

    public String getName(){
        return sharedPreferences.getString("isName"," ");
    }
}

