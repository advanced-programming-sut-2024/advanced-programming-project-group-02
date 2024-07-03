package controller;

import javafx.scene.input.MouseEvent;
import model.Card;

import java.util.regex.Matcher;

public class GameMenuController {

    public static void showCommands(){

    }

    public static Card vetoCard(int ID){
        return null;
    }

    public static void inHandDeck (Matcher matcher){

    } // show hand

    public static void inHandDeckOption(Matcher matcher){}

    public static void remainingCardsToPlay (){} // show remaining

    public static void outOfPlayCards(){} //show discard

    public static void cardsInRow (Matcher matcher){}

    public static void spellsInPlay (){}

    public static void commanderPowerPlay (){}

    public static void showCommander (){}

    public static void showPlayersInfo (){}

    public static void showPlayersLive (){}

    public static void showNumberOfCardsInHand (){}

    public static void showTurnInfo (){}

    public static void showTotalScoreOfRow (Matcher matcher){}

    public static void passRound (){}

    public static void placeCard (Matcher matcher){}

    public static void startEndRound (){}

    public static boolean isEndRound(){return true;}

    public void Exit (MouseEvent mouseEvent){
        LoginRegisterMenuController.saveUsers();
        System.exit(0);
    }


}
