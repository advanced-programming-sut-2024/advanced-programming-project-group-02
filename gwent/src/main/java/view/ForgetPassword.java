package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class ForgetPassword extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        ForgetPassword.stage = stage;
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/FXML/ForgetPassword.fxml"))));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Forget Password");
        stage.getIcons().add(new Image((getClass().getResourceAsStream("/Images/GwentIcon.jpg"))));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
