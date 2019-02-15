package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arrInt = new int[10];

        Scanner sc = new Scanner(System.in);

        for (int i = 9; i >= 0 ; i--) {
            arrInt[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arrInt[i]);
        }
    }
}

