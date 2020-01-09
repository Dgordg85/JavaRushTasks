package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();
        map.put("Агапов", "Артём");
        map.put("Агапова", "Андрей");
        map.put("Болдин", "Артём");
        map.put("Юров", "Александр");
        map.put("Самохвалов", "Виталий");
        map.put("Березин", "Роман");
        map.put("Ыгыдарова", "Юля");
        map.put("Абырбек", "Катя");
        map.put("Ватютин", "Веньямин");
        map.put("Агапов", "Александр");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
