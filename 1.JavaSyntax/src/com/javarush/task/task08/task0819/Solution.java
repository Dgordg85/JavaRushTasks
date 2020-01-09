package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> iterator = cats.iterator();
        cats.remove(iterator.next());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();
            cats.add(new Cat());
            cats.add(new Cat());
            cats.add(new Cat());
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        Iterator<Cat> iterator = cats.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

}

    public static class Cat{
        public Cat(){
        }
    }
}
