package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;

        for (int i = 0; i < N; i++) {
            //if (i % 1000 == 0) System.out.println(i);
            if (isUnique(i)){
                int num = sum(i);
                if (isArmstrongNumber(num, i)) System.out.println(num + " " + i);
            }
        }
        return result;
    }

    private static boolean isArmstrongNumber(int number, int currentIter) {
        if (sum(number) == number && number >= currentIter) {
            return true;
        }

        return false;
    }

    private static int[] getNumToArray(int num){
        String numStr = String.valueOf(num);
        int count = numStr.length();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = num % 10;
            num /= 10;
        }
       return array;
    }

    private static boolean isUnique(int num){
        int lastNum = 9;
        int currentNum;
        while (num > 0){
            currentNum = num % 10;
            if (currentNum != 0){
                if (currentNum > lastNum) return false;
                lastNum = currentNum;
            }
            num /= 10;
        }
        return true;
    }

    private static int sum(int num){
        int resultNum = 0;
        int[] array = getNumToArray(num);
        int count = array.length;
        for (int j = 0; j < count; j++) {
            resultNum += Math.pow(array[j],count);
        }
        return resultNum;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getNumbers(999999);
        long end = System.currentTimeMillis() - start;

        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
        System.out.println("Время: " + pattern.format(new Date(end)));
        System.out.println("Memory = " + memory / 1048576);
    }

}
