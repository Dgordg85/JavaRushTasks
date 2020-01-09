package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        for (int i = 1; i <= 10 ; i++) {
            System.out.println(name + " любит меня.");
        }

    }
}
