package com.mjw.bean;

import com.mjw.App;
import com.mjw.demo.MyFactory;

import java.util.ArrayList;
import java.util.List;

public class Apple{

    private String color;
    private int width;

    public Apple() {
    }

    public Apple(String color, int width) {
        this.color = color;
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static int appleCompare(Apple a1, Apple a2){
        return a1.getWidth() - a2.getWidth();
    }

    public int appleCompareAli(Apple a1, Apple a2){
        return a1.getWidth() - a2.getWidth();
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", width=" + width +
                '}';
    }


}
