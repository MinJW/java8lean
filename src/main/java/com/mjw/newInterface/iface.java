package com.mjw.newInterface;

@FunctionalInterface
public interface iface {

    void fun();

    default String say(){
        return "iface";
    }

    static int getNumber(){
        return 1;
    }
}


