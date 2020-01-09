package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        if (age < 18) System.out.println("Подрасти еще");
    }
}
