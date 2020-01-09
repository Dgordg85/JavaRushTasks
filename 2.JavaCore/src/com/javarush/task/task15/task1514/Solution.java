package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    static{
        labels.put(1.2d, "Строка 1");
        labels.put(7d, "Строка 2");
        labels.put(10d, "Строка 3");
        labels.put(12d, "Строка 4");
        labels.put(32d, "Строка 5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
