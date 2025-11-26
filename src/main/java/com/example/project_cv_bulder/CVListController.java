package com.example.project_cv_bulder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class CVListController {

    @FXML private ListView<CVModel> cvList;
    private ObservableList<CVModel> cvObservableList;

    @FXML
    public void initialize() {
        cvObservableList = FXCollections.observableArrayList();
        cvList.setItems(cvObservableList);
        loadCVs();
    }

    public void loadCVs() {
        cvObservableList.setAll(DatabaseHelper.getAllCVs());
    }

    @FXML
    private void previewCV() {
        CVModel selected = cvList.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cv-preview-view.fxml"));
            Parent root = loader.load();

            CVPreviewController controller = loader.getController();
            controller.setCVData(
                    selected.getName(),
                    selected.getEmail(),
                    selected.getPhone(),
                    selected.getAddress(),
                    selected.getEducation(),
                    selected.getSkills(),
                    selected.getWorkExp(),
                    selected.getProjects()
            );

            Stage stage = new Stage();
            stage.setTitle("CV Preview");
            stage.setScene(new Scene(root, 600, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void editCV() {
        CVModel selected = cvList.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cv-form-view.fxml"));
            Parent root = loader.load();

            CVFormController controller = loader.getController();
            controller.loadCVForEdit(selected);
            controller.setOnSave(this::loadCVs);

            Stage stage = new Stage();
            stage.setTitle("Edit CV");
            stage.setScene(new Scene(root, 700, 700));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteCV() {
        CVModel selected = cvList.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        DatabaseHelper.deleteCV(selected.getId());
        loadCVs();
    }
}
