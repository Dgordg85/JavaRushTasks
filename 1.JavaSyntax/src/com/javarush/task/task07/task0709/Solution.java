package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int countMinLength = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            list.add(sc.nextLine());
            if (list.get(i).length() < countMinLength) countMinLength = list.get(i).length();
        }

        for (int i = 0; i < 5; i++) {
            if (list.get(i).length() == countMinLength) System.out.println(list.get(i));
        }
    }
}
