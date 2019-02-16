package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
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

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
       Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
       int count = 0;
       while(iterator.hasNext()){
           Map.Entry<String, String> pair = iterator.next();
           if (name.equals(pair.getValue())) count++;
       }
       return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        while(iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (lastName.equals(pair.getKey())) count++;
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
