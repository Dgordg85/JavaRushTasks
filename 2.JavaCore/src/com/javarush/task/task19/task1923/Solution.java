package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String str;
        Pattern pattern = Pattern.compile("\\S*\\d+\\S*");
        while ((str = reader.readLine()) != null){
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                writer.write(matcher.group() + " ");
            }
        }


        reader.close();
        writer.close();
    }
}
