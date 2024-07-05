package controller;

import enums.Ability;
import enums.CardType;
import enums.Place;
import javafx.collections.ObservableList;
import enums.CardType;
import enums.Place;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;
import model.Game;
import model.User;

import javax.swing.text.View;
import java.util.ArrayList;

public class Function {
    public static GameMenuController gameMenuController;

    public void run(GameMenuController gameMenuController, ListView listView, Card card) {
        this.gameMenuController = gameMenuController;
        Game game = User.getLoggedInUser().getCurrentGame();
        CardType cardType = card.getCardType();
        switch (cardType) {
            case CloseCombatUnit:
            case RangedUnit:
            case SiegeUnit:
            case AgileUnit:
                unit(game, listView, card);
        }
    }

    public static void run(ImageView imageView, Card card) {
    }

    private static void unit(Game game, ListView listView, Card card) {
        User user = game.getActivePlayer();
        String Id = listView.getId();
        if (user.equals(game.getPlayer1())) {
            switch (Id) {
                case "firstPlayerSiegeList":
                    ObservableList<Card> cardList = game.getGamePlayer1().getSiege();
                    cardList.add(card);
                    game.getGamePlayer1().setSiege(cardList);
                    cardList = game.getGamePlayer1().getHand();
                    cardList.remove(card);
                    game.getGamePlayer1().setHand(cardList);
                    break;
                case "firstPlayerCloseCombatList":
                    cardList = game.getGamePlayer1().getCloseCombat();
                    cardList.add(card);
                    game.getGamePlayer1().setCloseCombat(cardList);
                    cardList = game.getGamePlayer1().getHand();
                    cardList.remove(card);
                    game.getGamePlayer1().setHand(cardList);
                    break;
                case "firstPlayerRangedList":
                    cardList = game.getGamePlayer1().getRangedCombat();
                    cardList.add(card);
                    game.getGamePlayer1().setRangedCombat(cardList);
                    cardList = game.getGamePlayer1().getHand();
                    cardList.remove(card);
                    game.getGamePlayer1().setHand(cardList);
                    break;
            }
            switch () {

            }
        } if (user.equals(game.getPlayer2())) {
            switch (Id) {
                case "firstPlayerSiegeList":
                    ObservableList<Card> cardList = game.getGamePlayer2().getSiege();
                    cardList.add(card);
                    game.getGamePlayer2().setSiege(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
                case "firstPlayerCloseCombatList":
                    cardList = game.getGamePlayer2().getCloseCombat();
                    cardList.add(card);
                    game.getGamePlayer2().setCloseCombat(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
                case "firstPlayerRangedList":
                    cardList = game.getGamePlayer2().getRangedCombat();
                    cardList.add(card);
                    game.getGamePlayer2().setRangedCombat(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
            }
            Ability ability = card.getAbility();
            switch (ability) {
                case Muster:
                    muster(game, listView, card);
                case Medic:
                    medic(game, listView, card);
                case TightBond:
                    tightBond(game, listView, card );
                case Scorch:
                case MoralBoost:
                case CommandersHorn:
                case Spy:
                case Mardoeme:
                case Berserker:
                case Transformers:

            }
        }


    }

    private static void unit(Game game, ImageView imageView, Card card) {

    }

    private static void commandersHorn(Game game, ListView listView, Card card) {
    }

    private static void commandersHorn(Game game, ImageView imageView, Card card) {
    }

    private static void decoy(Game game, ListView listView, Card card) {
    }

    private static void decoy(Game game, ImageView imageView, Card card) {
    }

    private static void medic(Game game, ListView listView, Card card) {
    }

    private static void medic(Game game, ImageView imageView, Card card) {
    }

    private static void moralBoost(Game game, ListView listView, Card card) {
    }

    private static void moralBoost(Game game, ImageView imageView, Card card) {
    }

    private static void muster(Game game, ListView listView, Card card) {
    }

    private static void muster(Game game, ImageView imageView, Card card) {
    }

    private static void spy(Game game, ListView listView, Card card) {
    }

    private static void spy(Game game, ImageView imageView, Card card) {
    }

    private static void tightBond(Game game, ListView listView, Card card) {
    }

    private static void tightBond(Game game, ImageView imageView, Card card) {
    }

    private static void scorch(Game game, ListView listView, Card card) {
    }

    private static void scorch(Game game, ImageView imageView, Card card) {
    }

    private static void berserker(Game game, ListView listView, Card card) {
    }

    private static void berserker(Game game, ImageView imageView, Card card) {
    }

    private static void mardroeme(Game game, ListView listView, Card card) {
    }

    private static void mardroeme(Game game, ImageView imageView, Card card) {
    }

    private static void transformers(Game game, ListView listView, Card card) {
    }

    private static void transformers(Game game, ImageView imageView, Card card) {
    }

    private static void nonAbility(Game game, ListView listView, Card card) {
    }

    private static void nonAbility(Game game, ImageView imageView, Card card) {
    }

    //3 method for transfer spell weather
}