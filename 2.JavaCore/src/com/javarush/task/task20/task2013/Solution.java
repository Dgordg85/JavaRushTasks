package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){

        }


        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(firstName, person.firstName) &&
                    Objects.equals(lastName, person.lastName) &&
                    Objects.equals(mother, person.mother) &&
                    Objects.equals(father, person.father) &&
                    Objects.equals(children, person.children);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, age, mother, father, children);
        }


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person dave = new Person("Dave", "Smith", 27);
        Person daveMother = new Person("Annet", "Smitrh", 62);
        Person daveFather = new Person("Mike", "Smith", 57);
        Person daveSon = new Person("Gordy", "Smith", 6);
        Person daveDaughter = new Person("Jilly", "Smith", 3);

        List<Person> listChildren = new ArrayList<>();
        listChildren.add(daveSon);
        listChildren.add(daveDaughter);

        dave.setFather(daveFather);
        dave.setMother(daveMother);
        dave.setChildren(listChildren);

        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream("C:/1/1.bin"));
        streamOut.writeObject(dave);
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream("C:/1/1.bin"));
        Person daveCopy = (Person) streamIn.readObject();
        streamIn.close();

        System.out.println(dave.equals(daveCopy));
    }
}
