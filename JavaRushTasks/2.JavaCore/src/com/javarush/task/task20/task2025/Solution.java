package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long LONG_N = 100000000L;
    private static long[][] degree = new long[10][20];

    static {
        long start  = System.currentTimeMillis();

        for (int j = 0; j < degree[0].length; j++) {
            degree[0][j] = 0;
        }

        for (int j = 0; j < degree[0].length; j++) {
            degree[1][j] = 1;
        }

        for (int i = 2; i < degree.length; i++) {
            for (int j = 1; j < degree[0].length; j++) {
                degree[i][j] = i;
                for (int k = 1; k < j; k++) {
                    degree[i][j] *= i;
                }
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

       /* for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) System.out.println(result[i]);
        }*/
    }

    public static long[] getNumbers(long N) {
        long[] result = new long[100];
        int j = 0;
        for (long i = 0L; i < N; i++) {
            long num = getNumberSum(i, true);
            if (num != -1 && num >= i){
                if (isArmstrong(num)){
                    boolean isNumberinArray = false;
                    for (int k = 0; k < result.length; k++) {
                        if (result[k] == num){
                            isNumberinArray = true;
                            break;
                        }
                    }
                    if (!isNumberinArray) result[j++] = num;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }

    private static boolean isArmstrong(long number){
        if (getNumberSum(number, false) == number){
            return true;
        }
        return false;
    }

    private static long getNumberSum(long number, boolean unique){
        long result = 0;
        int countDegree = String.valueOf(number).length();

        int index;
        int previousIndex = 10;
        while (number > 0) {
            index = (int) (number % 10);
            if (index == 0) {
                number /= 10;
                continue;
            }

            if (previousIndex >= index || !unique) {
                result += degree[index][countDegree];
                if (result > number) return -1; // +0.620
                number /= 10;
                previousIndex = index;
            } else {
                return -1;
            }

        }
        return result;
    }
}
