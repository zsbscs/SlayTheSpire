package com.example.map;

public class file {
    private static int ID;

    private static String money;

    private static String health;

    private static int layer1ID;

    public static String getMoney() {
        return money;
    }

    public static void setMoney(String money) {
        file.money = money;
    }

    public static String getHealth() {
        return health;
    }

    public static void setHealth(String health) {
        file.health = health;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        file.ID = ID;
    }

    public static int getLayer1ID() {
        return layer1ID;
    }

    public static void setLayer1ID(int layer1ID) {
        file.layer1ID = layer1ID;
    }
}
