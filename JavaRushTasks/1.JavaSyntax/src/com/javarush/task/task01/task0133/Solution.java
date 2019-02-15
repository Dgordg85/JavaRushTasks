package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        int secondsAfter15 = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("H:m");
        Date date1 = dateFormat.parse("15:00");
        Date date2 = dateFormat.parse("15:30");
        long milliseconds = date2.getTime() - date1.getTime();
        secondsAfter15 = (int) milliseconds / 1000;
        System.out.println(secondsAfter15);
    }
}