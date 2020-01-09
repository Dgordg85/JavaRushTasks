package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<>();
    private static final int COUNT_MAX = 2;

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader stream = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        String str;
        while((str = stream.readLine()) != null){
            int count = 0;
            String[] strArr = str.split(" ");

            for(String s : strArr){
                if (words.contains(s)) count++;
                if (count > COUNT_MAX) break;
            }
            if (count == COUNT_MAX) System.out.println(str);
        }
        stream.close();
    }
}
