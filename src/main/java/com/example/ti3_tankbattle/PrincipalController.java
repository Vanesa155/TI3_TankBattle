package com.example.ti3_tankbattle;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.ti3_tankbattle.model.PlayerNames;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrincipalController extends GameController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cpuTextField;

    @FXML
    private TextField p1TextField;

    @FXML
    private TextField p2TextField;

    @FXML
    private Button start_Button;

    @FXML
    void Start(ActionEvent event) {

        Stage currentStage = (Stage) p1TextField.getScene().getWindow();
        currentStage.hide();

        //Para lo de cambiar los nombres de los labels

        PlayerNames.getInstance().setNameP1(p1TextField.getText());
        PlayerNames.getInstance().setNameP2(p2TextField.getText());

        System.out.println(p1TextField.getText());
        System.out.println(p2TextField.getText());
        Application.showWindow("game.fxml");

    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}




