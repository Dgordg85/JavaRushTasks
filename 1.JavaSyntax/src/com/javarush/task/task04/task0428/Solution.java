package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    private static byte count;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 3; i++) {
            if (Integer.parseInt(reader.readLine()) > 0) ++count;
        }

        System.out.println(count);
    }
}
