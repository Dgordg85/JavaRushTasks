package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String vowels = "",
                notVowels = "";

        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char strChar = str.charAt(i);


            if (isVowel(strChar)) {
                vowels += strChar + " ";
            }else {
                if (strChar == ' ') continue;
                notVowels += strChar + " ";
            }
        }
        System.out.println(vowels);
        System.out.println(notVowels);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}