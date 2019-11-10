package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int countNumbers = str.length();
        int number = Integer.parseInt(str);

        if (number >= 1 && number <= 999){
            if (number % 2 == 0) {
                str = "четное";
            } else str = "нечетное";

            switch (countNumbers) {
                case (3):
                    str += " трехзначное число";
                    break;
                case (2):
                    str += " двузначное число";
                    break;
                case (1):
                    str += " однозначное число";
                    break;
            }
            System.out.println(str);
        }






    }
}
