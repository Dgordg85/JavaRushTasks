package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();

        FileInputStream file1 = new FileInputStream(sc.nextLine());
        FileOutputStream file2 = new FileOutputStream(sc.nextLine(), true);

        int i;
        while(true){
            i = file1.read();
            if (i == ' ' || i == -1){
                file2.write(("" + Math.round(Float.parseFloat(str.toString())) + " ").getBytes());
                if (i == -1) break;
                str.setLength(0);
            } else {
                str.append((char) i);
            }

        }

        file1.close();
        file2.close();
    }
}
