package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(lines);
    }

    static {
        try {
            Files.lines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8).forEach((String str) -> lines.add(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//          BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
//          while (reader.ready()) lines.add(reader.readLine());
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}
