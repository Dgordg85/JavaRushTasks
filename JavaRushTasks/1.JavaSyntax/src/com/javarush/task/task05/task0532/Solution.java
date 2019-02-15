package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        short count = Short.parseShort(reader.readLine());
       // System.out.println(count);

        int maximum = -2147483648;
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(reader.readLine());
            if (number > maximum) maximum = number;
        }

        System.out.println(maximum);
    }
}
