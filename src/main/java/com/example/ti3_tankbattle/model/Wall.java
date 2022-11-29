package com.example.ti3_tankbattle.model;

import com.example.ti3_tankbattle.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Wall {

    private Canvas canvas;
    private GraphicsContext gc;
    public int x,y;
    private String uri;

    public Wall(Canvas canvas, int x, int y, String imagePath){
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        uri = "file:"+ Application.class.getResource(imagePath).getPath();
        this.x = x;
        this.y = y;
    }

    public void drawWall(double x, double y, double w, double h){gc.drawImage(new Image(uri),x,y,w,h);}

}