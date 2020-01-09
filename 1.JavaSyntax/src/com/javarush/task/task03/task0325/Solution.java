package com.javarush.task.task03.task0325;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int rate = Integer.parseInt(sc.nextLine());
            System.out.println("Я буду зарабатывать $" + rate + " в час");
        } else {
            System.out.println("Вы ввели чушь");
        }
    }
}