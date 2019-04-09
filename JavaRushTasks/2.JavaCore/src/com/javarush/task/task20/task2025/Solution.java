package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long LONG_N = 1000;
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

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) System.out.println(result[i]);
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = new long[100];
        int j = 0;

        long currentNumber = 1;
        long sumCurrentNumber;
        while (currentNumber <= N){
            if (isArmstrong(sumCurrentNumber = getNumberSum(currentNumber))){
                boolean isNumberInArray = false;
                for (int k = 0; k < result.length; k++) {
                    if (result[k] == sumCurrentNumber){
                        isNumberInArray = true;
                        break;
                    }
                }
                if (!isNumberInArray) result[j++] = sumCurrentNumber;
            }
            currentNumber = getNextNumber(currentNumber);
        }
        Arrays.sort(result);
        return result;
    }

    private static long getNextNumber(long currentNumber){
        if (currentNumber++ % 10 == 9){
            long index = currentNumber % 10;
            int countZero = 0;

            while (index == 0) {
                currentNumber /= 10;
                index = currentNumber % 10;
                countZero++;
            }

            StringBuffer sbNumber = new StringBuffer(Long.toString(currentNumber));

            for (int i = 0; i < countZero; i++)
                sbNumber.append(index);

            try {
                return Long.parseLong(sbNumber.toString());
            } catch (NumberFormatException e) {
                return Long.MAX_VALUE;
            }

        } else {
            while (true){
                if (!isValid(currentNumber)){
                    currentNumber++;
                } else {
                    return currentNumber;
                }
            }
        }
    }

    private static boolean isValid(long number){
        int index = (int)(number % 10);
        int previousIndex = 10;

        while(number > 0){
            if (index != 0) {
                if (index > previousIndex) return false;
                index = (int) (number % 10);
            }
            number /= 10;
        }
        return true;
    }

    private static boolean isArmstrong(long number){
        long num = getNumberSum(number);
        if (num == number && num != -1){
            return true;
        }
        return false;
    }

    private static long getNumberSum(long number){
        long result = 0;
        int countDegree = String.valueOf(number).length();

        int index;

        while (number > 0) {
            index = (int) (number % 10);
            result += degree[index][countDegree];
            number /= 10;
        }
        return result;
    }
}
