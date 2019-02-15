package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Human grandMa1 = new Human();
        grandMa1.name = "Зоя";
        grandMa1.sex = false;
        grandMa1.age = 93;

        Human grandPa1 = new Human();
        grandPa1.name = "Тимофей";
        grandPa1.sex = true;
        grandPa1.age = 92;

        Human grandMa2 = new Human();
        grandMa2.name = "Женя";
        grandMa2.sex = false;
        grandMa2.age = 78;

        Human grandPa2 = new Human();
        grandPa2.name = "Иван";
        grandPa2.sex = true;
        grandPa2.age = 82;

        Human mother = new Human();
        mother.name = "Катя";
        mother.sex = false;
        mother.age = 61;

        Human father = new Human();
        father.name = "Вася";
        father.sex = true;
        father.age = 52;

        Human son1 = new Human();
        son1.name = "Саша";
        son1.sex = true;
        son1.age = 30;

        Human son2 = new Human();
        son2.name = "Андрей";
        son2.sex = true;
        son2.age = 25;

        Human daughter = new Human();
        daughter.name = "Юля";
        daughter.sex = false;
        daughter.age = 37;

        List<Human> humans = new ArrayList<>(Arrays.asList(grandMa1, grandMa2, grandPa1, grandPa2, mother, father, son1, son2, daughter));

        grandMa1.children = new ArrayList<>(Collections.singletonList(mother));
        grandPa1.children = new ArrayList<>(Collections.singletonList(mother));
        grandMa2.children = new ArrayList<>(Collections.singletonList(father));
        grandPa2.children = new ArrayList<>(Collections.singletonList(father));
        mother.children = new ArrayList<>(Arrays.asList(son1, son2, daughter));
        father.children = new ArrayList<>(Arrays.asList(son1, son2, daughter));

        for (Human hm : humans){
            System.out.println(hm);
        }

    }

    public static class Human {
        public String  name;
        public Boolean sex;
        public int age;
        public ArrayList<Human> children;


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.children != null){
                int childCount = this.children.size();
                if (childCount > 0) {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++) {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }
            }
            return text;
        }
    }

}
