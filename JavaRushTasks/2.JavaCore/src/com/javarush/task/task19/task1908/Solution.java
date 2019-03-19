package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();


        StringBuilder str = new StringBuilder();
        while (fileReader.ready()){
            str.append(fileReader.readLine() + " ");
        }

        Pattern pattern = Pattern.compile("^(\\d)|\\s(\\d+)\\s|(\\d+)$");
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){
            fileWriter.write(matcher.group().trim() + " ");
        }


        fileReader.close();
        fileWriter.close();
    }
}
