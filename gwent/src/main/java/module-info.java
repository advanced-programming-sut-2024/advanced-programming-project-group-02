
module my.javafx.app {
        requires javafx.controls;
        requires javafx.fxml;
        requires com.google.gson;
        requires java.desktop;
        requires javafx.media;


        opens view to javafx.fxml;
        opens controller to javafx.fxml;

        exports view;
        exports controller;
        exports model;
        }
