package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        args = new String[]{"Мама", "Мыла", "Раму"};

        System.out.println(args[0] + args[1] + args[2]);
        System.out.println(args[0] + args[2] + args[1]);
        System.out.println(args[1] + args[0] + args[2]);
        System.out.println(args[1] + args[2] + args[0]);
        System.out.println(args[2] + args[1] + args[0]);
        System.out.println(args[2] + args[0] + args[1]);
    }
}
