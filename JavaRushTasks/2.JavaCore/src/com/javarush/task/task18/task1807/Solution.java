package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        FileInputStream file = new FileInputStream(sc.nextLine());
        int countComa = 0;
        while (file.available() > 0) {
            if (file.read() == 44) countComa++;
        }

        System.out.println(countComa);
        file.close();
    }
}
