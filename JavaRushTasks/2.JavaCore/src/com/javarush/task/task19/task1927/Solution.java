package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;
import java.sql.SQLOutput;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream defaultOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(defaultOut);

        changeStreamAndConsoleIt(outputStream);
    }

    private static void changeStreamAndConsoleIt(ByteArrayOutputStream outputStream) throws IOException {
        String[] lines = outputStream.toString().split(System.getProperty("line.separator"));
        int countEnter = 0;
        for (String line : lines){
            System.out.println(line);
            if (++countEnter % 2 == 0){
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

}
