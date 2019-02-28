package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

            while (fileReader.ready()) list.add(fileReader.readLine());
        } catch (IOException e){}
    }

    public void joinData() throws CorruptedDataException {
        if (!allLines.containsAll(forRemoveLines)){
            allLines.clear();
            throw new CorruptedDataException();
        } else {
            forRemoveLines.forEach((String str) -> allLines.remove(str));
        }

    }
}
