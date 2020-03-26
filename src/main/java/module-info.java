module exemplejfx {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    opens vues to javafx.fxml;
    exports application;
}