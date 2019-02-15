package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String[] str = new String[10];
        str = s.split(" ");


        for (int i = 0; i < str.length; i++) {
            if (str[i].isEmpty()) continue;
            System.out.println(str[i].substring(0,1).toUpperCase() + str[i].substring(1));
        }
    }
}
