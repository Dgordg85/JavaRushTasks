package com.javarush.task.task06.task0606;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
//        InputStreamReader stream = new InputStreamReader(System.in);
//        do{
//            int ch = stream.read();
//            if (ch % 2 == 0 && ch != 10) even++;
//            else if (ch != 10)odd++;
//        } while (stream.ready());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)% 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
