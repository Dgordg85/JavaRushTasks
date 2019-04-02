package com.javarush.task.task20.task2006;

import com.sun.corba.se.impl.io.InputStreamHook;
import com.sun.corba.se.impl.io.OutputStreamHook;
import com.sun.corba.se.pept.encoding.OutputObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
*/
public class Solution {
    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream("C:/1/1.bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Human oleg = new Human();
        Asset car = new Asset("Nissan Qashqai");
        car.setPrice(1.55);
        oleg.assets.add(car);

        outputStream.writeObject(oleg);

        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:/1/1.bin");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object object = inputStream.readObject();
        inputStream.close();

        Human newHuman = (Human) object;
    }
}
