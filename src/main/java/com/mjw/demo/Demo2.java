package com.mjw.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo2 {
    int count = 0;
    @Test
    public void fun1(){
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(9);


        list.sort(( i1, i2) ->{
            int i = i1 - i2;
            return i;
        });

        //list.sort((i1, i2) -> i1 - i2);
        log(list);
    }









    public void log(Object o){
        System.out.println(o.toString());
    }
}
