module com.example.project_cv_bulder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.project_cv_bulder to javafx.fxml;
    exports com.example.project_cv_bulder;
}
