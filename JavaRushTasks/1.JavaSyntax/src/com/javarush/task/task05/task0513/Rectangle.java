package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    private int top, left, width, height;

    public static void main(String[] args) {

    }

    public void initialize(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top, int left){
        this.top = top;
        this.left = left;
        this.width = 0;
        this.height = 0;
    }

    public void initialize(int top, int left, int height){
        this.top = top;
        this.left = left;
        this.width = height;
        this.height = height;
    }

    public void initialize(Rectangle reg){
        this.top = reg.top;
        this.left = reg.left;
        this.width = reg.height;
        this.height = reg.height;
    }
}
