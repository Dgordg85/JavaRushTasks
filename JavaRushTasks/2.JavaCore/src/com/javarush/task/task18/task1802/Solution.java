package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileInputStream file = new FileInputStream(sc.nextLine());

        int min = 256;
        int currentByte;
        while (file.available() > 0){
            if ((currentByte = file.read()) < min) min = currentByte;
        }
        System.out.println(min);
        file.close();
    }
}
