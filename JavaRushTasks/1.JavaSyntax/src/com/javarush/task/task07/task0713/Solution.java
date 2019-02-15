package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> others = new ArrayList<>();


        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        for(int i : list){
            if (i % 3 == 0) three.add(i);
            if (i % 2 == 0) two.add(i);
            if (i % 3 != 0 && i % 2 != 0) others.add(i);
        }

        printList(three);
        System.out.println("=");
        printList(two);
        System.out.println("=");
        printList(others);
    }

    public static void printList(List<Integer> list) {
        for(int i : list){
            System.out.println(i);
        }
    }
}
