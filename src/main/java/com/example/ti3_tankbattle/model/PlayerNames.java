package com.example.ti3_tankbattle.model;

public class PlayerNames {

    public static PlayerNames instance;

    public static PlayerNames getInstance () {

        if (instance == null) {

            instance = new PlayerNames();

        }
        return instance;

    }

    private String nameP1 = "";
    private String nameP2 = "";

    public static void setInstance(PlayerNames instance) {
        PlayerNames.instance = instance;
    }

    public String getNameP1() {
        return nameP1;
    }

    public void setNameP1(String nameP1) {
        this.nameP1 = nameP1;
    }

    public String getNameP2() {
        return nameP2;
    }

    public void setNameP2(String nameP2) {
        this.nameP2 = nameP2;
    }
}
