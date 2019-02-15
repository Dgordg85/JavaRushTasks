package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg = new Zerg();
        zerg.name = "Name 1";

        Zerg zerg2 = new Zerg();
        zerg2.name = "Name 2";

        Zerg zerg3 = new Zerg();
        zerg3.name = "Name 3";

        Zerg zerg4 = new Zerg();
        zerg4.name = "Name 4";

        Zerg zerg5 = new Zerg();
        zerg5.name = "Name 5";

        Protoss protoss = new Protoss();
        protoss.name = "Name 1";

        Protoss protoss2 = new Protoss();
        protoss2.name = "Name 2";

        Protoss protoss3 = new Protoss();
        protoss3.name = "Name 3";

        Terran terran = new Terran();
        terran.name = "Name 1";

        Terran terran2 = new Terran();
        terran2.name = "Name 2";

        Terran terran3 = new Terran();
        terran3.name = "Name 3";

        Terran terran4 = new Terran();
        terran4.name = "Name 4";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
