package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.*;

public class Solution {

    private static List<Integer> list = genListSimpleNumber();


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nod = 1;


        int firstNumber = Integer.parseInt(sc.nextLine());
        int secondNumber = Integer.parseInt(sc.nextLine());

        List<Integer> firstNumberList = getNOD(firstNumber);
        List<Integer> secondNumberList = getNOD(secondNumber);

        if (firstNumber < 1 || secondNumber < 1) throw new NumberFormatException();

        Iterator<Integer> iterator = firstNumberList.iterator();

        while (iterator.hasNext()){
            Integer num = iterator.next();
            if (secondNumberList.contains(num)){
                nod *= num;
                iterator.remove();
                secondNumberList.remove(num);
            }
        }
        System.out.println(nod);


    }

    //Получаем все множители числа
    private static List<Integer> getNOD(Integer num){
        List<Integer> numberList = new ArrayList<>();
        while (num > 1){
            for (int i = 0; i < list.size() ; i++) {
                int currentNum = list.get(i);
                if (num % currentNum == 0) {
                    numberList.add(currentNum);
                    num = num / currentNum;
                }
            }
        }
        Collections.sort(numberList);
        return numberList;
    }

    //Генерируем лист простых чисел
    private static List<Integer> genListSimpleNumber(){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 10000; i++) {
            Boolean isNumberSimple = true;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) isNumberSimple = false;
            }
            if (isNumberSimple == true) list.add(i);
        }
        return list;
    }


}
