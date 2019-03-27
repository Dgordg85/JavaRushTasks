package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader stream = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader stream = new BufferedReader(new FileReader("C:/1/."));
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
