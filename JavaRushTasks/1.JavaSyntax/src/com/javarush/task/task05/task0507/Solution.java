package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int summa = 0;
        int count = 0;
        int number = 0;
        while (true){
            number = Integer.parseInt(reader.readLine());
            count++;
            if (number == -1){
                if (count == 0) count = 1;
                System.out.println((float)summa/count);
                break;
            }
            summa += number;
        }
    }
}
