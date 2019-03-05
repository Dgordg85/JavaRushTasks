package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        FileInputStream one = new FileInputStream(sc.nextLine());
        FileOutputStream two = new FileOutputStream(sc.nextLine());
        FileOutputStream three = new FileOutputStream(sc.nextLine());

        //середина файла
        int separate = one.available() / 2;

        //смотрим сколько байт уже раскидано по файлам
        int countBytes = 0;

        // дописываем в первый файл часть буфера и меняем флаг
        boolean endFirstFile = false;

        // определеяем размер буфера
        int bufferSize = 1;
        if (separate > 6000 * 2) bufferSize = 6000;
        byte[] buffer = new byte[bufferSize];

        while (one.available() > 0){
            System.out.println("Осталось=" + one.available());

            one.read(buffer);
            System.out.println("buffer=" + buffer.length);
            if (!endFirstFile)countBytes += bufferSize;

            if (countBytes < separate){
                two.write(buffer);
            } else {
                if (!endFirstFile){
                    int separateCount = separate % bufferSize;
                    two.write(buffer,0, separateCount);
                    three.write(buffer, separateCount, bufferSize - separateCount);
                    endFirstFile = true;
                } else {
                    three.write(buffer);
                }

            }
        }

        one.close();
        two.close();
        three.close();





    }
}
