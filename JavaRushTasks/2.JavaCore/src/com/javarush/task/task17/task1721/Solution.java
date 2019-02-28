package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> forRemoveLines = new ArrayList<>();

    public static void main(String[] args) throws CorruptedDataException {
        readFile(allLines);
        readFile(forRemoveLines);
        new Solution().joinData();
    }

    private static void readFile(List<String> list){
        Scanner sc = new Scanner(System.in);
        try {
           list = Files.readAllLines(Paths.get(sc.nextLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

            while (fileReader.ready()) list.add(fileReader.readLine());
        } catch (IOException e){}*/
    }

    public void joinData() throws CorruptedDataException {
        if (!allLines.containsAll(forRemoveLines)){
            allLines.clear();
            throw new CorruptedDataException();
        } else {
            //forRemoveLines.forEach((String str) -> allLines.remove(str));
            allLines.removeAll(forRemoveLines);
        }

    }
}
