package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    String name;
    int age;
    String address;

    public String toString() {
        return name + " " + age + " " + address;
    }

    public static void main(String[] args) {
        Man man1 = new Man("Артем", 5, "adr1");
        Man man2 = new Man("Дрон", 7,"adr2");
        Woman woman1 = new Woman("Кейт", 8,"adr3");
        Woman woman2 = new Woman("Жанна", 10, "adr5");
    }


    public static class Man extends Solution {

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
            System.out.println(this);
        }
    }

    public static class Woman extends Solution {

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
            System.out.println(this);
        }
    }
}
