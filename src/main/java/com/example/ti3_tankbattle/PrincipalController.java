package com.example.ti3_tankbattle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
    @FXML
    private TextField p2TextField;

    @FXML
    private TextField cpuTextField;

    @FXML
    private TextField p1TextField;

    @FXML
    void Start(ActionEvent event) {
        Application.showWindow("game.fxml");
        Stage currentStage = (Stage) p1TextField.getScene().getWindow();
        //currentStage.hide();

        //Para lo de cambiar los nombres de los labels
        //static_P1_Label.setText(p1TextField.getText());
        //static_P2_Label.setText(p2TextField.getText());
        //static_CPU_Label.setText(cpuTextField.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}