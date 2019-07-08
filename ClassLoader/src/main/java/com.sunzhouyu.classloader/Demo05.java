package com.sunzhouyu.classloader;

/**
 * @author sunyi
 * @create 2019/1/2
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = Demo05.class.getClassLoader();
        System.out.println(loader);


        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader2);

        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("/Users/sun_of_rain/Desktop/myjava"));
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class<Demo01> c = (Class<Demo01>) Thread.currentThread().getContextClassLoader().loadClass("com.bjsxt.bean.Emp");
        System.out.println(c);
        System.out.println(c.getClassLoader());

        Class d1 =Class.forName("com.sunzhouyu.classloader.Demo");

        Class<Demo> d = (Class<Demo>) Thread.currentThread().getContextClassLoader().loadClass("com.sunzhouyu.classloader.Demo");
        System.out.println(d);
        Demo de=d.newInstance();
        de.print();
        System.out.println(d.getClassLoader());


    }
}
