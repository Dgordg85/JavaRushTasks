package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human petya = new Human("Петя",true,20);
        Human andrey = new Human("Андрей",true,25);
        Human yulya = new Human("Юля",false,37);
        Human kate = new Human("Катя",false,15);
        Human vova = new Human("Вова",true,7,andrey, yulya);
        Human john = new Human("Джон",true,3,andrey, yulya);
        Human zihr = new Human("Зихр",true,2,petya, kate);
        Human vahr = new Human("Вахр",true,8,petya, kate);
        Human bam = new Human("Бам",true,8,petya, kate);

        System.out.println(petya.toString());
        System.out.println(andrey.toString());
        System.out.println(yulya.toString());
        System.out.println(kate.toString());
        System.out.println(vova.toString());
        System.out.println(john.toString());
        System.out.println(zihr.toString());
        System.out.println(vahr.toString());
        System.out.println(bam.toString());

    }

    public static class Human {
        String name;
        Human father, mother;
        boolean sex;
        int age;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}