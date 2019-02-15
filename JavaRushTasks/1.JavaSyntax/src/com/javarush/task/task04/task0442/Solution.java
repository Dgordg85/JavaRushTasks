package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int count = 0;
        int number = 0;
        while ( number != -1){
           Scanner sc = new Scanner(System.in);
           number = Integer.parseInt(sc.nextLine());
           count += number;
        }
        System.out.println(count);

    }
}
