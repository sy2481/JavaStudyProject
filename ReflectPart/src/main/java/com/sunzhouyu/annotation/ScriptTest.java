package com.sunzhouyu.annotation;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * @author sunyi
 * @create 2018/12/29
 */
public class ScriptTest {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager scriptEngineManager=new ScriptEngineManager();
        ScriptEngine engine=scriptEngineManager.getEngineByName("javascript");
        engine.put("a","is a");
        String str="print(a);";
        engine.eval(str);
         engine.eval("function add(a,b){var sum=a+b;return sum;}");
        Invocable invocable=(Invocable) engine;
        Object result=invocable.invokeFunction("add",new Integer[]{1,2});
        System.out.println(result);

        //String jsCode="importPackage(java.util); var list=Arrays.asList([\"a\",\"b\"])";
        String jsCode=" var list=java.util.Arrays.asList([\"a\",\"b\"])";

        engine.eval(jsCode);
       List<String>  list= (List<String>)engine.get("list");
       for(String a:list ){
           System.out.println(a);
       }
    }
}
