package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString(null));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        StringBuilder sb = new StringBuilder();

        if (string == null || string.split(" ").length < 5)
            throw new TooShortStringException();

        String arr[] = string.split(" ");
        for (int i = 1; i <= 4; i++) {
            sb.append(arr[i]);
            if (i != 4) sb.append(" ");
        }
        return sb.toString();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
