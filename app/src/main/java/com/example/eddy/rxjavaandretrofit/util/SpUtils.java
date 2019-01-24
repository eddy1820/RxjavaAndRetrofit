package com.example.eddy.rxjavaandretrofit.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
    public static String TOKEN = "TOKEN";
    private static SharedPreferences sp;
    public static void putParam(Context context,
                                String paramName, boolean value) {
        sp = context.getSharedPreferences("config" ,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(paramName, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context,String paramName,boolean defautValue){
        sp = context.getSharedPreferences("config" ,
                Context.MODE_PRIVATE);
        return sp.getBoolean(paramName, defautValue);
    }

    public static String getString(Context context,String paramName){
        sp = context.getSharedPreferences("config" ,
                Context.MODE_PRIVATE);
        return sp.getString(paramName, "" );
    }

    public static int getInt(Context context,String paramName){
        sp = context.getSharedPreferences("config" ,
                Context.MODE_PRIVATE);
        return sp.getInt(paramName, 0);
    }

    public static void putParam(Context context,
                                String paramName, String value) {
        sp = context.getSharedPreferences("config" ,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(paramName, value);
        editor.commit();
    }

    public static void putParam(Context context,
                                String paramName, int value) {
        sp = context.getSharedPreferences("config" ,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(paramName, value);
        editor.apply();
    }
}