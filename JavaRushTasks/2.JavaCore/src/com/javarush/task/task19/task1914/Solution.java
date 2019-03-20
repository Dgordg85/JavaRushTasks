package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(defaultOut);

        takeExpression(outputStream.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    private static void takeExpression(String str) {
        Pattern pattern = Pattern.compile("^(\\d+)\\s*([+\\-*])\\s*(\\d+)\\s*=");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            int firstNum = Integer.parseInt(matcher.group(1));
            int secondNum = Integer.parseInt(matcher.group(3));

            int result = 0;
            switch (matcher.group(2)) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
            }

            System.out.println(matcher.group(0) + " " + result);

        }
    }
}

