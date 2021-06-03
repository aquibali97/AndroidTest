package com.example.androiddevelopmenttestt.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    // Todo: - Setters
    public static void setSharedPreferenceString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Development_test", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    // Todo: - Getters
    public static String getSharedPreferenceString(Context context, String key, String defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Development_test", 0);
        return sharedPreferences.getString(key, defValue);
    }

}
