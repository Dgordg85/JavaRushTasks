package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top, left, height, width;

    public Rectangle(int top, int left, int height, int width) {
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
        this.height = 0;
        this.width = 0;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }

    public Rectangle(Rectangle rect){
        this.top = rect.top;
        this.left = rect.left;
        this.height = rect.height;
        this.width = rect.width;
    }

    public static void main(String[] args) {

    }
}
