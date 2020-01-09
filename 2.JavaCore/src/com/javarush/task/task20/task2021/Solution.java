package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream stream) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream stream) throws NotSerializableException {
            throw new NotSerializableException();
        }


    }

    public static void main(String[] args) {

    }
}
