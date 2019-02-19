package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(){
        System.out.println("Заполняем объектами String");
        printMatrix(10, 10, (Object) "#");
    }

    public static void printMatrix(int m){
        System.out.println("Заполняем объектами String");
        printMatrix(m, 10, (Object) "#");
    }

    public static void printMatrix(int m, String value){
        System.out.println("Заполняем объектами String");
        printMatrix(m, 10, (Object) value);
    }

    public static void printMatrix(String value, int m){
        System.out.println("Заполняем объектами String");
        printMatrix(10, m, (Object) value);
    }

    public static void printMatrix(int m, int n){
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) "#");
    }

    public static void printMatrix(Integer m, Integer n, String value){
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(Integer m, Integer n){
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) "#");
    }


    public static void printMatrix(Integer m, String value){
        System.out.println("Заполняем объектами String");
        printMatrix(m, 10, (Object) value);
    }

}
