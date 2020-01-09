package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Артем", 500);
        map.put("Женя", 455);
        map.put("Марта", 552);
        map.put("Питер", 499);
        map.put("Олеся", 501);
        map.put("Вика", 450);
        map.put("Галя", 200);
        map.put("Катя", 400);
        map.put("Оля", 700);
        map.put("Григорий", 1500);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        map.values().removeIf(s -> s < 500);
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> map = createMap();
//        removeItemFromMap(map);
//
//        for (Map.Entry<String, Integer> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " - " + pair.getValue());
//        }
    }
}