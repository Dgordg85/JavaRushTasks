package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object object = objectStream.readObject();
            String className = object.getClass().getSimpleName();
            if (className.equals("B")) throw new Exception();
            return (A) object;
        } catch (Exception e) {
            return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    private void test(Object classAB) throws IOException {
        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream("C:/1/3.bin"));
        streamOut.writeObject(classAB);
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream("C:/1/3.bin"));
        Object object = new Solution().getOriginalObject(streamIn);
        streamIn.close();

        System.out.println(object);
    }

    public static void main(String[] args) throws IOException {
        //Тест B класса
        B b = new Solution(). new B();
        new Solution().test(b);

        A a = new Solution(). new A();
        new Solution().test(a);
    }
}
