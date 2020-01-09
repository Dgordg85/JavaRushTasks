package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws Exception {

    }

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());
        load(stream);
    }


    public void save(OutputStream outputStream) throws Exception {
        Properties fileProperties = new Properties();
        fileProperties.putAll(properties);
        fileProperties.store(outputStream, "Итоговый файл");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties fileProperties = new Properties();
        fileProperties.load(inputStream);
        fileProperties.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    }


}
