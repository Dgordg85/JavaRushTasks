package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends ArithmeticException {
    }

    static class MyException2 extends ArrayIndexOutOfBoundsException {
    }

    static class MyException3 extends IOException {
    }

    static class MyException4 extends FileNotFoundException {
    }
}

