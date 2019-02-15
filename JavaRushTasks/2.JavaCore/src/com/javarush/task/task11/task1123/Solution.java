package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        Pair<Integer, Integer> pair = new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);

        if (inputArray == null || inputArray.length == 0) {
            pair.x = null;
            pair.y = null;
            return pair;
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > pair.y) {
                pair.y = inputArray[i];
            }
            else if (inputArray[i] < pair.x){
                pair.x = inputArray[i];
            }
        }
        return pair;
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
