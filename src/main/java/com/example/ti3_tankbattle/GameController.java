package com.example.ti3_tankbattle;

import com.example.ti3_tankbattle.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    //Variables globales
    private GraphicsContext gc;
    private Avatar avatar;
    private Avatar avatar2;
    private Avatar cpu;
    private ArrayList<Wall> walls;
    private ArrayList<Avatar> players;
    private Boolean isRuning = true;
    private Random rnd;

    //Estados de las teclas
    boolean Wpressed = false;
    boolean Apressed = false;
    boolean Spressed = false;
    boolean Dpressed = false;

    boolean Uppressed = false;
    boolean Leftpressed = false;
    boolean Downpressed = false;
    boolean Rightpressed = false;
    @FXML
    private Canvas canvas;

    @FXML
    private Label P1_Label;

    @FXML
    private Label P2_Label;

    @FXML
    private Label cpu_Label;
    @FXML
    private Circle P1V1;

    @FXML
    private Circle P1V2;

    @FXML
    private Circle P1V3;

    @FXML
    private Circle P1V4;

    @FXML
    private Circle P1V5;
    @FXML
    private Circle P2V1;

    @FXML
    private Circle P2V2;

    @FXML
    private Circle P2V3;

    @FXML
    private Circle P2V4;

    @FXML
    private Circle P2V5;
    @FXML
    private Circle PCV1;

    @FXML
    private Circle PCV2;

    @FXML
    private Circle PCV3;

    @FXML
    private Circle PCV4;

    @FXML
    private Circle PCV5;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(this::inKeyPressed);
        canvas.setOnKeyReleased(this::onKeyReleased);
        canvas.setOnMouseClicked(this::onMouseClicked);

        System.out.println(PlayerNames.getInstance().getNameP2());
        System.out.println(PlayerNames.getInstance().getNameP1());

        P2_Label.setText(PlayerNames.getInstance().getNameP2());
        P1_Label.setText(PlayerNames.getInstance().getNameP1());

        avatar = new Avatar(canvas, 75 , 250, "tank.png", "avatar1", PlayerNames.getInstance().getNameP1()); // se crea el avatar
        avatar2 = new Avatar(canvas, 150, 175, "tank1.png", "avatar2", PlayerNames.getInstance().getNameP2());
        cpu = new Avatar(canvas, 45, 45, "tank2.png", "cpu", "CPU");
        rnd = new Random();

        walls = new ArrayList<>();
        players = new ArrayList<>();
        players.add(avatar);
        players.add(avatar2);
        players.add(cpu);
        Wall wall1 = new Wall(canvas, 210,150,"wall.png");
        Wall wall2 = new Wall(canvas, 250,150,"wall.png");
        walls.add(wall2);
        walls.add(wall1);

        draw();

        //Para lo de cambiar los nombres de los labels
        //static_P1_Label = P1_Label;
        //static_P2_Label = P2_Label;
        //static_CPU_Label = cpu_Label;

    }


    private void onKeyReleased(KeyEvent keyEvent) {

        if (keyEvent.getCode() == KeyCode.W) {
            Wpressed = false;
        }
        if (keyEvent.getCode() == KeyCode.A) {
            Apressed = false;
        }
        if (keyEvent.getCode() == KeyCode.S) {
            Spressed = false;
        }
        if (keyEvent.getCode() == KeyCode.D) {
            Dpressed = false;
        }
        if (keyEvent.getCode() == KeyCode.UP) {
            Uppressed = false;
        }
        if (keyEvent.getCode() == KeyCode.LEFT) {
            Leftpressed = false;
        }
        if (keyEvent.getCode() == KeyCode.DOWN) {
            Downpressed = false;
        }
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            Rightpressed = false;
        }

    }

    private void inKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.R) {avatar2.setAmmunition(10);}
        if (keyEvent.getCode() == KeyCode.M) {avatar.setAmmunition(10);}
        if (keyEvent.getCode() == KeyCode.W) {Wpressed = true;}
        if (keyEvent.getCode() == KeyCode.A) {Apressed = true;}
        if (keyEvent.getCode() == KeyCode.S) {Spressed = true;}
        if (keyEvent.getCode() == KeyCode.D) {Dpressed = true;}
        if (keyEvent.getCode() == KeyCode.UP) {Uppressed = true;}
        if (keyEvent.getCode() == KeyCode.LEFT) {Leftpressed = true;}
        if (keyEvent.getCode() == KeyCode.DOWN) {Downpressed = true;}
        if (keyEvent.getCode() == KeyCode.RIGHT) {Rightpressed = true;}
        if (keyEvent.getCode() == KeyCode.X) {

            for (Avatar player : players) {

                if (player.name.equalsIgnoreCase("avatar1")) {

                    if (player.getAmmunition() < 1) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("WARNING");
                        alert.setContentText("PLAYER " + player.name + " RELOAD")  ;
                        alert.setHeaderText("WARNING");
                        alert.showAndWait();
                    } else {

                        Bullet bullet = new Bullet(canvas, new Vector(player.pos.x, player.pos.y), new Vector(5 * player.direction.x, 5 * player.direction.y));
                        player.bullets.add(bullet);
                        player.setAmmunition(player.getAmmunition() - 1);
                    }

                }

            }
        }
        if (keyEvent.getCode() == KeyCode.SPACE) {

            for (Avatar player : players) {

                if (player.name.equalsIgnoreCase("avatar2")) {

                    if (player.getAmmunition() < 1) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("WARNING");
                        alert.setContentText("PLAYER " + player.name + " RELOAD")  ;
                        alert.setHeaderText("WARNING");
                        alert.showAndWait();

                    } else {

                        Bullet bullet = new Bullet(canvas, new Vector(player.pos.x, player.pos.y), new Vector(5 * player.direction.x, 5 * player.direction.y));
                        player.bullets.add(bullet);
                        player.setAmmunition(player.getAmmunition() - 1);
                    }

                }

            }
        }

    }

    public void drawWalls(){
        walls.get(0).drawWall(250,150, 40,40);
        walls.get(1).drawWall(210,150,40,40);
    }

    public void doKeyBoardAction(){
        if (Wpressed) {

            //avatar.moveVertical(-3);
            avatar.moveForward();
        }
        if (Apressed) {
            //avatar.moveHorizontal(-3);
            avatar.changeAngle(-15);
        }
        if (Spressed) {
            //avatar.moveVertical(3);
            avatar.moveReverse();
        }
        if (Dpressed) {
            //avatar.moveHorizontal(3);
            avatar.changeAngle(15);
        }
        if (Uppressed) {
            //avatar.moveVertical(-3);
            avatar2.moveForward();
        }
        if (Leftpressed) {
            //avatar.moveHorizontal(-3);
            avatar2.changeAngle(-15);
        }
        if (Downpressed) {
            //avatar.moveVertical(3);
            avatar2.moveReverse();
        }
        if (Rightpressed) {
            //avatar.moveHorizontal(3);
            avatar2.changeAngle(15);
        }
    }

    private void detectShoot () {

        for (int j = 0; j < players.size(); j++) {
            for (int i = 0; i < players.get(j).bullets.size(); i++) {
                Avatar a = null;
                Bullet b = players.get(j).bullets.get(i);
                for (int e = 0; e < players.size(); e++) {
                    System.out.println(e);
                    if  (!players.get(e).name.equalsIgnoreCase(players.get(j).name)) {
                        a = players.get(e);

                        double c1 = b.pos.x - a.x;
                        double c2 = b.pos.y - a.y;

                        double distance = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
                        if (distance < 35) {
                            players.get(j).bullets.remove(i);
                            players.get(e).setLifePoints(a.getLifePoints() - 1);
                            if (players.get(e).name.equalsIgnoreCase("avatar1")) {
                                if (players.get(e).getLifePoints() == 4) {
                                    P1V1.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 3) {
                                    P1V2.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 2) {
                                    P1V3.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 1) {
                                    P1V4.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 0) {
                                    P1V5.setFill(Color.BLACK);
                                }
                            }
                            if (players.get(e).name.equalsIgnoreCase("avatar2")) {
                                if (players.get(e).getLifePoints() == 4) {
                                    P2V1.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 3) {
                                    P2V2.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 2) {
                                    P2V3.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 1) {
                                    P2V4.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 0) {
                                    P2V5.setFill(Color.BLACK);
                                }
                            }
                            if (players.get(e).name.equalsIgnoreCase("cpu")) {
                                if (players.get(e).getLifePoints() == 4) {
                                    PCV1.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 3) {
                                    PCV2.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 2) {
                                    PCV3.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 1) {
                                    PCV4.setFill(Color.BLACK);
                                }
                                if (players.get(e).getLifePoints() == 0) {
                                    PCV5.setFill(Color.BLACK);
                                }
                            }
                            if (players.get(e).getLifePoints() < 1) {
                                players.remove(e);
                            }
                            return;

                        }
                    }
                }

                for (int q = 0; q < walls.size(); q ++) {

                    Wall w = walls.get(q);

                    double c1 = b.pos.x - w.x-20;
                    double c2 = b.pos.y - w.y-20;

                    double distance = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
                    if (distance < 30) {
                        players.get(j).bullets.remove(i);
                    }

                }
            }
        }
    }

    public void detectWallCollision () {

        for (int i = 0; i < players.size(); i ++) {

            for (int j = 0; j < walls.size(); j ++) {

                Avatar a = players.get(i);
                Wall w = walls.get(j);

                double c1 = a.pos.x - w.x-20;
                double c2 = a.pos.y - w.y-20;

                double distance = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
                if (distance < 30) {
                    System.out.println("MUEVE COLISION M");
                    players.get(i).setPosition(players.get(i).pos.x-1, players.get(i).pos.y-1);
                }

            }

        }

    }
    public void detectBroderCollision () {

        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).pos.x > canvas.getWidth()) {
                players.get(i).setPosition(players.get(i).pos.x-3, players.get(i).pos.y);
                System.out.println("POS X DE WI: " + players.get(i).pos.x);
            }
            if (players.get(i).pos.y > canvas.getHeight()) {
                players.get(i).setPosition(players.get(i).pos.x, players.get(i).pos.y-3);
                System.out.println("POS Y DE HE: " + players.get(i).pos.y);
            }
            if (players.get(i).pos.y < 3) {
                players.get(i).setPosition(players.get(i).x, players.get(i).y+3);
                System.out.println("POS Y DE Y : " + players.get(i).pos.y);
            }
            if(players.get(i).pos.x < 3) {
                players.get(i).setPosition(players.get(i).x +3, players.get(i).y);
                System.out.println("POS X DE X: " + players.get(i).pos.x);
            }
        }
    }

    private void onMouseClicked(MouseEvent mouseEvent) {
        System.out.println("pos X: " + mouseEvent.getX());
        System.out.println("pos Y: " + mouseEvent.getY());

    }

    public void draw() {
        new Thread(
                () -> {
                    while (isRuning) {
                        //Dibujo
                        Platform.runLater(
                                () -> {
                                    gc.setFill(Color.BLACK);
                                    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                                    drawWalls();

                                    for (Avatar player : players) {player.draw();}

                                    for (Avatar player : players) {

                                        for (int i = 0; i < player.bullets.size(); i++) {

                                            player.bullets.get(i).draw();
                                            if (player.bullets.get(i).pos.x > canvas.getWidth() + 20 ||
                                                    player.bullets.get(i).pos.y > canvas.getHeight() + 20 ||
                                                    player.bullets.get(i).pos.y < -20 ||
                                                    player.bullets.get(i).pos.x < -20) {
                                                player.bullets.remove(i);
                                            }

                                        }

                                    }

                                    doKeyBoardAction();

                                });

                        // Collision
                        detectShoot();
                        detectWallCollision();
                        detectBroderCollision();
                        //comprobarWinner();

                        //sleep
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        ).start(); //Se debe poner el start para que lo que esté en draw funcione
    }

    /*
    void comprobarWinner() {
        Stage currentStage = null;
        if (players.size() == 1) {
            currentStage = (Stage) P1_Label.getScene().getWindow();
            if (players.get(0) != null) {

                if (players.get(0).getId().equalsIgnoreCase(PlayerNames.getInstance().getNameP1())) {
                    PlayerNames.getInstance().setWinnner1(1);
                }
                if (players.get(0).getId().equalsIgnoreCase(PlayerNames.getInstance().getNameP2())) {
                    PlayerNames.getInstance().setWinner2(1);
                }

            }

            Application.showWindow("Puntajes.fxml");
            currentStage.hide();

        }

    }

     */

}

