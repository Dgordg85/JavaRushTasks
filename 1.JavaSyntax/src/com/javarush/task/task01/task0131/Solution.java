package com.javarush.task.task01.task0131;

/* 
Полнометражная картина
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getMetreFromCentimetre(299));
    }

    public static int getMetreFromCentimetre(int centimetre) {
        return centimetre / 100;
    }
}