package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        try {
            while (true){
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                map.put(name, id);
            }
        }
        catch (NumberFormatException e){
            for(Map.Entry<String, Integer> mapE : map.entrySet()){
                System.out.println(mapE.getValue() + " " + mapE.getKey());
            }
        }

    }
}
