package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        Scanner sc = new Scanner(System.in);
        firstFileName = sc.nextLine();
        secondFileName = sc.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private BufferedReader file;
        private String str = "";

        @Override
        public void setFileName(String fullFileName) {
            try {
                file = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName), "UTF-8"));
            } catch (Exception e) {}
        }

        @Override
        public String getFileContent() {
            return str;
        }

        @Override
        public void run() {
            try {
                while(file.ready()){
                    str += file.readLine() + " ";
                }
            }catch (IOException e) { }
        }
    }

}
