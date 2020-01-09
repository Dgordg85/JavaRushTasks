package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    private int passengers;
    @Override
    public void fly() {

    }

    public Plane(int passengers){
        this.passengers = passengers;
    }
}
