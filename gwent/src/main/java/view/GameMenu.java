package view;

import controller.GameMenuController;
import controller.LoginRegisterMenuController;
import controller.SetDefaults;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

public class GameMenu extends Application {
    private GameMenuController gameMenuController = new GameMenuController();
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        GameMenu.stage = stage;
        Parent root = FXMLLoader.load((getClass().getResource("/FXML/GameMenu.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/CSS/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Game Menu");
        stage.getIcons().add(new Image((getClass().getResourceAsStream("/Images/GwentIcon.jpg"))));
        stage.show();

        scene.setOnKeyPressed(event -> gameMenuController.handleKeyPress(event));

    }

    public static void main(String[] args) {
        launch(args);
    }

//    private void closeApplication(Stage stage) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Exit Confirmation");
//        alert.setHeaderText(null);
//        alert.setContentText("Are you sure you want to exit?");
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.isPresent() && result.get() == ButtonType.OK) {
//            stage.close();
//        }
//    }
}