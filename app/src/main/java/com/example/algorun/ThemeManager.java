package com.example.algorun;

import android.content.Context;

public class ThemeManager {
    public static void setCustomizedThemes(Context context, String theme){
        switch(theme){
            case "tea":
                context.setTheme(R.style.Tea);
                break;
            case "dark":
                context.setTheme(R.style.Dark);
                break;
            case "neo":
                context.setTheme(R.style.Neo);
                break;
        }
    }
}
