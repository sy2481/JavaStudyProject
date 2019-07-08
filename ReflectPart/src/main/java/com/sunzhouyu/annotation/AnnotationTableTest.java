package com.sunzhouyu.annotation;

/**
 * @author sunyi
 * @create 2018/12/28
 */
@AnnotationTable(tableName = "test")
public class AnnotationTableTest {
    @AnnotationFiled(name = "id", type = "int", length = 10)
    private String id;

    @AnnotationFiled(name = "name", type = "varchar", length = 10)
    private String name;

    @AnnotationFiled(name = "age", type = "int", length = 3)
    private int age;

    private String a;

    private int b;

    public AnnotationTableTest(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public AnnotationTableTest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
