package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User;
import view.*;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenuController {
    @FXML
    public Button goToPreGameMenu;
    @FXML
    public Button goToProfileMenu;
    @FXML
    public Button logout;

    @FXML
    public void initialize() {
                    SetDefaults.run();
                    User user = new User("Zahra" , "12345", "", "");
                    User user2 = new User("Sara" , "12345", "", "");

        goToPreGameMenu.setOnAction(event -> {
            try {
                handleGoToPreGameMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        goToProfileMenu.setOnAction(event -> {
            try {
                handleGoToProfileMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        logout.setOnAction(event -> {
            try {
                handleLogout();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        setHoverEffect(goToPreGameMenu, "#0000ff");
        setHoverEffect(goToProfileMenu, "#0000ff");
        setHoverEffect(logout, "#B22222");
    }

    private void setHoverEffect(Button button, String hoverColor) {
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: " + hoverColor + ";"));
        button.setOnMouseExited(event -> button.setStyle(""));
    }

    private void handleGoToPreGameMenu() throws Exception {
        String UserFaction = User.getLoggedInUser().getFaction().getName();
        switch (UserFaction) {
            case "Skellige" :
                PregameMenuS pregameMenuS = new PregameMenuS();
                pregameMenuS.start(MainMenu.stage);
                break;
            case "Scoia'tael" :
                PregameMenuSc pregameMenuSc = new PregameMenuSc();
                pregameMenuSc.start(MainMenu.stage);
                break;
            case "Northern Realms" :
                PregameMenuNR pregameMenuNR = new PregameMenuNR();
                pregameMenuNR.start(MainMenu.stage);
                break;
            case "Nilfgaard" :
                PregameMenuN pregameMenuN = new PregameMenuN();
                pregameMenuN.start(MainMenu.stage);
                break;
            case "Monsters" :
                PregameMenuM pregameMenuM = new PregameMenuM();
                pregameMenuM.start(MainMenu.stage);
                break;
        }
    }

    private void handleGoToProfileMenu() throws Exception {
        ProfileMenu profileMenu = new ProfileMenu();
        profileMenu.start(MainMenu.stage);
    }

    private void handleLogout() throws Exception {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(MainMenu.stage);
    }

}
