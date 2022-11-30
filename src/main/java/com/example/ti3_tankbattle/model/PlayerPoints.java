package com.example.ti3_tankbattle.model;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerPoints {

    private String Username;
    private int Score;

    public PlayerPoints(String username, int score) {
        Username = username;
        Score = score;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

}
