package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        for (byte i = 1; i <= 10; i++) {
            for (byte j = 1; j <= 10; j++){
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}
