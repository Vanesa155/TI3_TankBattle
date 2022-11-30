package com.example.ti3_tankbattle;

import com.example.ti3_tankbattle.model.PlayerNames;
import com.example.ti3_tankbattle.model.PlayerPoints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PuntajesController implements Initializable {
    @FXML
    private Button close_Button;

    @FXML
    private TableView<PlayerPoints> puntajes_TableView;

    @FXML
    private TableColumn<PlayerPoints, Integer> columnaScore;

    @FXML
    private TableColumn<PlayerPoints, String> columnaUsername;

    @FXML
    void closePage(ActionEvent event) {
        Stage currentStage = (Stage) close_Button.getScene().getWindow();
        currentStage.close();
    }

    ObservableList<PlayerPoints> list = FXCollections.observableArrayList(
            new PlayerPoints("Osejo", 1),
            new PlayerPoints("Glo", 1),
            new PlayerPoints("Hidalgo", 2)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnaUsername.setCellValueFactory(new PropertyValueFactory<PlayerPoints, String>("Username"));
        columnaScore.setCellValueFactory(new PropertyValueFactory<PlayerPoints, Integer>("Score"));

        puntajes_TableView.setItems(list);
    }
}

