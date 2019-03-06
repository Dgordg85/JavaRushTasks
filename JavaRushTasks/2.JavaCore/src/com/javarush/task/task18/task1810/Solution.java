package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            FileInputStream file = new FileInputStream(sc.nextLine());
            if (file.available() < 1000) {
                file.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
