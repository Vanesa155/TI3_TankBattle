package com.example.ti3_tankbattle;

import java.net.URL;
import java.util.ResourceBundle;
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
        Application.showWindow("game.fxml");
        Stage currentStage = (Stage) p1TextField.getScene().getWindow();
        currentStage.hide();

        //Para lo de cambiar los nombres de los labels

        //static_P1_Label.setText(p1TextField.getText());
        //static_P2_Label.setText(p2TextField.getText());
        //static_CPU_Label.setText(cpuTextField.getText());


    }

    @FXML
    void initialize() {
        assert cpuTextField != null : "fx:id=\"cpuTextField\" was not injected: check your FXML file 'Principal.fxml'.";
        assert p1TextField != null : "fx:id=\"p1TextField\" was not injected: check your FXML file 'Principal.fxml'.";
        assert p2TextField != null : "fx:id=\"p2TextField\" was not injected: check your FXML file 'Principal.fxml'.";
        assert start_Button != null : "fx:id=\"start_Button\" was not injected: check your FXML file 'Principal.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}




