package view;

import controller.LoginRegisterMenuController;
import controller.SetDefaults;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class PregameMenuNR extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        SetDefaults.run();

        Button closeButton = new Button("Close Application");
        closeButton.setOnAction(e -> closeApplication(stage));

        VBox layout = new VBox(10);
        layout.getChildren().add(closeButton);

        view.PregameMenuNR.stage = stage;
        Parent root = FXMLLoader.load((getClass().getResource("/FXML/PregameMenuNR.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Pregame Menu");
        stage.getIcons().add(new Image((getClass().getResourceAsStream("/Images/GwentIcon.jpg"))));
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            LoginRegisterMenuController.saveUsers();
            closeApplication(stage);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeApplication(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            stage.close();
        }
    }
}