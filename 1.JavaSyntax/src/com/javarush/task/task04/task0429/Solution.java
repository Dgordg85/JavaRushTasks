package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import javax.annotation.PostConstruct;
import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int positiveNumber = 0;
        int negativeNumber = 0;
        int currentNumber;

        for (int i = 1; i <= 3 ; i++) {
            currentNumber = Integer.parseInt(sc.nextLine());
            if (currentNumber > 0) positiveNumber++;
            else if (currentNumber < 0)negativeNumber++;
        }
        System.out.println("количество отрицательных чисел: " + negativeNumber);
        System.out.println("количество положительных чисел: " + positiveNumber);
    }
}
