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
    private int winnner1 = 0;
    private int winner2 = 0;

    public int getWinner2() {
        return winner2;
    }

    public void setWinner2(int winner2) {
        this.winner2 = winner2;
    }

    public int getWinnner1() {
        return winnner1;
    }

    public void setWinnner1(int winnner1) {
        this.winnner1 = winnner1;
    }

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
