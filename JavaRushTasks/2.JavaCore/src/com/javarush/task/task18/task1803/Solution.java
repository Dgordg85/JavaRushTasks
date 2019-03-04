package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        while (file.available() > 0) {
            int currentByte = file.read();
            if (map.containsKey(currentByte)) {
                map.replace(currentByte, map.get(currentByte).intValue() + 1);
            } else {
                map.put(currentByte, 1);
            }
        }
        int maxMapValue = Collections.max(map.values());
        for (Map.Entry entry : map.entrySet()){
            if (entry.getValue().equals(maxMapValue)) {
                System.out.print(entry.getKey() + " ");
            }
        }

        file.close();
        reader.close();

    }
}
