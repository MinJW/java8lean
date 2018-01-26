package com.mjw.demo;

import com.mjw.App;
import com.mjw.bean.Apple;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Demo1 {

    @Test
    public void fun1(){

        List<Apple> apples = getApples();

        List<Apple> filte = filteApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                if (apple.getWidth() > 125) {
                    return true;
                }
                return false;
            }
        });

        System.out.print(filte);

    }

    @Test
    public void fun2(){

        List<Apple> apples = getApples();

        List<Apple> filte = filteApples(apples,(Apple a) -> a.getWidth() > 125  );

        System.out.print(filte);

    }

    @Test
    public void fun3(){
        Set<Apple> s = new TreeSet<Apple>(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWidth() - a2.getWidth();
            }
        });

        push2Set(s);

        System.out.print(s);
    }

    @Test
    public void fun4(){
        Set<Apple> s = new TreeSet<>((Apple a1,Apple a2) -> a1.getWidth() - a2.getWidth());

        push2Set(s);

        System.out.print(s);
    }

    @Test
    public void fun5(){
        List<Apple> apples = getApples();


        //匿名类
        /*Collections.sort(apples, new Comparator<Apple>(){
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWidth() - o2.getWidth();
            }
        });*/

        //lambda
        //Collections.sort(apples, (o1 ,o2) -> o1.getWidth() - o2.getWidth());

        //使用lambda表达式和类的静态方法
        //Collections.sort(apples,(a1,a2) -> Apple.appleCompare(a1,a2));

        //使用方法引用
        //引用的是类的静态方法
        //Collections.sort(apples,Apple::appleCompare);

        //使用方法引用
        //引用的是类的实例方法
        //Apple a = new Apple();
        //Collections.sort(apples,a::appleCompareAli);

        //类型的实例方法类似 静态方法调用 实例方法形式调用反而报错
       /* String[] arr = new String[]{"a","c","b"};
        Arrays.sort(arr,String::compareToIgnoreCase);
        //Arrays.sort(arr,new String()::compareToIgnoreCase);  Error
        log(arr);*/


        //引用构造方法
        //Set<Apple> arrs = transferElements(apples,() -> new HashSet<Apple>());
        //Set<Apple> arss = transferElements(apples,HashSet::new);

        say("a",() -> new Apple());
        say("a",Apple::new);

        //log(apples);


    }


    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceColletions, Supplier<DEST> colltionFactory) {
        DEST result = colltionFactory.get();
        for (T t : sourceColletions) {
            result.add(t);
        }
        return result;
    }

    public void say(String name,MyFactory mf){
        log(name + " eat " + mf.get());
    }


    public List<Apple> filteApples(List<Apple> list, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : list){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> getApples(){
        Apple a1 = new Apple("red",100);
        Apple a2 = new Apple("red",120);
        Apple a3 = new Apple("blue",134);
        Apple a4 = new Apple("yellow",122);
        Apple a5 = new Apple("black",126);
        List<Apple> list = new ArrayList<>();

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);

        return list;
    }

    public void push2Set(Set set){
        Apple a1 = new Apple("red",100);
        Apple a2 = new Apple("red",120);
        Apple a3 = new Apple("blue",134);
        Apple a4 = new Apple("yellow",122);
        Apple a5 = new Apple("black",126);

        set.add(a1);
        set.add(a2);
        set.add(a3);
        set.add(a4);
        set.add(a5);
    }


    public void log(Object o){
        if(o.getClass().isArray()){
            Object[] oArr = (Object[]) o;
            for (Object obj : oArr) {
                System.out.println(obj.toString());
            }
        }else{
            System.out.println(o.toString());
        }
    }
}
