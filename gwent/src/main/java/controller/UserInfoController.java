package controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
        int g = User.getLoggedInUser().getNumberOfAllGames();
        games.setText(Integer.toString(g));
        int t = User.getLoggedInUser().getNumberOfTiedGames();
        tied.setText(Integer.toString(t));
        int w = User.getLoggedInUser().getNumberOfWonGames();
        won.setText(Integer.toString(w));
        int l = User.getLoggedInUser().getNumberOfLostGames();
        lost.setText(Integer.toString(l));
    }
}