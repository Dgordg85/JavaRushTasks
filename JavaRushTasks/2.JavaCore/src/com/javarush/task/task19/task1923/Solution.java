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
        StringBuilder strOut = new StringBuilder();
        Pattern pattern = Pattern.compile("([\\wА-Яа-яЁё]*\\d+[\\wА-Яа-яЁ]*)");
        while ((str = reader.readLine()) != null){
            Matcher matcher = pattern.matcher(str);

            while(matcher.find()){
                strOut.append(matcher.group(1) + " ");
            }
        }
        writer.write(strOut.toString());

        reader.close();
        writer.close();
    }
}
