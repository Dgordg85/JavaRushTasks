package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader stream = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        String str;
        StringBuilder s = new StringBuilder();
        while((str = stream.readLine()) != null){
            System.out.println(s.append(str).reverse());
            s.delete(0, s.length());
        }
        stream.close();
    }
}
