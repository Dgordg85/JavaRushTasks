package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int mid; // Среднее
        int countRight = 0;
        int countFails = 0;
        int countDown = 0;
        for (int a = -100; a < 100; a++) {
            for (int b = -100; b < 100; b++) {
                for (int c = -100; c < 100; c++) {
                    if (a == b || a == c) mid = a;
                    else if (b == c) mid = b;
                    else if ((b - a) * (b - c) < 0) mid = b;
                    else if ((c - a) * (c - b) < 0) mid = c;
                    else mid = a;

                    int max = Math.max(c, Math.max(a,b));
                    int min = Math.min(c, Math.min(a,b));
                    int summa = a + b + c - min - max;

                    if (mid == summa) {
                        countRight++;
                    } else countFails++;

                }
            }
        }
        System.out.println(countRight + " : " + countFails);
    }

    public static int max(int a, int b){
        if(a > b) return a;
        else return b;
    }

    public static int min(int a, int b){
        if(a < b) return a;
        else return b;
    }
}
