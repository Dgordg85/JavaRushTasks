package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        int[] array = new int[20];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i: array) {
           if (i > maximum) maximum = i;
           if (i < minimum) minimum = i;
        }

        System.out.print(maximum + " " + minimum);
    }
}
