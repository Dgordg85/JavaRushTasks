package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (true){
            try {
                FileInputStream stream = new FileInputStream(str = sc.nextLine());
                stream.close();
            }catch (FileNotFoundException e){
                System.out.println(str);
                break;
            }
        }
    }
}
