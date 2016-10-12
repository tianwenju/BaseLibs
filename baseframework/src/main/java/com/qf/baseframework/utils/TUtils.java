package com.qf.baseframework.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class TUtils {

    public static <T> T getT(Object object, int i) {

        Type type = object.getClass().getGenericSuperclass();
        ParameterizedType mGenericSuperclass = (ParameterizedType) type;
        Class<T> mTClass = (Class<T>) mGenericSuperclass.getActualTypeArguments()[i];
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
