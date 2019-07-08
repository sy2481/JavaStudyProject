package com.sunzhouyu.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * @author sunyi
 * @create 2018/12/28
 */
public class AnnotationReflect02 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.sunzhouyu.annotation.AnnotationTableTest");
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());
            System.out.println(clazz.getPackage());
//            Field[] fields1 = clazz.getFields();
            Field[] fields=clazz.getDeclaredFields();
            System.out.println(fields.length);
            for (Field field:fields){

                System.out.println(field);
                System.out.println(field.getName());
            }

            Method[] methods=clazz.getMethods();
            for(Method method:methods){
                System.out.println(method.getName()  );
            }
            System.out.println("--------");
            Method[] methods1=clazz.getDeclaredMethods();
            for(Method method:methods1){
                System.out.println(method.getName()  );
            }
            System.out.println("--------");
            Constructor[] constructors= clazz.getDeclaredConstructors();
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }
            System.out.println("--------");
            System.out.println(clazz.getDeclaredConstructor(String.class,String.class,int.class));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
