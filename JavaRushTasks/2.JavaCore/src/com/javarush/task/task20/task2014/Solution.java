package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream("C:/1/2.bin"));
        Solution savedObject = new Solution(25);
        streamOut.writeObject(savedObject);
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream("C:/1/2.bin"));
        Solution openObject = (Solution) streamIn.readObject();
        System.out.println(openObject);
        streamIn.close();
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
