package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class VideoPlayer extends Application {

    @Override
    public void start(Stage primaryStage) {
        javafx.scene.media.Media media = new Media(Objects.requireNonNull(MusicPlayer.class.getResource("/video/background.mp4")).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        StackPane root = new StackPane();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root, 780, 440);

        //set stack pane
        mediaView.fitWidthProperty().bind(scene.widthProperty());
        mediaView.fitHeightProperty().bind(scene.heightProperty());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome Gwent");
        primaryStage.show();

        mediaPlayer.setOnEndOfMedia(() -> {
            primaryStage.close();
            showLoginMenu();
        });

        mediaPlayer.play();
        MusicPlayer.playBackgroundMusic();
    }

    private void showLoginMenu() {
        LoginMenu loginMenu = new LoginMenu();
        Stage loginStage = new Stage();
        try {
            loginMenu.start(loginStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
