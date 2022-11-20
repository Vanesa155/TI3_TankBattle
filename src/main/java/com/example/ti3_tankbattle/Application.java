package com.example.ti3_tankbattle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TankBattle!!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showWindow(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    Application.class.getResource(fxml)
            );
            Parent node = fxmlLoader.load();
            Scene scene = new Scene(node);
            Stage window = new Stage();
            window.setScene(scene);
            window.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}