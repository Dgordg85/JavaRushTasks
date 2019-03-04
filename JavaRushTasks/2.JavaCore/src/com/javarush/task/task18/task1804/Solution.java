package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (file.available() > 0) {
            int currentByte = file.read();
            if (map.containsKey(currentByte)) {
                map.replace(currentByte, map.get(currentByte).intValue() + 1);
            } else {
                map.put(currentByte, 1);
            }
        }
        file.close();

        int minMapValue = Collections.min(map.values());
        for (Map.Entry entry : map.entrySet()){
            if (entry.getValue().equals(minMapValue)) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
