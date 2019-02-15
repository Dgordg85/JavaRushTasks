package com.javarush.task.task14.task1408;

abstract class Hen implements Country{
    abstract int getCountOfEggsPerMonth();

    String getDescription(){
        return "Я - курица.";
    }
}