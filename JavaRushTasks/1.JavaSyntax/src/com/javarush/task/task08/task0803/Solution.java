package com.javarush.task.task08.task0803;

import java.util.*;

/*
Коллекция HashMap из котов
*/

public class Solution {
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("Mama");
        list.add("Mila");
        list.add("Ramu");

        Iterator<String> iterator = list.iterator();//получение итератора для списка
        System.out.println("внутри итератора хранится: " + iterator);
        while (iterator.hasNext())      //проверка, есть ли ещё элементы
        {
            //получение текущего элемента и переход на следующий
            String text = iterator.next();

            System.out.println(text);
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats) {
        HashMap<String, Cat> catsMap = new HashMap<>();

        for (String str : cats) {
            catsMap.put(str, new Cat(str));
        }
        return catsMap;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

//        @Override
//        public String toString() {
//            return name != null ? name.toUpperCase() : null;
//        }
    }
}
