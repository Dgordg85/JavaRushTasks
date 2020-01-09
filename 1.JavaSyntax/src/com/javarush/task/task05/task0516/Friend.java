package com.javarush.task.task05.task0516;

/* 
Друзей не купишь
*/

public class Friend {
    private String name;
    private int age;
    private char sex;

    public Friend(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Friend(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Friend(String name){
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
