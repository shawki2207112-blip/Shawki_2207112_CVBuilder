package com.example.project_cv_bulder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private void openCVForm() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("cv-form-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Create CV");
        stage.setScene(new Scene(root, 700, 700));
        stage.show();
    }

    @FXML
    private void openCVList() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("cv-list-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Saved CVs");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}
