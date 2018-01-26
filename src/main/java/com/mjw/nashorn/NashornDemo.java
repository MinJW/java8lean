package com.mjw.nashorn;

import com.mjw.bean.Apple;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NashornDemo {

    @Test
    public void fun() throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("E:\\git_temp\\java8lean\\src\\main\\java\\script.js"));

        Invocable invocable = (Invocable) engine;

        Object result = invocable.invokeFunction("fun1", "haha");
        System.out.println(result);

        invocable.invokeFunction("fun2", new Apple("red",12));
    }

    static String fun1(String name) {
        System.out.format("java run ... , %s", name);
        return "i'm java";
    }

}
