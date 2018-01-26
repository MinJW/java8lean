package com.mjw.newInterface;

import org.junit.Test;

public class DemoTest {

    @Test
    public void fun(){
        iface impl1 = new FaceImpl1();
        iface impl2 = new FaceImpl2();

        impl1.fun();
        impl2.fun();

        log("=========================");

        log(impl1.say());
        log(impl2.say());

        log("=========================");

        log(iface.getNumber());
        log(FaceImpl1.getNumber());

    }




    public void log(Object o){
        System.out.println(o.toString());
    }
}
