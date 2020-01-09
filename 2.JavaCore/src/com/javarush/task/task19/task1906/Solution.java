package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader readFile = new FileReader(reader.readLine());
        FileWriter writFile = new FileWriter(reader.readLine());

        int i = 0;
        while(readFile.ready()){
            int symbol = readFile.read();
            if (i++ % 2 != 0){
                writFile.write(symbol);
            }
        }

        reader.close();
        writFile.close();
        readFile.close();
    }
}
