package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            if (this.getClass().equals(B.class)) throw new CloneNotSupportedException();
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            B b = (B) o;

            return name != null ? name.equals(b.name) : b.name == null;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) {
        try {
            A a = new A(23, 35);
            A cloneA = (A) a.clone();
            System.out.println(a);
            System.out.println(cloneA);
            System.out.println(a.equals(cloneA));
        } catch (CloneNotSupportedException e) {
            System.out.println("Класс A не поддерживает клонирование");
        }
        System.out.println("======================");
        try {
            B b = new B(17, 47, "IDEA");
            B cloneB = (B) b.clone();
            System.out.println(b);
            System.out.println(cloneB);
            System.out.println(b.equals(cloneB));
        } catch (CloneNotSupportedException e) {
            System.out.println("Класс В не поддерживает клонирование");
        }
        try {
            System.out.println("======================");
            C c = new C(90, 67, "NORMAL");
            C cloneC = (C) c.clone();
            System.out.println(c);
            System.out.println(cloneC);
            System.out.println(c.equals(cloneC));
        } catch (CloneNotSupportedException e) {
            System.out.println("Класс С не поддерживает клонирование");
        }
    }
}
