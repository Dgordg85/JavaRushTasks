package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import org.omg.PortableServer.ForwardRequest;
import sun.font.FontRunIterator;

import java.io.*;
import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outString = "Меня зовут " + reader.readLine() + ".\nЯ родился ";

        String date = "";
        for (int i = 1; i <= 3; i++) {
            date = Integer.parseInt(reader.readLine()) + date;
            if (i != 3) date = "." + date;
        }
        System.out.println(outString + date);
    }
}
