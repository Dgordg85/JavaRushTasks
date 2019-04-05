package com.javarush.task.task20.task2025;

import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;

        for (int i = 1; i < N; i++) {
            //if (i % 1000 == 0) System.out.println(i);

            int[] array = getNum(i);
            int count = array.length;
            int resultNum = 0;
            for (int j = 0; j < count; j++) {
                resultNum += Math.pow(array[j],count);
                if (resultNum > i) System.out.println("Шаг " + i + "");
            }
            System.out.println("Текущее число " + i + ", сумма его чисел равна " + resultNum);



        }

        return result;
    }

    private static int[] getNum(int num){
        String numStr = String.valueOf(num);
        int count = numStr.length();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(numStr.substring(i, i + 1));
        }
       return array;
    }


    public static void main(String[] args) {
        Date start = new Date();
        getNumbers(100);
        Date end = new Date();

        System.out.println((end.getTime() - start.getTime())/1000 + " сек");

    }

}
