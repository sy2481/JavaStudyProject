package com.sunzhouyu.annotation;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author sunyi
 * @create 2018/12/28
 */
public class AnnotationReflect05 {
    public void test01(Map<String,User> map,List<User> list,int a){
        System.out.println("Demo04.test01()");
    }

    public Map<Integer,User> test02(){
        System.out.println("Demo04.test02()");
        return null;
    }

    public static void main(String[] args) {

        try {

            //获得指定方法参数泛型信息
            Method m = AnnotationReflect05.class.getMethod("test01", Map.class,List.class,int.class);
            Type[] t = m.getGenericParameterTypes();
            for (Type paramType : t) {
                System.out.println("#"+paramType);
                System.out.println(paramType instanceof ParameterizedType);
                if(paramType instanceof ParameterizedType){
                    Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for (Type genericType : genericTypes) {
                        System.out.println("泛型类型："+genericType);
                    }
                }
            }
            System.out.println("------------");
            //获得指定方法返回值泛型信息
            Method m2 = AnnotationReflect05.class.getMethod("test02");
            Type returnType = m2.getGenericReturnType();
            if(returnType instanceof ParameterizedType){
                Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();

                for (Type genericType : genericTypes) {
                    System.out.println("返回值，泛型类型："+genericType);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
