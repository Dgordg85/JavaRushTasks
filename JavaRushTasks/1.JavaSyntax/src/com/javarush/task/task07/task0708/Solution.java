package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxCountLength = 0;

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
            if (strings.get(i).length() > maxCountLength)
                maxCountLength = strings.get(i).length();
        }

        for (int i = 0; i < 5; i++) {
            if (strings.get(i).length() == maxCountLength)
                System.out.println(strings.get(i));
        }


    }
}
