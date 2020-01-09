package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listDoubleTripple = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() % 2 == 0) {
                listDoubleTripple.add(s + " " + s);
            } else {
                listDoubleTripple.add(s + " " + s + " " + s);
            }
        }

        for (int i = 0; i < listDoubleTripple.size(); i++) {
            System.out.println(listDoubleTripple.get(i));
        }
    }
}
