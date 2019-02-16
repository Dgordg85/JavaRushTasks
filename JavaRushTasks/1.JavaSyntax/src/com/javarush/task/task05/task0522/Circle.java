package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double x, double radius){
        this.x = x;
        this.y = radius;
        this.radius = radius;
    }

    public Circle(double radius){
        this.x = 15;
        this.y = 15;
        this.radius = radius;
    }

    public Circle(){
        this.x = 15;
        this.y = 15;
        this.radius = 10;
    }

    public static void main(String[] args) {

    }
}