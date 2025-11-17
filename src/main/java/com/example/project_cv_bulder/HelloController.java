package com.example.project_cv_bulder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button createCVButton;

    @FXML
    private void handleCreateCV() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cv-form-view.fxml"));
        Stage stage = (Stage) createCVButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
