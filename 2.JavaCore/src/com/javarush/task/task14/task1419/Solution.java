package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> list = new ArrayList<>();
            System.out.println(list.get(2));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream stream = new FileInputStream("C:/1/57.txt");
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            Float fl = null;
            fl.isNaN();
        }catch (Exception e) {
            exceptions.add(e);
        }

        try{
            String[] arr = new String[5];
            String elem = "5";
            if (elem instanceof String) throw new IllegalAccessException();
            else arr[2] = elem;
        } catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new IllegalMonitorStateException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new IllegalStateException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new IllegalThreadStateException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new SecurityException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new NegativeArraySizeException();
        }catch (Exception e){
            exceptions.add(e);
        }

    }
}
