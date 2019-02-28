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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        allLines = Files.readAllLines(Paths.get(sc.nextLine()));
        forRemoveLines = Files.readAllLines(Paths.get(sc.nextLine()));
        sc.close();

        new Solution().joinData();
    }

    public void joinData() throws CorruptedDataException {
        if (!allLines.containsAll(forRemoveLines)){
            allLines.clear();
            throw new CorruptedDataException();
        } else {
            allLines.removeAll(forRemoveLines);
        }

    }
}
