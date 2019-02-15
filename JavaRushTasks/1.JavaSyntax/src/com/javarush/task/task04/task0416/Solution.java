package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        float t = Float.parseFloat(sc.nextLine()) % 5;

        if (t < 3) System.out.println("зеленый");
            else if (t < 4) System.out.println("желтый");
                else if (t < 5) System.out.println("красный");
    }
}