package com.sunzhouyu.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author sunyi
 * @create 2018/12/28
 */
public class AnnotationReflect {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.sunzhouyu.annotation.AnnotationTableTest");
            Class strClazz=String.class;
            Class strCla="".getClass();
            System.out.println(strClazz==strCla);

            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a.toString());
            }

            AnnotationTable annotationTable = (AnnotationTable) clazz.getAnnotation(AnnotationTable.class);
            System.out.println(annotationTable.tableName());
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                AnnotationFiled annotationFiled = field.getAnnotation(AnnotationFiled.class);
                System.out.println(annotationFiled.name() + "--->" + annotationFiled.type() + "--->" + annotationFiled.length());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
