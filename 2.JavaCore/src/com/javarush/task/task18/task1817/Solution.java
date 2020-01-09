package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        BufferedInputStream reader = new BufferedInputStream(stream, 6400);
        int i;
        int countSpaces = 0;
        int allSymbols = reader.available();

        while ((i = reader.read()) != -1){
            if (i == ' ') countSpaces++;
        }

        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println(f.format(countSpaces / (allSymbols * 1.0f) * 100));

        stream.close();
        reader.close();
    }
}
