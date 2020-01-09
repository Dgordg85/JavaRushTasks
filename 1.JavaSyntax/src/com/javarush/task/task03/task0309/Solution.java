package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        byte summa = 0;
        for (byte i = 1; i <= 5; i++){
            summa += i;
            System.out.println(summa);
        }
    }
}
