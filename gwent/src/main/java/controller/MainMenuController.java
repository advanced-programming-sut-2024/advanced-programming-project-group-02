package controller;

import model.User;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenuController {


    private static User currentUser;


    //bayad command dashte bashe ke az preGame bere be ProfileMenu

    public static void showCommands (){

    }

    public static void gotoProfileMenu (Scanner scanner){

    }

    public static void createGame (Matcher matcher){

    }

    public static void selectFaction (Matcher matcher){

    }

    public static void selectLeader (Matcher matcher){

    }

    public static void changeTurn (){
        //if player 1 information complete --> change turn;
        //if player 2 information complete --> show a massage that he should give us the start game command;
    }

    public static void startGame(){
        //if player 2 information complete --> Start game;
        //if player 2 information complete --> show a massage that he should give us the change turn command;
    }

    public static boolean isInformationCompleted (){return true;}

    public static void addToDeck(Matcher matcher){}

    public static void removeFromDeck(Matcher matcher){}

    public static void loadDeck(Matcher matcher){}

    public static void saveDeck(Matcher matcher){}

    public static void formattedDate(){}

}
