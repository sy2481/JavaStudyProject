package com.sunzhouyu.annotation;

import javax.annotation.Resource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sunyi
 * @create 2018/12/27
 */

@Target(value = {ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnnotationTest {
    String name() default "";

    int age() default -1;

    String[] school() default {};

    String version() default "1.0";
}
