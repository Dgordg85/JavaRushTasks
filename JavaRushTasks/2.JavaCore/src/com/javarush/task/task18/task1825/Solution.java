package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Set<Integer> tree = new TreeSet<>();
        String readConsole;
        String fileName = "";
        boolean isFileNameRead = false;

        try {
            while (!(readConsole = sc.nextLine()).equals("end")) {
                if (!isFileNameRead) {
                    fileName = readConsole.substring(0, readConsole.indexOf(".part"));
                    isFileNameRead = true;
                }
                String partN = readConsole.substring(readConsole.indexOf(".part") + 5);
               tree.add(Integer.parseInt(partN));
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Формат файла [someName].partN");
            isFileNameRead = false;
        }

        if (isFileNameRead) {
            //FileOutputStream streamOut = new FileOutputStream("C:/1/" + fileName + ".txt");
            FileOutputStream streamOut = new FileOutputStream(fileName);
            BufferedOutputStream streamOutBuf = new BufferedOutputStream(streamOut, 6400);

            for (Integer part : tree) {
                FileInputStream streamIn = new FileInputStream(fileName + ".part" + part);
                //BufferedInputStream streamInBuf = new BufferedInputStream(streamIn, 6400);
                BufferedInputStream streamInBuf = new BufferedInputStream(streamIn, 6400);

                int i;
                while ((i = streamInBuf.read()) != -1) {
                    streamOutBuf.write(i);
                }
                streamIn.close();
            }
            streamOutBuf.close();
        }
    }
}
