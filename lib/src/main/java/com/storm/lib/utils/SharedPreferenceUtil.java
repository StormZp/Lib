package com.storm.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by XYSM on 2018/6/4.
 */

public class SharedPreferenceUtil {
    private static SharedPreferences mSharedPreferences;

    public static void init(Context context) {
        if (context != null)
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static boolean insert(String key, Object value) {
        return put(key, value);
    }

    public static String read(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public static int read(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    public static Long read(String key, Long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

    public static Boolean read(String key, Boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public static Float read(String key, Float defValue) {
        return mSharedPreferences.getFloat(key, defValue);
    }

    public static boolean put(String key, Object value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        if (value instanceof String) {
            editor.putString(key, (String) value);
        }

        if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        }

        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        }
        if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }
        if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }

        return editor.commit();

    }

    //判断是否有key
    public static boolean hasKey(String key) {
        return mSharedPreferences.contains(key);
    }

}
