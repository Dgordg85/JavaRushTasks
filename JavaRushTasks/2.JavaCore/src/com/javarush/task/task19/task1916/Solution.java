package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader = new BufferedReader(new FileReader("C:/1/1.txt"));
        String str;
        while ((str = reader.readLine()) != null){
            System.out.println(str);
        }
       // BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
       // reader.close();
        //BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));


        //List<String> fileList1 = fileToList(file1);

//        String str;
//        while(file1.ready()){
//            System.out.println(file1.readLine());
//        }
//        file1.close();
       // List<String> fileList2 = fileToList(file2);

      //  compareAndAddStrings(fileList1, 0, fileList2, 0);
    }

    private static void compareAndAddStrings(List<String> fileList1, int pos1, List<String> fileList2, int pos2){
        if (fileList1.get(pos1).equals(fileList2.get(pos2))){
            compareAndAddStrings(fileList1, pos1 + 1, fileList2, pos2 + 1);
        } else if (fileList1.get(pos1).equals(fileList2.get(pos2 + 1))){
            fileList1.add(pos1, "");
        } else if (fileList2.get(pos2).equals(fileList1.get(pos1 + 1))){
            fileList2.add(pos2, "");
        }
    }



    private static List<String> fileToList(BufferedReader file) throws IOException {
        List<String> fileList = new ArrayList<>();
        String str;
        while((str = file.readLine()) != null){
            fileList.add(str);
        }
        return fileList;
    }


    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
