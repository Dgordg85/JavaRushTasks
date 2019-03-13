package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName;
        List<String> list = Files.readAllLines(Paths.get(fileName = sc.nextLine()), Charset.forName("windows-1251"));
        int maxIndex = 0;
        int index;

        try {
            for (String str : list) {
                if ((index = Integer.parseInt(str.substring(0, 8).trim())) > maxIndex) maxIndex = index;
            }
        }catch (NumberFormatException e){
            System.out.println("Не верный формат файла!");
        }

        FileOutputStream stream = new FileOutputStream(fileName, true);
        if (args[0].equals("-c")){
            String id = ConcatStr(++maxIndex + "", 8);
            String productName = ConcatStr(args[1], 30);
            String price = ConcatStr(args[2], 8);
            String quantity = ConcatStr(args[3], 4);
            stream.write(("\r\n" + id + productName + price + quantity).getBytes("windows-1251"));
        }
        stream.close();

    }

    private static String ConcatStr(String str, Integer count){
        if (str.length() > count) str = str.substring(0, count - 1);
        else if (str.length() < count){
            StringBuilder spases = new StringBuilder();
            spases.append(str);
            for (int i = 0; i < count - str.length(); i++) {
                spases.append(" ");
            }
            str = spases.toString();
        }
        return str;
    }

}
