
module my.javafx.app {
        requires javafx.controls;
        requires javafx.fxml;
        requires com.google.gson;
        requires java.desktop;
        requires javafx.media;
        requires java.persistence;
        requires org.hibernate.orm.core;
        requires java.sql;
        requires javafx.graphics;

        opens view to javafx.fxml,javafx.graphics,com.google.gson;
        opens controller to javafx.fxml,javafx.graphics,com.google.gson;
        opens model to com.google.gson,javafx.graphics,javafx.fxml;

        exports enums;
        exports view;
        exports controller;
        exports model;
}
