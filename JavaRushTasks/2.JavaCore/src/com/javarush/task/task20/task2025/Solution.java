package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long[][] degree = new long[10][20];

    static {
        for (int i = 0; i < degree.length; i++) {
            degree[0][i] = 0;
        }
        
        for (int i = 0; i < degree.length; i++) {
            degree[1][i] = 1;
        }

        for (int i = 2; i < degree.length; i++) {
            for (int j = 1; j < degree[0].length; j++) {
                degree[i][j] = i;
                for (int k = 1; k < j; k++) {
                    degree[i][j] *= i;
                }
            }
        }
    }


    public static long[] getNumbers(long N) {
        long[] result = new long[100];
        int j = 0;
        for (long i = 0; i < N; i++) {
            if (isNumUnique(i)){
                if (isArmstrong(i)){
                    result[j++] = i;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        long start  = System.currentTimeMillis();
        long[] result = getNumbers(99999999);
        long end = System.currentTimeMillis() - start;
        SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
        System.out.println("Время: " + pattern.format(new Date(end)));

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) System.out.println(result[i]);
        }
    }

    private static boolean isArmstrong(long number){
        long sum = getNumberSum(number);
        if (sum == number){
            return true;
        }
        return false;
    }

    private static long getNumberSum(long number){
        long result = 0;
        int count = String.valueOf(number).length();
        while(number > 0){
            result += degree[(int)(number % 10)][count];
            number /= 10;
        }
        return result;
    }

    private static boolean isNumUnique(long num){
        String str = String.valueOf(num);
        int count = str.length();
        if (count > 1){
            for (int i = 1; i < count; i++) {
                int firstSymbol = Integer.parseInt(str.substring(i - 1, i));
                int secondSymbol = Integer.parseInt(str.substring(i, i + 1));
                if (firstSymbol > secondSymbol) return false;
            }
        }
        return true;
    }
}
