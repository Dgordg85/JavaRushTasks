package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }

    public QuestionFileOutputStream() {
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().equals("Д")) component.close();
    }

    public static void main(String[] args) throws IOException {
        AmigoOutputStream obj = new QuestionFileOutputStream();
        QuestionFileOutputStream writer = new QuestionFileOutputStream(obj);
        writer.close();
    }
}