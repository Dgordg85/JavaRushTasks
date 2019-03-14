package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static List<String> list;
    private static String fileName;
    private static String[] argsArray;
    private static boolean validArgs;

    public static void main(String[] args) throws IOException {
        argsArray = args;
        startWork();
    }

    private static void startWork() throws IOException {
        Scanner sc = new Scanner(System.in);
        list = fileToList(fileName = sc.nextLine());

        switch (argsArray[0]){
            case "-u":
                if (argsArray.length == 5) updateString();
                break;
            case "-d":
                if (argsArray.length == 2) deleteString();
                break;
            case "-c":
                if (argsArray.length == 4) createString();
                break;
        }
        if (!validArgs) System.out.println("Ошибка аргументов");
    }

    private static List<String> fileToList(String filename) throws IOException {
        FileInputStream fileStream = new FileInputStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream, "Windows-1251"));
        List<String> list = new ArrayList<>();

        while(reader.ready()){
            list.add(reader.readLine());
        }
        reader.close();
        return list;
    }

    private static void listToFile() throws IOException {
        FileOutputStream  fileStream = new FileOutputStream(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileStream, "Windows-1251"));
        int countRN = 0;
        for (String str : list){
            writer.write(str);
            if (++countRN < list.size())writer.write("\r\n");
        }
        writer.close();
    }

    private static void createString() throws IOException {
        validArgs = true;
        list.add(getMaxListId() + 1 + concatArgs());
        listToFile();
    }

    private static void updateString() throws IOException {
        validArgs = true;
        list.set(getStringIdInList(), concatArgs());
        listToFile();
    }

    private static void deleteString() throws IOException {
        validArgs = true;
        list.remove(getStringIdInList());
        listToFile();
    }

    private static String concatArgs(){
        StringBuilder str = new StringBuilder();
        int[] concatLength = {0, 8, 30, 8, 4};
        for (int i = 1; i < argsArray.length; i++) {
            str.append(concatStr(argsArray[i], concatLength[i]));
        }
        return str.toString();
    }

    private static String concatStr(String str, Integer count){
        if (str.length() > count) str = str.substring(0, count);
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

    private static int getStringIdInList(){
        Integer listId = null;
        for (String str : list){
            if (Integer.parseInt(argsArray[1]) == Integer.parseInt(str.substring(0, 8).trim())){
                listId = list.indexOf(str);
                break;
            }
        }
        return listId;
    }

    private static int getMaxListId(){
        int index, maxIndex = 0;
        try {
            for (String str : list) {
                if ((index = Integer.parseInt(str.substring(0, 8).trim())) > maxIndex) maxIndex = index;
            }
        }catch (NumberFormatException e){
            System.out.println("Не верный формат файла!");
        }
        return maxIndex;
    }
}
