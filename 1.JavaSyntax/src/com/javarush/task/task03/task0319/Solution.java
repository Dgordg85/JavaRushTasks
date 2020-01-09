package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String name = reader.readLine();

        String firstNumber = reader.readLine();
        int money = Integer.parseInt(firstNumber);

        String secondNumber = reader.readLine();
        int age = Integer.parseInt(secondNumber);

        System.out.println(name + " получает " + money + " через " + age + " лет.");
    }
}
