package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        for (Apartment apart : apartments){
            if (apart instanceof OneRoomApt){
                ((OneRoomApt) apart).clean1Room();
            }else if (apart instanceof TwoRoomApt){
                ((TwoRoomApt) apart).clean2Rooms();
            } else if (apart instanceof ThreeRoomApt){
                ((ThreeRoomApt) apart).clean3Rooms();
            }
            /*switch (apart.getClass().getSimpleName()){
                case "OneRoomApt":
                    ((OneRoomApt) apart).clean1Room();
                    break;
                case "TwoRoomApt":
                    ((TwoRoomApt) apart).clean2Rooms();
                    break;
                case "ThreeRoomApt":
                    ((ThreeRoomApt) apart).clean3Rooms();
                    break;
            }*/
        }
    }

    interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
