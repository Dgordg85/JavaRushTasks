package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    private static int even, odd;
    public static void main(String[] args) throws Exception {
        int[] arr15 = new int[15];


        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 15; i++) {
            arr15[i] = Integer.parseInt(sc.nextLine());
            if (i % 2 == 0) even += arr15[i];
            else odd += arr15[i];
        }

        if (even > odd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
