package com.example.project_cv_bulder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CVFormController {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;
    @FXML private TextArea educationField;
    @FXML private TextArea skillsField;
    @FXML private TextArea workExpField;
    @FXML private TextArea projectsField;

    @FXML private Label errorLabel;

    private CVModel editingCV = null;
    private Runnable onSave;

    @FXML
    private void handleGenerateCV() {

        boolean empty =
                fullNameField.getText().isEmpty() ||
                        emailField.getText().isEmpty() ||
                        phoneField.getText().isEmpty() ||
                        addressField.getText().isEmpty() ||
                        educationField.getText().isEmpty() ||
                        skillsField.getText().isEmpty() ||
                        workExpField.getText().isEmpty() ||
                        projectsField.getText().isEmpty();

        if (empty) {
            errorLabel.setVisible(true);
            return;
        }

        errorLabel.setVisible(false);

        if (editingCV == null) {
            DatabaseHelper.insertCV(
                    fullNameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    educationField.getText(),
                    skillsField.getText(),
                    workExpField.getText(),
                    projectsField.getText()
            );
        } else {
            DatabaseHelper.updateCV(
                    editingCV.getId(),
                    fullNameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    educationField.getText(),
                    skillsField.getText(),
                    workExpField.getText(),
                    projectsField.getText()
            );
        }

        if (onSave != null) onSave.run();

        Stage currentStage = (Stage) fullNameField.getScene().getWindow();
        currentStage.close();
    }

    public void loadCVForEdit(CVModel cv) {
        this.editingCV = cv;
        fullNameField.setText(cv.getName());
        emailField.setText(cv.getEmail());
        phoneField.setText(cv.getPhone());
        addressField.setText(cv.getAddress());
        educationField.setText(cv.getEducation());
        skillsField.setText(cv.getSkills());
        workExpField.setText(cv.getWorkExp());
        projectsField.setText(cv.getProjects());
    }

    public void setOnSave(Runnable callback) {
        this.onSave = callback;
    }
}
