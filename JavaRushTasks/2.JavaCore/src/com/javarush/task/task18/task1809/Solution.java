package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        FileInputStream fileOne = new FileInputStream(sc.nextLine());
        FileOutputStream fileTwo = new FileOutputStream(sc.nextLine());

        byte[] buffer = new byte[fileOne.available()];

        fileOne.read(buffer);

        for (int i = 0; i < buffer.length / 2; i++) {
            byte temp = buffer[i];
            buffer[i] = buffer[buffer.length - 1 - i];
            buffer[buffer.length - 1 - i] = temp;
        }

        fileTwo.write(buffer);

        fileOne.close();
        fileTwo.close();
    }
}
