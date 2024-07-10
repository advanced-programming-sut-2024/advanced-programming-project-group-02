package controller;

import enums.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.EachPlayerGame;
import model.Game;
import model.User;
import view.EndOfTheGame;
import view.MainMenu;

import java.util.Objects;

public class EndOFTheGameController {

    public ImageView titleImage;
    public Label Round3W;
    public Label Round2W;
    public Label Round1W;
    public Label player2R3;
    public Label player2R2;
    public Label player2R1;
    public Label player1R3;
    public Label player1R2;
    public Label player1R1;

    @FXML
    public void initialize() {
        Game game = User.getLoggedInUser().getCurrentGame();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        if (game.getStatement().equals(Statement.Tie)) {
           titleImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/end_draw.png"))));
        } else if (game.getStatement().equals(Statement.Player1WonTheGame) && User.getLoggedInUser().equals(game.getPlayer1())) {
            titleImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/end_win.png"))));
        } else if (game.getStatement().equals(Statement.Player2WonTheGame) && User.getLoggedInUser().equals(game.getPlayer2())) {
            titleImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/end_win.png"))));
        } else {
            titleImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/end_lose.png"))));
        }

        player1R1.setText(String.valueOf(firstPlayerGame.getFirstRoundScore()));
        player1R2.setText(String.valueOf(firstPlayerGame.getSecondRoundScore()));
        player1R3.setText(String.valueOf(firstPlayerGame.getThirdRoundScore()));

        player2R1.setText(String.valueOf(secondPlayerGame.getFirstRoundScore()));
        player2R2.setText(String.valueOf(secondPlayerGame.getSecondRoundScore()));
        player2R3.setText(String.valueOf(secondPlayerGame.getThirdRoundScore()));

        if (game.getFirstRoundWinner() != null) Round1W.setText(String.valueOf(game.getFirstRoundWinner().getUsername()));
        else Round1W.setText("Draw");
        if (game.getSecondRoundWinner() != null) Round2W.setText(String.valueOf(game.getSecondRoundWinner().getUsername()));
        else Round2W.setText("Draw");
        if (game.getThirdRoundWinner() != null) Round3W.setText(String.valueOf(game.getThirdRoundWinner().getUsername()));
        else Round3W.setText("Draw");


        game.getPlayer1().setCurrentGame(null);
        game.getPlayer2().setCurrentGame(null);

    }


    public void goToMainMenu(MouseEvent mouseEvent) {
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(EndOfTheGame.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
