package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> intArr = new ArrayList<>();
        intArr.add(new int[5]);
        intArr.add(new int[2]);
        intArr.add(new int[4]);
        intArr.add(new int[7]);
        intArr.add(new int[0]);

        for (int i = 0; i < intArr.size(); i++) {
            for (int j = 0; j < intArr.get(i).length; j++) {
                intArr.get(i)[j] = (int) (Math.random() * 100);
            }
        }
        return intArr;
    }



    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
