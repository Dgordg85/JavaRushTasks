package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Иван");
        map.put("Обмаев", "Петр");
        map.put("Жилеткин", "Илья");
        map.put("Кокорин", "Евгений");
        map.put("Мамаев", "Александр");
        map.put("Бабаев", "Олег");
        map.put("Жеглов", "Артем");
        map.put("Кроткин", "Артем");
    return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, String> pair : map.entrySet()){
            if(Collections.frequency(map.values(), pair.getValue()) > 1){
                list.add(pair.getValue());
            }
        }

        for (String name : list) {
            removeItemFromMapByValue(map, name);
        }

//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " - " + pair.getValue());
//        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }
}
