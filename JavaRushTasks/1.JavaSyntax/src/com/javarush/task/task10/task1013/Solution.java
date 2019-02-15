package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private int weight;
        private String name;
        private String address;
        private Human friend;
        private String telephone;


        public Human(int age) {
            this.age = age;
        }

        public Human(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human(Human friend) {
            this.friend = friend;
        }

        public Human(int age, String name, String telephone) {
            this.age = age;
            this.name = name;
            this.telephone = telephone;
        }

        public Human(int age, int weight, String name, String address, String telephone) {
            this.age = age;
            this.weight = weight;
            this.name = name;
            this.address = address;
            this.telephone = telephone;
        }

        public Human(int age, int weight, String name, String address, Human friend, String telephone) {
            this.age = age;
            this.weight = weight;
            this.name = name;
            this.address = address;
            this.friend = friend;
            this.telephone = telephone;
        }

        public Human(Human friend, String telephone) {
            this.friend = friend;
            this.telephone = telephone;
        }

        public Human(int age, Human friend, String telephone) {
            this.age = age;
            this.friend = friend;
            this.telephone = telephone;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(int age, int weight, Human friend, String telephone) {
            this.age = age;
            this.weight = weight;
            this.friend = friend;
            this.telephone = telephone;
        }
    }
}
