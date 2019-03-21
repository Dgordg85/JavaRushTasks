package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");


    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader stream = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        //Для русских символов
        //Pattern pattern = Pattern.compile("[^А-Яа-яеЁ]\\b(\\d[0-2]?)\\b[^А-Яа-яеЁ]");
        Pattern pattern = Pattern.compile("\\b(\\d[0-2]?)\\b");

        String str;
        StringBuffer sb = new StringBuffer();
        while ((str = stream.readLine()) != null){

            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                //Для русских символов
                //Получаем тестовый вариант по числу.
                //String num = map.get(Integer.parseInt(matcher.group(1)));
                //Подменяем в строке взятой из группы0 число на текстовый
                //matcher.appendReplacement(sb, matcher.group(0).replaceAll("\\d+", num));
                matcher.appendReplacement(sb, map.get(Integer.parseInt(matcher.group())));
            }
            matcher.appendTail(sb);
            sb.append(System.getProperty("line.separator"));

        }
        stream.close();
        System.out.println(sb);
    }
}
