package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import javax.sound.midi.Soundbank;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        String numStr = "отрицательное ";
        if (a == 0) {
            numStr = "ноль";
        } else if (a > 0) {
            numStr = "положительное ";
        }

        if (a % 2 == 0 && a != 0) {
            numStr += "четное число";
        } else if (a != 0){
            numStr += "нечетное число";
        }

        System.out.println(numStr);
    }
}
