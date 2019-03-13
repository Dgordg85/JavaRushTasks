package com.javarush.task.task18.task1826;

/* 
Шифровка
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        crypt(args[0], args[1], args[2]);
    }


    private static void crypt(String key, String fileName, String fileOutputName) throws IOException {
        BufferedInputStream streamIn = new BufferedInputStream(new FileInputStream(fileName), 6400);
        BufferedOutputStream streamOut = new BufferedOutputStream(new FileOutputStream(fileOutputName), 6400);

        int i;
        int count = 1;
        while ((i = streamIn.read()) != -1) {
            if (key.equals("-e")){
                i -= count;
            } else if (key.equals("-d")){
                i += count;
            } else {
                break;
            }
            streamOut.write(i);
            if (count > 15) count = 1;
            else count++;
        }
        streamIn.close();
        streamOut.close();
    }

}
