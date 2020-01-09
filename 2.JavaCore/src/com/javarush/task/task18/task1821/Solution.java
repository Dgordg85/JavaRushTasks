package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        BufferedInputStream reader = new BufferedInputStream(stream);

        int[] buffer = new int[256];
        int i;

        while ((i = reader.read()) != -1){
            buffer[i]++;
        }

        for (int j = 0; j < buffer.length; j++) {
            if (buffer[j] != 0){
                System.out.println((char) j + " " + buffer[j]);
            }
        }

        reader.close();
    }
}
