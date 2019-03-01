package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        /*try {
            allPeople.add(Person.createMale("Миронов", (new SimpleDateFormat("d/MM/y").parse("15/04/1990"))));
            allPeople.add(Person.createFemale("Миронова", (new SimpleDateFormat("d/MM/y").parse("25/04/1997"))));
        } catch (ParseException e) {}*/
    }

    public static void main(String[] args) throws ParseException {
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        int countC = 0;
                        while (true) {
                            Person.createPeopleById(args[1 + countC * 3], args[2 + countC * 3], args[3 + countC * 3]);
                            countC++;
                        }
                    }
                case "-u":
                    synchronized (allPeople) {
                        int countU = 0;
                        while (true) {
                            Person.updatePeopleById(args[1 + countU * 4], args[2 + countU * 4], args[3 + countU * 4], args[4 + countU * 4]);
                            countU++;
                        }
                    }
                case "-d":
                    synchronized (allPeople) {
                        int d = 1;
                        while (true) Person.nullPeopleById(Integer.parseInt(args[d++]));
                    }
                case "-i":
                    synchronized (allPeople) {
                        int i = 1;
                        while (true) Person.getPeopleById(Integer.parseInt(args[i++]));
                    }
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }
}
