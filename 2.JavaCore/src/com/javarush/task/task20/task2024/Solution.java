package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol2 = new Solution();
        sol2.node = 7;

        Solution sol3 = new Solution();
        sol3.node = 10;

        Solution sol = new Solution();
        sol.node = 3;
        sol.edges.add(sol2);
        sol.edges.add(sol3);

        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream("C:/1/1.bin"));
        streamOut.writeObject(sol);
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream("C:/1/1.bin"));
        Solution newSol = (Solution) streamIn.readObject();
        System.out.println(newSol.node);
        System.out.println(newSol.edges.get(0).node);
        System.out.println(newSol.edges.get(1).node);



    }
}
