package controller;

import enums.Ability;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.Card;
import model.Game;
import model.User;

public class Function {
    public static GameMenuController gameMenuController;


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
            abilitySwitch(game, listView, card);
        } if (user.equals(game.getPlayer2())) {
            switch (Id) {
                case "secondPlayerSiegeList":
                    ObservableList<Card> cardList = game.getGamePlayer2().getSiege();
                    cardList.add(card);
                    game.getGamePlayer2().setSiege(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
                case "secondPlayerCloseCombatList":
                    cardList = game.getGamePlayer2().getCloseCombat();
                    cardList.add(card);
                    game.getGamePlayer2().setCloseCombat(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
                case "secondPlayerRangedList":
                    cardList = game.getGamePlayer2().getRangedCombat();
                    cardList.add(card);
                    game.getGamePlayer2().setRangedCombat(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
            }
            abilitySwitch(game, listView, card);
        }


    }

    private static void abilitySwitch(Game game, ListView listView, Card card) {
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
            abilitySwitch(game, imageView, card);
        } if (user.equals(game.getPlayer2())) {
            switch (Id) {
                case "secondPlayerSiegeList":
                    ObservableList<Card> cardList = game.getGamePlayer2().getSiege();
                    cardList.add(card);
                    game.getGamePlayer2().setSiege(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
                case "secondPlayerCloseCombatList":
                    cardList = game.getGamePlayer2().getCloseCombat();
                    cardList.add(card);
                    game.getGamePlayer2().setCloseCombat(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
                case "secondPlayerRangedList":
                    cardList = game.getGamePlayer2().getRangedCombat();
                    cardList.add(card);
                    game.getGamePlayer2().setRangedCombat(cardList);
                    cardList = game.getGamePlayer2().getHand();
                    cardList.remove(card);
                    game.getGamePlayer2().setHand(cardList);
                    break;
            }
            abilitySwitch(game, imageView, card);
        }

    }

    private static void abilitySwitch(Game game, ImageView imageView, Card card) {
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