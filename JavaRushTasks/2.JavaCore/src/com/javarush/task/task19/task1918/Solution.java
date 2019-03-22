package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader stream = new BufferedReader(new FileReader(reader.readLine()));


        String tagBegin = "<" + args[0];
        String tagEnd = "</" + args[0] + ">";
        StringBuilder sb = new StringBuilder();

        String str;
        while ((str = stream.readLine()) != null) {
            sb.append(str + " ");
        }

        int indexBegin = 0;
        int indexEnd = -1;
        while ((indexBegin = sb.indexOf(tagBegin, indexBegin)) > -1) {

            while (true) {
                indexEnd = sb.indexOf(tagEnd, indexEnd + 1);
                String subStr = sb.substring(indexBegin + tagBegin.length(), indexEnd - tagEnd.length() - 3);
                if (!(subStr.indexOf(tagBegin) > -1)) {
                    System.out.println(subStr);
                    break;
                }
            }
        }

    }
}
