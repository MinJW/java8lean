package com.mjw.newInterface;

public class FaceImpl1 implements iface{
    @Override
    public void fun() {
        System.out.println("faceImpl 1");
    }

    @Override
    public String say() {
        return "impl 1";
    }

    static int getNumber(){
        return 2;
    }



}
