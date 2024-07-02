package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GameMenu extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        GameMenu.stage = stage;
        Parent root = FXMLLoader.load((getClass().getResource("/FXML/GameMenu.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Game Menu");
        stage.getIcons().add(new Image((getClass().getResourceAsStream("/Images/GwentIcon.jpg"))));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}