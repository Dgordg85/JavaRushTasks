package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("Чучхела");
        list.add("Самса");
        list.add("Пахлава");
        list.add("Коржик");
        list.add("Хмель");

        System.out.println(list.size());
        for (String i : list) {
            System.out.println(i);
        }

    }
}
