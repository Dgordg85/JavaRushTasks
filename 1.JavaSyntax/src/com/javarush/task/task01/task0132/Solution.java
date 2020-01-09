package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(54611));
    }

    public static int sumDigitsInNumber(int number) {
        int summa = 0;
        for (int i = 1000000; i >= 10; i = i / 10) {
            int summNumber = number / i;
            summa += summNumber;
            number -= (summNumber * i);
            if (i == 10) {
                summa += number;
            }
        }
        return summa;
    }
}