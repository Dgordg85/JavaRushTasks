package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    @Override
    public synchronized int compareTo(Beach o) {
        //return (quality - o.getQuality()) + (int)(distance - o.getDistance());
        return (quality - o.getQuality()) + (int)(o.getDistance() - distance);
    }

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach one = new Beach("Аякс", 2.3f, 10);
        Beach two = new Beach("Аякс", 0.5f, 7);
        Beach three = new Beach("Аякс", 1.0f, 8);

        System.out.println(one.compareTo(two));
        System.out.println(one.compareTo(three));
        System.out.println(two.compareTo(three));
    }
}
