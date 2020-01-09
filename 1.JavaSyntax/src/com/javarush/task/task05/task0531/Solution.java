package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        System.out.println("Minimum = " + min(a, b, c, d, e));
    }


    public static int min(int a, int b, int c, int d, int e) {
        return min(e, min(min(a,b),min(c, d)));
    }

    public static int min(int a, int b){
        return a < b ? a : b;
    }
}
