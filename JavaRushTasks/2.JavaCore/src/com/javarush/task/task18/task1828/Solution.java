package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.text.DecimalFormat;
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

        switch (argsArray[0]) {
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

        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();
        return list;
    }

    private static void listToFile() throws IOException {
        FileOutputStream fileStream = new FileOutputStream(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileStream, "Windows-1251"));
        int countRN = 0;
        for (String str : list) {
            writer.write(str);
            if (++countRN < list.size()) writer.newLine();
        }
        writer.close();
    }

    private static void createString() throws IOException {
        validArgs = true;
        parsePrice();
        list.add((getMaxListId() + 1) + concatArgs());
        listToFile();
    }

    private static void updateString() throws IOException {
        validArgs = true;
        parsePrice();
        int index = getStringIdInList();
        if (index != -1){
            list.set(index, concatArgs());
        } else {
            System.out.println("Невозможно обновить - такой элемент не найден!");
        }
        listToFile();
    }

    private static void deleteString() throws IOException {
        validArgs = true;
        int index = getStringIdInList();
        if (index != -1){
            list.remove(index);
        } else {
            System.out.println("Невозможно удалить - такой элемент не найден!");
        }
        listToFile();
    }

    private static String concatArgs() {
        StringBuilder str = new StringBuilder();
        int[] concatLength = {0, 8, 30, 8, 4};

        if (argsArray[0].equals("-c")) {
            int[] concatLengthC = {0, 30, 8, 4};
            concatLength = concatLengthC;
        }

        for (int i = 1; i < argsArray.length; i++) {
            str.append(String.format("%-" + concatLength[i] + "s", argsArray[i]));
        }
        return str.toString();
    }

    private static int getStringIdInList() {
        int listId = -1;
        for (String str : list) {
            int  index = Integer.parseInt(argsArray[1].trim());
            int  listIndex = Integer.parseInt(str.substring(0, 8).trim());
            if (index == listIndex) {
                listId = list.indexOf(str);
                break;
            }
        }
        return listId;
    }

    private static int getMaxListId() {
        int index, maxIndex = 0;
        try {
            for (String str : list) {
                if ((index = Integer.parseInt(str.substring(0, 8).trim())) > maxIndex) maxIndex = index;
            }
        }catch (NumberFormatException e) {
            System.out.println("Не верный формат файла!");
        }
        return maxIndex;
    }

    private static void parsePrice() {
        String str = "";
        int argIndex = 0;
        if (argsArray[0].equals("-c")){
            str = argsArray[2];
            argIndex = 2;
        } else if (argsArray[0].equals("-u")){
            str = argsArray[3];
            argIndex = 3;
        }
        str = String.format("%.2f", Float.parseFloat(str.trim()));
        argsArray[argIndex] = str.replace(",", ".");

    }
}
