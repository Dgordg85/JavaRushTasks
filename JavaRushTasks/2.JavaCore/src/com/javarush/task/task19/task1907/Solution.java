package com.javarush.task.task19.task1907;

/*
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader buffer = new BufferedReader(fileReader);
        reader.close();

        StringBuilder str = new StringBuilder();
        int countWord = 0;

        while (buffer.ready()){
            str.append(buffer.readLine() + " ");
        }

        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            countWord++;
        }

        fileReader.close();
        System.out.println(countWord);
    }

}
