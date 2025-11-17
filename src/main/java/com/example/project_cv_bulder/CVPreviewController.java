package com.example.project_cv_bulder;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CVPreviewController {

    @FXML private TextFlow nameText;
    @FXML private TextFlow emailText;
    @FXML private TextFlow phoneText;
    @FXML private TextFlow addressText;

    @FXML private TextFlow educationText;
    @FXML private TextFlow skillsText;
    @FXML private TextFlow workExpText;
    @FXML private TextFlow projectsText;

    public void setCVData(String name, String email, String phone, String address,
                          String education, String skills, String workExp, String projects) {

        nameText.getChildren().add(new Text("1. Name : "  + name ));
        emailText.getChildren().add(new Text( "2. Email : " + email));
        phoneText.getChildren().add(new Text("3. Phone No : "+ phone));
        addressText.getChildren().add(new Text("4. Address : " + address));

        educationText.getChildren().add(new Text(education));
        skillsText.getChildren().add(new Text(skills));
        workExpText.getChildren().add(new Text(workExp));
        projectsText.getChildren().add(new Text(projects));
    }
}
