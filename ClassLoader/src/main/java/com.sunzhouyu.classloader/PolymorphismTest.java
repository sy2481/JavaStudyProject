package com.sunzhouyu.classloader;

/**
 * @author sunyi
 * @create 2019/1/1
 */
//class Father{
//    public void func1(){
//        func2();
//    }
//    //这是父类中的func2()方法，因为下面的子类中重写了该方法
//    //所以在父类类型的引用中调用时，这个方法将不再有效
//    //取而代之的是将调用子类中重写的func2()方法
//    public void func2(){
//        System.out.println("AAA");
//    }
//    public void func1(int i){
//        System.out.println("EEE");
//    }
//}
//class Child extends Father{
//    //func1(int i)是对func1()方法的一个重载，主要不是重写！
//    //由于在父类中没有定义这个方法，所以它不能被父类类型的引用调用
//    //所以在下面的main方法中child.func1(68)是不对的
//    public void func1(int i){
//        System.out.println("BBB");
//    }
//
////    public void func1(){
////        System.out.println("FFF");
////    }
//    //func2()重写了父类Father中的func2()方法
//    //如果父类类型的引用中调用了func2()方法，那么必然是子类中重写的这个方法
////    public void func2(){
////        System.out.println("CCC");
////    }
//}

class Father {
    public void func1() {
        func2();
    }

    //这是父类中的func2()方法，因为下面的子类中重写了该方法
    //所以在父类类型的引用中调用时，这个方法将不再有效
    //取而代之的是将调用子类中重写的func2()方法
    public void func2() {
        System.out.println("AAA");
    }

    public void func1(int i) {
        System.out.println("DDD");
    }
}

class Child extends Father {
    //func1(int i)是对func1()方法的一个重载
    //由于在父类中没有定义这个方法，所以它不能被父类类型的引用调用
    //所以在下面的main方法中child.func1(68)是不对的
//    public void func1(int i){
//        System.out.println("BBB");
//    }
    //func2()重写了父类Father中的func2()方法
    //如果父类类型的引用中调用了func2()方法，那么必然是子类中重写的这个方法
//    public void func2(){
//        System.out.println("CCC");
//    }
}

public class PolymorphismTest {
    public static void main(String[] args) {
        Father child = new Child();
        //child.func1();//打印结果将会是什么？
        //child.func1(68);
        child.func2();
    }
}