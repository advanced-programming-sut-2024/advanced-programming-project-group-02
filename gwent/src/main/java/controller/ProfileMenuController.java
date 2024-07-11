package controller;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.User;
import view.GameHistory;
import view.MainMenu;
import view.ProfileMenu;
import view.UserInfo;

import java.util.regex.Matcher;

public class ProfileMenuController {

    public static void showUserInfo(Matcher matcher) {
    }

    public static void showGameHistory(Matcher matcher) {
    }

    //##################################
    //##################################
    //##################################
    //##################################
    //##################################
    //##################################
    public Label usernameLabel;
    public Label nicknameLabel;
    public Label emailLabel;

    public TextField username;
    public TextField nickname;
    public TextField email;
    public PasswordField password;
    public PasswordField oldPassword;



    public void initialize() {
        editLabel();
    }

    private void editLabel() {
        setEmailLabel();
        setNicknameLabel();
        setUsernameLabel();
    }

    public void mainMenu(MouseEvent mouseEvent) {
        try {
            new MainMenu().start(ProfileMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void GameHistory(MouseEvent mouseEvent) {
        try {
            new GameHistory().start(ProfileMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void useInfo(MouseEvent mouseEvent) {
        try {
            new UserInfo().start(ProfileMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUsernameLabel() {
        String u = User.getLoggedInUser().getUsername();
        usernameLabel.setText("username: " + u);

    }

    public void setNicknameLabel() {
        String u = User.getLoggedInUser().getNickname();
        nicknameLabel.setText("nickname: " + u);

    }

    public void setEmailLabel() {
        String u = User.getLoggedInUser().getEmail();
        emailLabel.setText("email: " + u);

    }

    public void changeUsername(MouseEvent mouseEvent) {
        editUsername(username);
        setUsernameLabel();
        username.clear();
    }

    public void changePassword(MouseEvent mouseEvent) {
        editPassword(password , oldPassword);
        password.clear();
        oldPassword.clear();
    }

    public void changeEmail(MouseEvent mouseEvent) {
        editEmail(email);
        setEmailLabel();
        email.clear();
    }

    public void changeNickname(MouseEvent mouseEvent) {
        editNickname(nickname);
        setNicknameLabel();
        nickname.clear();
    }


    public static void editUsername(TextField textField) {
        String username = textField.getText();
        if (!LoginRegisterMenuController.isUsableUsername(username)) {
            LoginRegisterMenuController.showAlert("Invalid username", "Your username can only contain uppercase and lowercase letters, numbers or the dash character");
            return;
        }
        if (User.isThereUserWithName(username)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Username");
            alert.setHeaderText("username already exists");
            alert.show();
            return;
        }

        if (username.equals(User.getLoggedInUser().getUsername())) {
            LoginRegisterMenuController.showAlert("Invalid username", "This username is the same as the previous username");
            return;
        }
        User.getLoggedInUser().setUsername(username);
        LoginRegisterMenuController.showAlert("done" , "username changed");

    }

    public static void editPassword(PasswordField passwordField, PasswordField oldPass) {
        String password = passwordField.getText();
        String oldPassword = oldPass.getText();
        if (!oldPassword.equals(User.getLoggedInUser().getPassword())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong Password");
            alert.setHeaderText("OLd password is wrong");
            alert.show();
            return;
        }
        if (!LoginRegisterMenuController.isPasswordWeak(password)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Password");
            alert.setHeaderText("password is not strong enough");
            alert.show();
            return;
        }

        if (password.equals(User.getLoggedInUser().getPassword())) {
            LoginRegisterMenuController.showAlert("Invalid password", "This password is the same as the previous password");
            return;
        }
        User.getLoggedInUser().setPassword(password);
        LoginRegisterMenuController.showAlert("done" , "password changed");

    }

    public static void editNickname(TextField textField) {
        String nickname = textField.getText();

        if (nickname.equals(User.getLoggedInUser().getNickname())) {
            LoginRegisterMenuController.showAlert("Invalid Nickname", "This nickname is the same as the previous nickname");
            return;
        }
        User.getLoggedInUser().setNickname(nickname);
        LoginRegisterMenuController.showAlert("done", "nickname changed");

    }

    public static void editEmail(TextField textField) {
        String email = textField.getText();
        if (!LoginRegisterMenuController.isValidEmailAddress(email)) {
            LoginRegisterMenuController.showAlert("Invalid email", "The email entered is invalid.");
            return;
        }
        if (email.equals(User.getLoggedInUser().getEmail())) {
            LoginRegisterMenuController.showAlert("Invalid email", "This email is the same as the previous email");
            return;
        }
        User.getLoggedInUser().setEmail(email);
        LoginRegisterMenuController.showAlert("done", "email changed");


    }


}