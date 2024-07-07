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

    public static void run(GameMenuController gameMenuController, ImageView imageView, Card card) {

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
            Ability ability = card.getAbility();
            switch (ability) {
                case Muster:
                    muster(game, listView, card);
                    break;
                case Medic:
                    medic(game, listView, card);
                    break;
                case TightBond:
                    tightBond(game, listView, card );
                    break;
                case Scorch:
                    scorch(game, listView, card);
                    break;
                case MoralBoost:
                    moralBoost(game, listView, card);
                    break;
                case CommandersHorn:
                    commandersHorn(game, listView, card);
                    break;
                case Spy:
                    spy(game, listView, card);
                    break;
                case Mardoeme:
                    mardroeme(game, listView, card);
                    break;
                case Berserker:
                    berserker(game, listView, card);
                    break;
                case Transformers:
                    transformers(game, listView, card);
                    break;
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
                    break;
                case Medic:
                    medic(game, listView, card);
                    break;
                case TightBond:
                    tightBond(game, listView, card );
                    break;
                case Scorch:
                    scorch(game, listView, card);
                    break;
                case MoralBoost:
                    moralBoost(game, listView, card);
                    break;
                case CommandersHorn:
                    commandersHorn(game, listView, card);
                    break;
                case Spy:
                    spy(game, listView, card);
                    break;
                case Mardoeme:
                    mardroeme(game, listView, card);
                    break;
                case Berserker:
                    berserker(game, listView, card);
                    break;
                case Transformers:
                    transformers(game, listView, card);
                    break;
            }
        }


    }

    private static void unit(Game game, ImageView imageView, Card card) {
        User user = game.getActivePlayer();
        String Id = imageView.getId();
        if (user.equals(game.getPlayer1())) {
            switch (Id) {
                case "firstPlayerRangedBoost":
                    ObservableList<Card> cardList = game.getGamePlayer1().getHand();
                    cardList.remove(card);
                    game.getGamePlayer1().setHand(cardList);
                    imageView.setVisible(true);
                    break;
                case "firstPlayerSiegeBoost":
                    cardList = game.getGamePlayer1().getHand();
                    cardList.remove(card);
                    game.getGamePlayer1().setHand(cardList);
                    imageView.setVisible(true);
                    break;
                case "firstPlayerCloseCombatBoost":
                    cardList = game.getGamePlayer1().getHand();
                    cardList.remove(card);
                    game.getGamePlayer1().setHand(cardList);
                    imageView.setVisible(true);
                    break;
            }
            Ability ability = card.getAbility();
            switch (ability) {
                case Muster:
                    muster(game, imageView, card);
                    break;
                case Medic:
                    medic(game, imageView, card);
                    break;
                case TightBond:
                    tightBond(game, imageView, card );
                    break;
                case Scorch:
                    scorch(game, imageView, card);
                    break;
                case MoralBoost:
                    moralBoost(game, imageView, card);
                    break;
                case CommandersHorn:
                    commandersHorn(game, imageView, card);
                    break;
                case Spy:
                    spy(game, imageView, card);
                    break;
                case Mardoeme:
                    mardroeme(game, imageView, card);
                    break;
                case Berserker:
                    berserker(game, imageView, card);
                    break;
                case Transformers:
                    transformers(game, imageView, card);
                    break;
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
                    muster(game, imageView, card);
                    break;
                case Medic:
                    medic(game, imageView, card);
                    break;
                case TightBond:
                    tightBond(game, imageView, card );
                    break;
                case Scorch:
                    scorch(game, imageView, card);
                    break;
                case MoralBoost:
                    moralBoost(game, imageView, card);
                    break;
                case CommandersHorn:
                    commandersHorn(game, imageView, card);
                    break;
                case Spy:
                    spy(game, imageView, card);
                    break;
                case Mardoeme:
                    mardroeme(game, imageView, card);
                    break;
                case Berserker:
                    berserker(game, imageView, card);
                    break;
                case Transformers:
                    transformers(game, imageView, card);
                    break;
            }
        }

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