package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Date date = new SimpleDateFormat("yyyy-MM-d").parse(reader.readLine());

        SimpleDateFormat newDf = new SimpleDateFormat("MMM d, y", Locale.US );
        System.out.println(newDf.format(date).toUpperCase());

    }
}
