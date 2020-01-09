package com.javarush.task.task07.task0718;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        boolean isFind = false;
        int countLength = 0;
        int index = 0;
        for (int i = 0; i < 10; i++) {
            String word = sc.nextLine();
            list.add(word);
            if (countLength > word.length() && isFind == false) {
                index = i;
                isFind = true;
            } else {
                countLength = word.length();
            }
        }

        if (index != 0) System.out.println(index);
    }

}

