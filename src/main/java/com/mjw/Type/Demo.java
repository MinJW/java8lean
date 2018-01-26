package com.mjw.Type;

import org.junit.Test;
import sun.plugin2.util.ParameterNames;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Demo {
    @Test
    public void fun(){
        final Value<String> value = new Value<>();

        value.getOrDefault("aaaa",Value.defaultValue());//不报错 自动推导为String
    }

    @Test
    public void fun2(){
        Value<Integer> value = new Value<>();
        value.getOrDefault(111,Value.defaultValue());// 自动推导为Integer
    }


    public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod( "main", String[].class );
        for( final Parameter parameter: method.getParameters() ) {
            System.out.println( "Parameter: " + parameter.getName() );
        }
    }
}
