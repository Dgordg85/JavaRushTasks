package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long[][] degreeTable = new long[10][20];
    private static long LONG_N = 1;

    static {
      //  long start  = System.currentTimeMillis();

        for (int j = 0; j < degreeTable[0].length; j++) {
            degreeTable[0][j] = 0;
        }

        for (int j = 0; j < degreeTable[0].length; j++) {
            degreeTable[1][j] = 1;
        }

        for (int i = 2; i < degreeTable.length; i++) {
            for (int j = 1; j < degreeTable[0].length; j++) {
                degreeTable[i][j] = i;
                for (int k = 1; k < j; k++) {
                    degreeTable[i][j] *= i;
                }
            }
        }
       // long end = System.currentTimeMillis() - start;
       // SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
       // System.out.println("Время создания массива: " + pattern.format(new Date(end)));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNumbers(1000)));
        System.out.println(Arrays.toString(getNumbers(100)));

       /* long start  = System.currentTimeMillis();
        long[] result = getNumbers(LONG_N);
        long end = System.currentTimeMillis() - start;
        SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
        System.out.println("Время обработки чисел: " + pattern.format(new Date(end)));

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }*/
    }

    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();
        if (N > 0){
            long currentNumber = 1;
            long sumCurrentNumber;
            while (currentNumber < N && currentNumber != -1){
                //System.out.println("curN=" + currentNumber);
                int currentNumberSize = String.valueOf(currentNumber).length();
                int endNumberSize = String.valueOf(N).length();
                for (int i = currentNumberSize; i <= endNumberSize; i++) {
                    sumCurrentNumber = getNumberSum(currentNumber, i, false);
                    if (sumCurrentNumber < currentNumber) continue;

                    if (isArmstrong(sumCurrentNumber) && sumCurrentNumber < N){
                        if (!list.contains(sumCurrentNumber)) list.add(sumCurrentNumber);
                        //System.out.println(sumCurrentNumber + " " + currentNumber + " " + i);
                    }
                }
                currentNumber = getNextNumber(currentNumber);
            }
        }
        long[] result = new long[list.size()];
        Collections.sort(list);

       // long[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
       /* for (int i = 0; i < result.length; i++) {
            if (result[i] != temp[i]) System.out.println(result[i] + " не равно" + temp[i]);
            else System.out.println("Равно");
        }*/
        return result;
    }

    private static long getNextNumber(long currentNumber){
        if (currentNumber % 10 == 9){
            currentNumber++;
            int countZero = 0;
            long index;
            while ((index = currentNumber % 10) == 0) {
                countZero++;
                currentNumber /= 10;
            }
            StringBuffer sbNumber = new StringBuffer(Long.toString(currentNumber));
            for (int i = 0; i < countZero; i++) sbNumber.append(index);
            try {
                currentNumber = Long.valueOf(sbNumber.toString());
            } catch (NumberFormatException e){
                currentNumber = Long.MAX_VALUE;
            }

        } else{
            currentNumber++;
        }

        if (currentNumber == Long.MAX_VALUE) return -1;
        return currentNumber;
    }

    private static boolean isArmstrong(long number){
        long num = getNumberSum(number, String.valueOf(number).length(), true);
        if (num == number){
            return true;
        }
        return false;
    }

    private static long getNumberSum(long number, int degree, boolean checkResult){
        long result = 0;
        long defaultNumber = number;
        int index;

        while (number > 0) {
            index = (int) (number % 10);
            result += degreeTable[index][degree];
            if (checkResult && result > defaultNumber) return -1;
            number /= 10;
        }
        return result;
    }
}
