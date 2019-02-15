package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int firstNumber = Integer.parseInt(sc.nextLine());
        int secondNumber = Integer.parseInt(sc.nextLine());

        if (firstNumber > secondNumber){
            System.out.println(secondNumber);
        } else {
            System.out.println(firstNumber);
        }
    }
}