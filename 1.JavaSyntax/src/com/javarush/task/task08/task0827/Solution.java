package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dt = new SimpleDateFormat("MMMM d yyyy", Locale.US);
        cal.setTime(dt.parse(date));
        return ((cal.get(cal.DAY_OF_YEAR) + 1) % 2 == 0);
    }
}
