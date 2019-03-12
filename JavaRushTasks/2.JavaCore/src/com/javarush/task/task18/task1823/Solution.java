package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.nextLine()).equals("exit")){
            new ReadThread(str).start();
        }
    }

    public static class ReadThread extends Thread  {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                int[] buffer = new int[256];
                FileInputStream file = new FileInputStream(fileName);
                BufferedInputStream stream = new BufferedInputStream(file, 200);

                //Загоняем все символы в массив
                int i;
                while ((i = stream.read()) != -1) {
                    buffer[i]++;
                }
                //Находим максимальный
                int max = -1;
                int maxElem = 0;
                for (int j = 0; j < buffer.length; j++) {
                    if (buffer[j] > max){
                        max = buffer[j];
                        maxElem = j;
                    }
                }

                synchronized (resultMap){
                    resultMap.put(fileName, maxElem);
                }

                stream.close();

            } catch (IOException e) {
                System.out.println("Что то пошло не так!");
            }
        }
    }
}