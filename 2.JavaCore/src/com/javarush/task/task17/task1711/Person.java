package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.javarush.task.task17.task1711.Solution.allPeople;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDate;

    private Person(String name, Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public static Person createMale(String name, Date birthDate) {
        return new Person(name, Sex.MALE, birthDate);
    }

    public static Person createFemale(String name, Date birthDate) {
        return new Person(name, Sex.FEMALE, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public static void createPeopleById(String name, String sex, String dateStr) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/y");

        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, date.parse(dateStr)));
        } else {
            allPeople.add(Person.createFemale(name, date.parse(dateStr)));
        }
        System.out.print(allPeople.size() - 1 + " ");
    }

    public static void updatePeopleById(String id, String name, String sex, String dateStr) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/y");
        Person iP = allPeople.get(Integer.parseInt(id));
        iP.setName(name);
        iP.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
        iP.setBirthDate(date.parse(dateStr));
    }

    public static void nullPeopleById(int id){
        Person iP = allPeople.get(id);
        iP.setBirthDate(null);
        iP.setName(null);
        iP.setSex(null);
    }

    public static void getPeopleById(int id){
        Person iP = allPeople.get(id);
        SimpleDateFormat modifyDate = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        System.out.println(iP.getName() + " " + (iP.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + modifyDate.format(iP.getBirthDate()));
    }
}
