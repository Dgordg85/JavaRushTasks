package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    private static int COUNT_BUFFER = 4;
    private static int DEGREE_ARRAY_SIZE = (int) Math.pow(10, COUNT_BUFFER);
    private static int LONG_N = 100000;
    private static long[][] degree = new long[DEGREE_ARRAY_SIZE][20];

    static {
        long start  = System.currentTimeMillis();

        for (int j = 0; j < degree[0].length; j++) {
            degree[0][j] = 0;
        }

        for (int j = 0; j < degree[0].length; j++) {
            degree[1][j] = 1;
        }

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < degree[0].length; j++) {
                degree[i][j] = i;
                for (int k = 1; k < j; k++) {
                    degree[i][j] *= i;
                }
            }
        }

        for (int i = 10; i < DEGREE_ARRAY_SIZE; i++) {
            for (int j = 1; j < degree[0].length; j++) {
                int result = 0;
                int num = i;

                while (num > 0){
                    result += degree[num % 10][j];
                    num /= 10;
                }
                degree[i][j] = result;
            }
        }

        long end = System.currentTimeMillis() - start;
        SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
        System.out.println("Время создания массива: " + pattern.format(new Date(end)));
    }

    public static void main(String[] args) {
        long start  = System.currentTimeMillis();
        long[] result = getNumbers(LONG_N);
        long end = System.currentTimeMillis() - start;
        SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
        System.out.println("Время обработки чисел: " + pattern.format(new Date(end)));

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) System.out.println(result[i]);
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = new long[100];
        int j = 0;
        for (long i = 0; i < N; i++) {
            System.out.println(i);
            if (isArmstrong(i)){
                result[j++] = i;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private static boolean isArmstrong(long number){
        if (getNumberSum(number) == number){
            return true;
        }
        return false;
    }

    private static long getNumberSum(long number){
        int numSize = String.valueOf(number).length();
        long result = 0;
        int count = 0;
        long currentIndex = 0;
        while(number > 0){
            int index = (int)number % 10;
            if (count == 0) currentIndex = index;
            else currentIndex += index * Math.pow(10, count);
            number /= 10;
            count++;
            if (number == 0 || count == COUNT_BUFFER){
                result += degree[(int)currentIndex][numSize];
                currentIndex = 0;
                count = 0;
            }
        }
        return result;
    }
}
