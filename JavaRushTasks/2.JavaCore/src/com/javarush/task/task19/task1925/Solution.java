package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        Pattern pattern = Pattern.compile("[\\S]{7,}");
        String str;
        boolean firstWord = true;
        while((str = reader.readLine()) != null){

            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                if(firstWord){
                    writer.write(matcher.group());
                    firstWord = false;
                } else {
                    writer.write( "," + matcher.group());
                }


            }
        }
        reader.close();
        writer.close();
    }
}
