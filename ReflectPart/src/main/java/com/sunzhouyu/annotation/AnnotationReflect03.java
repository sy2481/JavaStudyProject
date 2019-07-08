package com.sunzhouyu.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author sunyi
 * @create 2018/12/28
 */
public class AnnotationReflect03 {
    public static void main(String[] args) {
        try {
            Class<AnnotationTableTest> clazz = (Class<AnnotationTableTest>) Class.forName("com.sunzhouyu.annotation.AnnotationTableTest");
            Constructor constructor = clazz.getDeclaredConstructor(String.class, String.class, int.class);
            AnnotationTableTest annotationTableTest = (AnnotationTableTest) constructor.newInstance("1", "1", 1);
            System.out.println(annotationTableTest.getAge());

            AnnotationTableTest annotationTable = clazz.newInstance();
            Method method = clazz.getMethod("setName", String.class);
            method.invoke(annotationTable, "111");
            System.out.println(annotationTable.getId() + "--->" + annotationTable.getName() + "--->" + annotationTable.getAge());

            AnnotationTableTest a = clazz.newInstance();
            Field fielda = clazz.getDeclaredField("a");
            fielda.setAccessible(true);
            fielda.set(a, "bb");
            System.out.println(fielda.get(a));

            AnnotationTableTest b = clazz.newInstance();
            Field fieldb = clazz.getDeclaredField("b");
            fieldb.setAccessible(true);
            fieldb.set(b, 1);
            System.out.println(fieldb.get(b));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
