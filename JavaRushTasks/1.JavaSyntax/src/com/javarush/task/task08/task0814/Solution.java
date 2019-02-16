package com.javarush.task.task08.task0814;

import java.util.*;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> intSet = new HashSet<>();
        Collections.addAll(intSet,5, 10, 15, 8, -7, 13, 294, 7, 25, 24, 1, -50, 2, 2555, 25, 95, 12, 59, 50, 20, 72);
        return intSet;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        set.removeIf(s -> s > 10);
        set.forEach(s -> System.out.println(s));
//        Iterator<Integer> numInt = set.iterator();
//
//        while(numInt.hasNext()){
//            if (numInt.next() > 10) numInt.remove();
//
//        }
        return set;
    }

    public static void main(String[] args) {
        removeAllNumbersGreaterThan10(createSet());
    }
}
