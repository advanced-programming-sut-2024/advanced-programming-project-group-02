package controller;

import enums.Statement;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Game;
import model.User;
import view.GameHistory;
import view.ProfileMenu;
import view.UserInfo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameHistoryController {

    public Text t;

    private static Matcher getCommandMatcher(String input, String regex) {
        return (Pattern.compile(regex).matcher(input));
    }

    public TextField number;

    public void initialize() {
        setText1();
    }

    public void backFromGameHistory(MouseEvent mouseEvent) {
        try {
            new ProfileMenu().start(GameHistory.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setText(MouseEvent mouseEvent) {
        ArrayList<Game> games = User.getLoggedInUser().getGames();
        int sizeOfGames = games.size();
//        int x = games.size()
        String textField = number.getText();
        StringBuilder stringBuilder = new StringBuilder();
        int y;
        if (games.isEmpty()) {
            LoginRegisterMenuController.showAlert("no game", "you have no completed game");
            return;
        }
        if (textField.isEmpty()) {
            y = Integer.min(5, sizeOfGames);
        } else {
            y = Integer.parseInt(textField);
        }

        if (!getCommandMatcher(textField, "\\d+").matches()) {
            LoginRegisterMenuController.showAlert("Invalid input", "the input must be a positive integer");
            return;
        }
        if (y > sizeOfGames) {
            LoginRegisterMenuController.showAlert("Invalid input", "the input could not be more than number of all games");
            return;
        }


        for (int i = 0; i < y; i++) {
            sizeOfGames--;
            Game game = games.get(sizeOfGames);
            if (game.getPlayer2().getUsername().equals(User.getLoggedInUser().getUsername())) {
                if (game.getStatement().equals(Statement.Tie) || game.getStatement().equals(Statement.Player1WonTheGame) || game.getStatement().equals(Statement.Player2WonTheGame)) {
                    stringBuilder.append("\n");
                    stringBuilder.append("username of other player: " + game.getPlayer1().getUsername());
                    stringBuilder.append("\t");
                    stringBuilder.append("date: " + game.getDate());
                    stringBuilder.append("\t\n");
                    stringBuilder.append("score of each round of logged in user: " + game.getGamePlayer2().getFirstRoundScore() + " " + game.getGamePlayer2().getSecondRoundScore() + " " + game.getGamePlayer2().getThirdRoundScore());
                    stringBuilder.append("\t");
                    stringBuilder.append("score of each round of the other player: " + game.getGamePlayer1().getFirstRoundScore() + " " + game.getGamePlayer1().getSecondRoundScore() + " " + game.getGamePlayer1().getThirdRoundScore());
                    stringBuilder.append("\t\n");
                    int a = game.getGamePlayer2().getFirstRoundScore() + game.getGamePlayer2().getSecondRoundScore() + game.getGamePlayer2().getThirdRoundScore();
                    stringBuilder.append("total score of logged in user: " + a);
                    stringBuilder.append("\t");
                    int b = game.getGamePlayer1().getFirstRoundScore() + game.getGamePlayer1().getSecondRoundScore() + game.getGamePlayer1().getThirdRoundScore();
                    stringBuilder.append("total score of the other player: " + b);
                    stringBuilder.append("\t\n");
                    stringBuilder.append("the winner: ");

                    Statement statement = game.getStatement();
                    if (statement.equals(Statement.Tie)) {
                        stringBuilder.append("tied");
                    } else if (statement.equals(Statement.Player1WonTheGame)) {
                        stringBuilder.append(game.getPlayer1().getUsername());
                    } else if (statement.equals(Statement.Player2WonTheGame)) {
                        stringBuilder.append(game.getPlayer2().getUsername());
                        stringBuilder.append("\n\n");

                    }
                } else {
                    i--;
                }
            } else {
                if (game.getStatement().equals(Statement.Tie) || game.getStatement().equals(Statement.Player1WonTheGame) || game.getStatement().equals(Statement.Player2WonTheGame)) {
                    stringBuilder.append("\n");
                    stringBuilder.append("username of other player: " + game.getPlayer2().getUsername());
                    stringBuilder.append("\t");
                    stringBuilder.append("date: " + game.getDate());
                    stringBuilder.append("\t\n");
                    stringBuilder.append("score of each round of logged in user: " + game.getGamePlayer1().getFirstRoundScore() + " " + game.getGamePlayer1().getSecondRoundScore() + " " + game.getGamePlayer1().getThirdRoundScore());
                    stringBuilder.append("\t");
                    stringBuilder.append("score of each round of the other player: " + game.getGamePlayer2().getFirstRoundScore() + " " + game.getGamePlayer2().getSecondRoundScore() + " " + game.getGamePlayer2().getThirdRoundScore());
                    stringBuilder.append("\t\n");
                    int a = game.getGamePlayer1().getFirstRoundScore() + game.getGamePlayer1().getSecondRoundScore() + game.getGamePlayer1().getThirdRoundScore();
                    stringBuilder.append("total score of logged in user: " + a);
                    stringBuilder.append("\t");
                    int b = game.getGamePlayer2().getFirstRoundScore() + game.getGamePlayer2().getSecondRoundScore() + game.getGamePlayer2().getThirdRoundScore();
                    stringBuilder.append("total score of the other player: " + b);
                    stringBuilder.append("\t\n");
                    stringBuilder.append("the winner: ");

                    Statement statement = game.getStatement();
                    if (statement.equals(Statement.Tie)) {
                        stringBuilder.append("tied");
                    } else if (statement.equals(Statement.Player1WonTheGame)) {
                        stringBuilder.append(game.getPlayer1().getUsername());
                    } else if (statement.equals(Statement.Player2WonTheGame)) {
                        stringBuilder.append(game.getPlayer2().getUsername());
                        stringBuilder.append("\n\n");

                    }
                } else {
                    i--;
                }
            }
        }
        t.setText(stringBuilder.toString());
        t.setFont(Font.font(10));
    }


    public void setText1() {
        ArrayList<Game> games = User.getLoggedInUser().getGames();
        int sizeOfGames = games.size();
        StringBuilder stringBuilder = new StringBuilder("");
        int y = Integer.min(5, sizeOfGames);


        if (games.isEmpty()) {
            LoginRegisterMenuController.showAlert("no game", "you have no completed game");
            return;
        }
        for (int i = 0; i < y; i++) {
            sizeOfGames--;
            Game game = games.get(sizeOfGames);
            if (game.getPlayer2().getUsername().equals(User.getLoggedInUser().getUsername())) {
                if (game.getStatement().equals(Statement.Tie) || game.getStatement().equals(Statement.Player1WonTheGame) || game.getStatement().equals(Statement.Player2WonTheGame)) {
                    stringBuilder.append("\n");
                    stringBuilder.append("username of other player: " + game.getPlayer1().getUsername());
                    stringBuilder.append("\t");
                    stringBuilder.append("date: " + game.getDate());
                    stringBuilder.append("\t\n");
                    stringBuilder.append("score of each round of logged in user: " + game.getGamePlayer2().getFirstRoundScore() + " " + game.getGamePlayer2().getSecondRoundScore() + " " + game.getGamePlayer2().getThirdRoundScore());
                    stringBuilder.append("\t");
                    stringBuilder.append("score of each round of the other player: " + game.getGamePlayer1().getFirstRoundScore() + " " + game.getGamePlayer1().getSecondRoundScore() + " " + game.getGamePlayer1().getThirdRoundScore());
                    stringBuilder.append("\t\n");
                    int a = game.getGamePlayer2().getFirstRoundScore() + game.getGamePlayer2().getSecondRoundScore() + game.getGamePlayer2().getThirdRoundScore();
                    stringBuilder.append("total score of logged in user: " + a);
                    stringBuilder.append("\t");
                    int b = game.getGamePlayer1().getFirstRoundScore() + game.getGamePlayer1().getSecondRoundScore() + game.getGamePlayer1().getThirdRoundScore();
                    stringBuilder.append("total score of the other player: " + b);
                    stringBuilder.append("\t\n");
                    stringBuilder.append("the winner: ");

                    Statement statement = game.getStatement();
                    if (statement.equals(Statement.Tie)) {
                        stringBuilder.append("tied");
                    } else if (statement.equals(Statement.Player1WonTheGame)) {
                        stringBuilder.append(game.getPlayer1().getUsername());
                    } else if (statement.equals(Statement.Player2WonTheGame)) {
                        stringBuilder.append(game.getPlayer2().getUsername());
                        stringBuilder.append("\n\n");

                    }
                } else {
                    i--;
                }
            } else {
                if (game.getStatement().equals(Statement.Tie) || game.getStatement().equals(Statement.Player1WonTheGame) || game.getStatement().equals(Statement.Player2WonTheGame)) {
                    stringBuilder.append("\n");
                    stringBuilder.append("username of other player: " + game.getPlayer2().getUsername());
                    stringBuilder.append("\t");
                    stringBuilder.append("date: " + game.getDate());
                    stringBuilder.append("\t\n");
                    stringBuilder.append("score of each round of logged in user: " + game.getGamePlayer1().getFirstRoundScore() + " " + game.getGamePlayer1().getSecondRoundScore() + " " + game.getGamePlayer1().getThirdRoundScore());
                    stringBuilder.append("\t");
                    stringBuilder.append("score of each round of the other player: " + game.getGamePlayer2().getFirstRoundScore() + " " + game.getGamePlayer2().getSecondRoundScore() + " " + game.getGamePlayer2().getThirdRoundScore());
                    stringBuilder.append("\t\n");
                    int a = game.getGamePlayer1().getFirstRoundScore() + game.getGamePlayer1().getSecondRoundScore() + game.getGamePlayer1().getThirdRoundScore();
                    stringBuilder.append("total score of logged in user: " + a);
                    stringBuilder.append("\t");
                    int b = game.getGamePlayer2().getFirstRoundScore() + game.getGamePlayer2().getSecondRoundScore() + game.getGamePlayer2().getThirdRoundScore();
                    stringBuilder.append("total score of the other player: " + b);
                    stringBuilder.append("\t\n");
                    stringBuilder.append("the winner: ");

                    Statement statement = game.getStatement();
                    if (statement.equals(Statement.Tie)) {
                        stringBuilder.append("tied");
                    } else if (statement.equals(Statement.Player1WonTheGame)) {
                        stringBuilder.append(game.getPlayer1().getUsername());
                    } else if (statement.equals(Statement.Player2WonTheGame)) {
                        stringBuilder.append(game.getPlayer2().getUsername());
                        stringBuilder.append("\n\n");

                    }
                } else {
                    i--;
                }
            }
        }
        t.setText(stringBuilder.toString());
        t.setFont(Font.font(10));
    }
}

