package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(fileName.readLine());

        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        //reader.read();

        List<Integer> list = new ArrayList<>();

        while (reader.ready()){
            int num = Integer.parseInt(reader.readLine());
            if (num % 2 == 0){
                list.add(num);
            }
        }

        Collections.sort(list);

        for (int i : list){
            System.out.println(i);
        }

        file.close();
        fileName.close();
    }
}
