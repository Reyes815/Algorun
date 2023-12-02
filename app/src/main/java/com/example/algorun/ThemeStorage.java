package com.example.algorun;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemeStorage {
    public static void setThemeColor(Context context, String themeColor){
        SharedPreferences sharedPreferences = context.getSharedPreferences("theme_data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("theme",themeColor);
        editor.apply();
    }

    public static String getThemeColor(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("theme_data",Context.MODE_PRIVATE);
        return sharedPreferences.getString("theme","grey");
    }
}
