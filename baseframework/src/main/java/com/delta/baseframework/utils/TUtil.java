package com.delta.baseframework.utils;

import android.util.Log;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class TUtil {

    public static <T> T getT(Object object, int i) {

        Type type = object.getClass().getGenericSuperclass();
        ParameterizedType mGenericSuperclass = (ParameterizedType) type;
        Class<T> mTClass = (Class<T>) mGenericSuperclass.getActualTypeArguments()[i];
        Log.e("自定义标签", "getT: "+mTClass.getName());
        try {
            return mTClass.newInstance();
        } catch (InstantiationException mE) {
            mE.printStackTrace();
        } catch (IllegalAccessException mE) {
            mE.printStackTrace();
        }
        return null;
    }
    public static <T> T getSupterT(Object object, int i) {

        Type type = object.getClass().getSuperclass().getGenericSuperclass();
        ParameterizedType mGenericSuperclass = (ParameterizedType) type;
        Class<T> mTClass = (Class<T>) mGenericSuperclass.getActualTypeArguments()[i];
        Log.e("自定义标签", "getSupterT: "+mTClass.getName());
        try {
            return mTClass.newInstance();
        } catch (InstantiationException mE) {
            mE.printStackTrace();
        } catch (IllegalAccessException mE) {
            mE.printStackTrace();
        }
        return null;
    }

    public static Class<?> forname(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException mE) {
            mE.printStackTrace();
        }
        return null;
    }


}
