package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int b = (byte) a + 46;

        byte b1 = (byte) -1;
        byte b2 = (byte) -2;
        String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
        String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s1);
        System.out.println(s2);


        byte c = (byte) (a * b);
        double f = (char) 1234.15;
        long d = (long)(a + f / c + b);
        String s = Long.toBinaryString(d);
        System.out.println(s);
    }
}
