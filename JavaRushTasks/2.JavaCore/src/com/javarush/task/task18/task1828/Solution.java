package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static List<Products> list;
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
                if (argsArray.length == 4) create();
                break;
        }
        if (!validArgs) System.out.println("Ошибка аргументов");
    }

    private static List<Products> fileToList(String filename) throws IOException {
        FileInputStream fileStream = new FileInputStream(filename);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream, "Windows-1251"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
        List<Products> list = new ArrayList<>();

        while (reader.ready()) {
            list.add(productFromLine(reader.readLine()));
        }
        reader.close();
        return list;
    }

    private static void listToFile() throws IOException {
        FileOutputStream fileStream = new FileOutputStream(fileName);
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileStream, "Windows-1251"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileStream));
        int countRN = 0;
        for (Products product : list) {
            writer.write(product.getProductString());
            if (++countRN < list.size()) writer.newLine();
        }
        writer.close();
    }

    private static Products productFromLine(String str){
        String id = str.substring(0,8).trim();
        String productName = str.substring(8, 38).trim();
        String price = str.substring(38, 46).trim();
        String quantity = str.substring(46);
        Products product = new Products(id, productName, price, quantity);
        return product;
    }

    private static void create() throws IOException {
        validArgs = true;
        Products product = new Products(getMaxId() + 1, argsArray[1], argsArray[2], argsArray[3]);
        list.add(product);
        listToFile();
    }

    private static void updateString() throws IOException {
        validArgs = true;
        int index = getIdInList();
        if (index != -1){
            list.get(index).updateProduct(argsArray[2], argsArray[3], argsArray[4]);
        } else {
            System.out.println("Невозможно обновить - такой элемент не найден!");
        }
        listToFile();
    }

    private static void deleteString() throws IOException {
        validArgs = true;
        int index = getIdInList();
        if (index != -1){
            list.remove(index);
        } else {
            System.out.println("Невозможно удалить - такой элемент не найден!");
        }
        listToFile();
    }

    private static int getIdInList() {
        int listId = -1;
        for (Products product : list) {
            int  indexArg = Integer.parseInt(argsArray[1].trim());
            int  indexListProduct = product.getId();
            if (indexArg == indexListProduct) {
                listId = list.indexOf(product);
                break;
            }
        }
        return listId;
    }

    private static int getMaxId(){
        int maxID = 0;
        for (Products product : list){
            if (product.getId() > maxID) maxID = product.getId();
        }
        return maxID;
    }
}
