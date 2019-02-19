package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import java.lang.reflect.Field;

public class Solution {

    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;



    public static void main(String[] args) throws IllegalAccessException {
        Solution sol = new Solution();
        for(Field field : sol.getClass().getDeclaredFields()){
            System.out.println(field.get(sol));
        }
    }
}
