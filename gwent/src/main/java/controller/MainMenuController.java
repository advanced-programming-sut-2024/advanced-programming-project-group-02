package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
        button.setOnMouseExited(event -> button.setStyle("")); // Revert to default on mouse exit
    }

    private void handleGoToPreGameMenu() throws Exception {
        PregameMenu pregameMenu = new PregameMenu();
        pregameMenu.start(MainMenu.stage);
    }

    private void handleGoToProfileMenu() throws Exception {
        ProfileMenu profileMenu = new ProfileMenu();
        profileMenu.start(MainMenu.stage);
    }

    private void handleLogout() throws Exception {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(MainMenu.stage);
    }

//
//    private void gotoProfileMenu() {
//        }
//
//
//    public static void createGame (Matcher matcher){
//
//    }
//
//    public static void selectFaction (Matcher matcher){
//
//    }
//
//    public static void selectLeader (Matcher matcher){
//
//    }
//
//    public static void changeTurn (){
//        //if player 1 information complete --> change turn;
//        //if player 2 information complete --> show a massage that he should give us the start game command;
//    }
//
//    public static void startGame(){
//        //if player 2 information complete --> Start game;
//        //if player 2 information complete --> show a massage that he should give us the change turn command;
//    }
//
//    public static boolean isInformationCompleted (){return true;}
//
//    public static void addToDeck(Matcher matcher){}
//
//    public static void removeFromDeck(Matcher matcher){}
//
//    public static void loadDeck(Matcher matcher){}
//
//    public static void saveDeck(Matcher matcher){}
//
//    public static void formattedDate(){}
//
}
