package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        double maxValue = 0;

        String str;
        while ((str = reader.readLine()) != null){
            String[] strSplit = str.split(" ");
            String secondName = strSplit[0];
            Double newValue = Double.parseDouble(strSplit[1]);
            Double oldValue = 0.0;

            if (map.containsKey(secondName)){
                oldValue = map.get(secondName);
                map.replace(secondName, oldValue, oldValue + newValue);
            } else {
                map.put(secondName, newValue);
            }

            if ((oldValue + newValue) > maxValue) maxValue = oldValue + newValue;
        }
        reader.close();

        TreeSet<String> tree = new TreeSet<>();
        for (Map.Entry entry : map.entrySet()){
            if (entry.getValue().equals(maxValue))
            tree.add(entry.getKey().toString());
        }

        for (String s : tree){
            System.out.println(s);
        }
    }
}
