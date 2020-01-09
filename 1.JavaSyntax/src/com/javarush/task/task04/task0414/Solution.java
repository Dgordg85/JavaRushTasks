package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int year = Integer.parseInt(sc.nextLine());
        boolean leapYear;

        if(year % 400 == 0) {
            leapYear = true;
        } else {
            if (year % 100 == 0) {
                leapYear = false;
            } else {
                if (year % 4 == 0){
                    leapYear = true;
                } else {
                    leapYear = false;
                }
            }
        }

        if (leapYear){
            System.out.println("количество дней в году: 366");
        } else {
            System.out.println("количество дней в году: 365");
        }
    }
}