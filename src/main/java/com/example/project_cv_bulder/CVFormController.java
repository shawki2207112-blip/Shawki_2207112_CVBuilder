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

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cv-preview-view.fxml"));
            Parent root = loader.load();

            CVPreviewController controller = loader.getController();
            controller.setCVData(
                    fullNameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    educationField.getText(),
                    skillsField.getText(),
                    workExpField.getText(),
                    projectsField.getText()
            );

            Stage stage = new Stage();
            stage.setTitle("CV Preview");
            stage.setScene(new Scene(root, 600, 700));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
