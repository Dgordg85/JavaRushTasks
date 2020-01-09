package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, String[]> map = new HashMap<>();
        int iter = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String str = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo&obj=String";
        URL url = new URL(reader.readLine());
        String[] query = url.getQuery().split("&");

        for (String pair : query){
            int ind = pair.indexOf("=");
            if (ind > 0){
                String[] arrStr = {pair.substring(0, ind), pair.substring(ind + 1)};
                map.put(iter, arrStr);
            } else {
                String[] arrStr = {pair};
                map.put(iter, arrStr);
            }
            iter++;
        }

        for (int i = 0; i < map.size(); i++) {
            System.out.print(map.get(i)[0] + " ");
        }
        for (int i = 0; i < map.size(); i++) {
            String[] currentElem = map.get(i);
            if (currentElem[0].equals("obj")){
                try{
                    alert(Double.parseDouble(currentElem[1]));
                }catch(Exception e){
                    alert(currentElem[1]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
