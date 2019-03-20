package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String str;
        while ((str = reader.readLine()) != null){
            String[] strSplit = str.split(" ");
            String secondName = strSplit[0];
            Double newValue = Double.parseDouble(strSplit[1]);

            if (map.containsKey(secondName)){
                Double oldValue = map.get(secondName);
                map.replace(secondName, oldValue, oldValue + newValue);
            } else {
                map.put(secondName, newValue);
            }
        }
        reader.close();

        TreeSet<String> tree = new TreeSet<>();
        for (Map.Entry entry : map.entrySet()){
            tree.add(entry.getKey() + " " + entry.getValue());
        }

        for (String s : tree){
            System.out.println(s);
        }
    }
}
