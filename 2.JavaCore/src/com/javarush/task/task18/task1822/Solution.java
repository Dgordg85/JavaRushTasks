package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileInputStream file = new FileInputStream(sc.nextLine());
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String str;

        while (reader.ready()){
            str = reader.readLine();
            if (str.startsWith(args[0] + " ")){
                System.out.println(str);
                break;
            }
        }

        reader.close();
    }
}
