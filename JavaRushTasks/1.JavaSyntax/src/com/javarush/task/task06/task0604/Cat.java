package com.javarush.task.task06.task0604;

/* 
Ставим котов на счётчик
*/

public class Cat {
    public static int catCount = 0;

    public Cat(){
        catCount++;
    }

    @Override
    protected void finalize(){
        catCount--;
    }

    public static void main(String[] args) {

    }
}