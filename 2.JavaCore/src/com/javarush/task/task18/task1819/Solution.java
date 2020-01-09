package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String file1Name = sc.nextLine();

        FileInputStream file1In = new FileInputStream(file1Name);
        byte[] buffer = new byte[file1In.available()];
        file1In.read(buffer, 0, file1In.available());
        file1In.close();

        FileOutputStream file1Out = new FileOutputStream(file1Name);
        FileInputStream file2 = new FileInputStream(sc.nextLine());

        int i;
        while ((i = file2.read()) != -1){
            file1Out.write(i);
        }

        file1Out.write(buffer);
        file1Out.close();
        file2.close();
    }
}
