package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arr20 = new int[20];
        int[] arr10_1 = new int[10];
        int[] arr10_2 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            arr20[i] = Integer.parseInt(reader.readLine());
        }

        arr10_1 = Arrays.copyOfRange(arr20,0,10);
        arr10_2 = Arrays.copyOfRange(arr20,10,20);

        for(int i : arr10_2){
            System.out.println(i);
        }
    }
}
