package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.Card;

import java.util.regex.Matcher;

public class GameMenuController {

    public ImageView firstPlayerCrystal2;
    public ImageView firstPlayerCrystal1;
    public ImageView secondPlayerCrystal1;
    public ImageView secondPlayerCrystal2;
    public ImageView weatherCard;
    public Button firstPlayerPass;
    public Button secondPlayerPass;
    public ImageView firstPlayerSiegeBoost;
    public ImageView firstPlayerRangedBoost;
    public ImageView firstPlayerCloseCombatBoost;
    public ImageView secondPlayerCloseCombatBoost;
    public ImageView secondPlayerRangedBoost;
    public ImageView secondPlayerSiegeBoost;
    public ImageView secondPlayerCards;
    public ImageView firstPlayerBurnedCards;
    public ImageView firstPlayerCards;
    public ImageView secondPlayerBurnedCards;
    public ListView currentPlayerDeck;
    public ListView firstPlayerRangedList;
    public ListView firstPlayerCloseCombatList;
    public ListView secondPlayerCloseCombatList;
    public ListView secondPlayerRangedList;
    public ListView secondPlayerSiegeList;
    public ListView firstPlayerSiegeList;
    public Label firstPlayerSiege;
    public Label firstPlayerRanged;
    public Label secondPlayerRanged;
    public Label secondPlayerCloseCombat;
    public Label firstPlayerCloseCombat;
    public Label firstPlayerTotalBoardStrength;
    public Label SecondPlayerRemainingCards;
    public Label firstPlayerRemainingCards;
    public Label SecondPlayerTotalBoardStrength;
    public ImageView firstPlayerLeaderCard;
    public ImageView secondPlayerLeaderCard;
    public Label secondPlayerSiege;

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



}
