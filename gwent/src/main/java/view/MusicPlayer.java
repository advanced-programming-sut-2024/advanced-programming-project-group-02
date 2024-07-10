package view;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class MusicPlayer {
    private static MediaPlayer mediaPlayer;

    public static void playBackgroundMusic() {
//        if (mediaPlayer == null) {
            Media media = new Media(Objects.requireNonNull(MusicPlayer.class.getResource("/music/background.mp3")).toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        }
        mediaPlayer.play();
    }

    public static void stopBackgroundMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
