package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] strArr = new String[10];
        int[] intArr = new int[10];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            strArr[i] = sc.nextLine();
            intArr[i] = strArr[i].length();
        }

        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }


    }
}
