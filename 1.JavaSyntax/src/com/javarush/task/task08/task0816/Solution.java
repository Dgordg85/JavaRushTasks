package com.javarush.task.task08.task0816;

import java.text.*;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Sasha", df.parse("JUNE 22 1970"));
        map.put("Andrey", df.parse("JUNE 22 1990"));
        map.put("Artem", df.parse("JAN 22 1980"));
        map.put("Jora", df.parse("JULY 22 1970"));
        map.put("Fil9", df.parse("MAY 22 1970"));
        map.put("Xoma", df.parse("APRIL 22 1970"));
        map.put("Baga", df.parse("JULY 22 1970"));
        map.put("Arta", df.parse("AUG 22 1970"));
        map.put("Son", df.parse("FEB 22 1970"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) throws ParseException {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            int dateMonth = pair.getValue().getMonth();
            List<Integer> summerMonth = Arrays.asList(new Integer[]{5, 6, 7});
            if (summerMonth.contains(dateMonth)){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws ParseException {

    }
}
