package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream file1 = new FileOutputStream(reader.readLine(), true);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());

        fromFileToFile(file1, file2);
        fromFileToFile(file1, file3);

        file1.close();
        file2.close();
        file3.close();

    }

    private static void fromFileToFile(FileOutputStream out, FileInputStream in) throws IOException {
        int i;
        //out.write("\r\n".getBytes());
        while ((i = in.read()) != -1){
            out.write(i);
        }
    }
}
