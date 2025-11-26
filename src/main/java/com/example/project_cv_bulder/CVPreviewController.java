package com.example.project_cv_bulder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CVPreviewController {

    @FXML private Label nameLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    @FXML private Label addressLabel;

    @FXML private Label educationLabel;
    @FXML private Label skillsLabel;
    @FXML private Label workExpLabel;
    @FXML private Label projectsLabel;

    public void setCVData(String name, String email, String phone, String address,
                          String education, String skills, String workExp, String projects) {

        nameLabel.setText("Name: " + name);
        emailLabel.setText("Email: " + email);
        phoneLabel.setText("Phone: " + phone);
        addressLabel.setText("Address: " + address);

        educationLabel.setText(education);
        skillsLabel.setText(skills);
        workExpLabel.setText(workExp);
        projectsLabel.setText(projects);
    }
}
