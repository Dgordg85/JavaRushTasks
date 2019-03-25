package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader stream = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader stream = new BufferedReader(new FileReader("C:/1/1.txt"));

        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = stream.readLine()) != null) {
            sb.append(str);
        }

        Map<Integer, Boolean> map = tagsInList(args[0], sb.toString());

        List<Integer> sortedKeys = new ArrayList(map.keySet());
        Collections.sort(sortedKeys);

        int count = 0;
        for (int i = 0; i < sortedKeys.size(); i++) {
            int key = sortedKeys.get(i);
            for (int j = i + 1; j < map.size(); j++) {
                if (map.get(sortedKeys.get(j))){
                    count++;
                } else {
                    count--;
                }

                if (count == 0){
                    System.out.print(key + " " + sortedKeys.get(j));
                    System.out.println(sb.substring(key, sortedKeys.get(j)));
                    break;
                }

            }
            System.out.println(key + " - " + map.get(key));
        }

    }


    private static Map<Integer, Boolean> tagsInList(String tag, String text){
        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";

        Map<Integer, Boolean> map = new HashMap<>();
        int pos = 0;
        while ((pos = text.indexOf(openTag, pos)) > -1){
            map.put(pos, true);
            pos += openTag.length();
        }

        pos = 0;
        while ((pos = text.indexOf(closeTag, pos)) > -1){
            map.put(pos, false);
            pos += closeTag.length();
        }
        return map;
    }
}
