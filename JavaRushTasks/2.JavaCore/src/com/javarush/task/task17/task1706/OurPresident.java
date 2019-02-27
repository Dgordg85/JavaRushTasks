package com.javarush.task.task17.task1706;


public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (OurPresident.class){
            if (president == null){
                president = new OurPresident();
            }
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }

}
