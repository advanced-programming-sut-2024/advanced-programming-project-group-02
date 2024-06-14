module my.javafx.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens view to javafx.fxml, javafx.graphics;
    opens controller to javafx.fxml;

    exports view;
    exports controller;
}
