package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static  Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        Horse one = new Horse("Slevin", 3d, 0d);
        Horse two = new Horse("Lucky", 3d, 0d);
        Horse three = new Horse("Homer", 3d, 0d);
        game.getHorses().add(one);
        game.getHorses().add(two);
        game.getHorses().add(three);
        game.run();
        game.printWinner();

    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            this.move();
            this.print();
            Thread.sleep(200);
        }
    }

    public void move(){
        horses.forEach(Horse::move);
    }

    public void print(){
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        double maxDistance = 0;
        Horse result = null;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > maxDistance){
                maxDistance = horses.get(i).getDistance();
                result = horses.get(i);
            }
        }
        return result;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
}


}
