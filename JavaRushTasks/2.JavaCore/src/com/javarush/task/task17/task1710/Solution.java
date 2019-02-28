package com.javarush.task.task17.task1710;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("d/MM/y");

        switch (args[0]){
            case "-c":
                if (args[2].equals("м")){
                    allPeople.add(Person.createMale(args[1], date.parse(args[3])));
                } else {
                    allPeople.add(Person.createFemale(args[1], date.parse(args[3])));
                }
                System.out.println(allPeople.size() - 1);
                break;
            case "-u":
                Person uP = allPeople.get(Integer.parseInt(args[1]));
                uP.setName(args[2]);
                uP.setSex(args[3].equals("м")? Sex.MALE : Sex.FEMALE);
                uP.setBirthDate(date.parse(args[4]));
                break;
            case "-d":
                Person dP = allPeople.get(Integer.parseInt(args[1]));
                dP.setBirthDate(null);
                dP.setName(null);
                dP.setSex(null);
                break;
            case "-i":
                SimpleDateFormat modifyDate = new SimpleDateFormat("d-MMM-y", Locale.ENGLISH);
                Person iP = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(iP.getName() + " " + (iP.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + modifyDate.format(iP.getBirthDate()));
                break;
        }
    }
}
