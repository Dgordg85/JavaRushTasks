package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name, address, color;
    int age, weight;

    public Cat(String name){
        this.name = name;
        this.color = "Неизвестный";
        this.age = 5;
        this.weight = 3;
    }

    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Неизвестный";
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 5;
    }

    public Cat(int weight, String color){
        this.color = color;
        this.age = 5;
        this.weight = weight;
    }

    public Cat(int weight, String color, String address){
        this.address = address;
        this.color = color;
        this.age = 5;
        this.weight = weight;
    }

    public static void main(String[] args) {

    }
}
