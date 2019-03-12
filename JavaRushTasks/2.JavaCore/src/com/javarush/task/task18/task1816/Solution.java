package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        BufferedInputStream reader = new BufferedInputStream(stream);
        int i;
        int countChar = 0;
        while ((i = reader.read()) != -1){
            if (i > 64 && i < 91 || i > 96 && i < 123) countChar++;
        }
        System.out.println(countChar);
        reader.close();
        stream.close();
    }
}
