package com.delta.baseframework;

import java.lang.reflect.ParameterizedType;

/**
 * Created by V.Wenju.Tian on 2016/9/1.
 */
public class Test extends Student<Test> {


    public static void main(String[] args) {
        Test test = new Test();
        Class clazz = test.getClass();
        System.out.print(clazz.getSuperclass() + "\n");
        ParameterizedType mGenericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
        Class cass = (Class) (mGenericSuperclass.getActualTypeArguments()[0]);
        System.out.print(cass.toString());
    }

}

class Student<T extends Test> {

}
