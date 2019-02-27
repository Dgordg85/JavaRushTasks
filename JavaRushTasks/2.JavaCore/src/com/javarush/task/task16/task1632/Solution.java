package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Infinity());
        threads.add(new Except());
        threads.add(new SayUra());
        threads.add(new UseMessage());
        threads.add(new ReadConsole());
    }

    public static void main(String[] args) {
        Thread t = threads.get(1);
        t.start();
        t.interrupt();



       /* UseMessage t = (UseMessage) threads.get(3);

        t.start();
        System.out.println(t.isAlive());
        t.showWarning();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(t.isAlive()); */

    }

    public static class Infinity extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class Except extends Thread{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1500);
                }catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class SayUra extends Thread{
        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        }
    }

    public static class UseMessage extends Thread implements Message{
        @Override
        public void run() {
            while(!isInterrupted()){
            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }


    public static class ReadConsole extends Thread{
        private String str;
        private int sum;

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (!isInterrupted()){
                try{
                    if (reader.ready()){
                        str = reader.readLine();
                        if (!str.equals("N")){
                            sum += Integer.parseInt(str);
                        } else {
                            System.out.println(sum);
                            break;
                        }
                    }
                } catch (Exception e){}
            }
        }
    }


}