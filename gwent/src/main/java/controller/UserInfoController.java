package controller;

import enums.Statement;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Game;
import model.User;
import view.GameHistory;
import view.ProfileMenu;
import view.UserInfo;

public class UserInfoController {


    public Label username;
    public Label nickname;
    public Label bestScore;
    public Label rank;
    public Label games;
    public Label tied;
    public Label won;
    public Label lost;

    public void initialize() {
        editLabels();
    }

    public void backFromGameHistory(MouseEvent mouseEvent) {
        try {
            new ProfileMenu().start(GameHistory.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backFromUserInfo(MouseEvent mouseEvent) {
        try {
            new ProfileMenu().start(UserInfo.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editLabels() {
        String u = User.getLoggedInUser().getUsername();
        username.setText(u);
        String n = User.getLoggedInUser().getNickname();
        nickname.setText(n);
        int b = User.getLoggedInUser().getMaxScore();
        bestScore.setText(Integer.toString(b));
        int r = User.getLoggedInUser().calculateRank();
        rank.setText(Integer.toString(r));
        int g = 0;
        for (Game game : User.getLoggedInUser().getGames()) {
            if (game.getStatement().equals(Statement.Tie) || game.getStatement().equals(Statement.Player1WonTheGame) || game.getStatement().equals(Statement.Player2WonTheGame)) {
                g++;
            }
        }
        games.setText(Integer.toString(g));

        int t = 0;
        for (Game game : User.getLoggedInUser().getGames()) {
            if (game.getStatement().equals(Statement.Tie)) {
                t++;
            }
        }
        tied.setText(Integer.toString(t));

        int w = 0;
        for (Game game : User.getLoggedInUser().getGames()) {
            if (game.getStatement().equals(Statement.Player2WonTheGame)) {
                w++;
            }
        }
        won.setText(Integer.toString(w));
        int l = 0;
        for (Game game : User.getLoggedInUser().getGames()) {
            if (game.getStatement().equals(Statement.Player1WonTheGame)) {
                l++;
            }
        }
        lost.setText(Integer.toString(l));
    }
}