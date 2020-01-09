package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String time = reader.readLine();
        String name = reader.readLine();
        System.out.println(name + " захватит мир через " + Integer.parseInt(time) + " лет. Му-ха-ха!");

    }
}