package com.sunzhouyu.annotation;

import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author sunyi
 * @create 2018/12/29
 */
public class JarURLConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("jar:file:/Users/sun_of_rain/Desktop/junit-4.5.jar!/");
            java.net.JarURLConnection jarConnection = (java.net.JarURLConnection) url.openConnection();
            JarFile jarFile = jarConnection.getJarFile();
            System.out.println(jarFile);
            if (jarFile != null) {
                //得到该jar文件下面的类实体
                Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                while (jarEntryEnumeration.hasMoreElements()) {
                    JarEntry entry = jarEntryEnumeration.nextElement();
                    String jarEntryName = entry.getName();
                    System.out.println(jarEntryName);
                    //这里我们需要过滤不是class文件和不在basePack包名下的类
                    if (jarEntryName.contains(".class") && jarEntryName.replaceAll("/", ".").startsWith("org.junit.")) {
                        String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replace("/", ".");
                        System.out.println(className + "++++++++++++");
                    }

                }
            }
        } catch (Exception e) {
        }
    }
}
