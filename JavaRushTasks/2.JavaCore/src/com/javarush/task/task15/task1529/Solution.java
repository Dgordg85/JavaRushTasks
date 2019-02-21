package com.javarush.task.task15.task1529;

import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
       reset();
    }

    public static CanFly result;

    public static void reset() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (str.equals("helicopter")){
            result = new Helicopter();
        } else if (str.equals("plane")){
            int passengers = Integer.parseInt(sc.nextLine());
            result = new Plane(passengers);
        }
        sc.close();
    }
}
