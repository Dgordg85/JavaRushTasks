package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int maxLength = 1;
        int tempLength = 1;
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(reader.readLine());
            list.add(number);
        }


        for (int i = 0; i < 9; i++) {
            if (list.get(i).equals(list.get(i + 1))){
                tempLength++;
                if (tempLength > maxLength) maxLength = tempLength;
            } else {
                tempLength = 1;
            }
        }
        System.out.println(maxLength);
    }
}