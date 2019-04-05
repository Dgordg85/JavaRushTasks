package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("C:/1/1.txt");
        sol.writeObject("Записываем данные");
        sol.writeObject("Дозапишем данные - у нас же метод flush а не close в writeObject");

        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream("C:/1/save.bin"));
        streamOut.writeObject(sol);
        sol.close();
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream("C:/1/save.bin"));
        Solution sol2 = (Solution) streamIn.readObject();
        sol2.writeObject("Данные нового потока.");
        sol2.close();
        streamIn.close();

    }
}
