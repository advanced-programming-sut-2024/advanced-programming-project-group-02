package controller;

import enums.Ability;
import enums.CardType;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.Card;
import model.EachPlayerGame;
import model.Game;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    ObservableList<Card> siegeList = game.getGamePlayer1().getSiege();
                    HashMap<Card, List<Integer>> siegeScores = game.getGamePlayer1().getSiegeScores();
                    siegeList.add(card);

                    boolean hasCommandersHorn = siegeList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                    siegeScores.computeIfAbsent(card, k -> new ArrayList<>()).add(hasCommandersHorn ? card.getPower() * 2 : card.getPower());

                    game.getGamePlayer1().setSiege(siegeList);

                    ObservableList<Card> hand = game.getGamePlayer1().getHand();
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);

                    break;

                case "firstPlayerCloseCombatList":
                    ObservableList<Card> closeCombatList = game.getGamePlayer1().getCloseCombat();
                    HashMap<Card, List<Integer>> closeCombatScores = game.getGamePlayer1().getCloseCombatScores();
                    closeCombatList.add(card);

                    hasCommandersHorn = closeCombatList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                    closeCombatScores.computeIfAbsent(card, k -> new ArrayList<>()).add(hasCommandersHorn ? card.getPower() * 2 : card.getPower());

                    game.getGamePlayer1().setCloseCombat(closeCombatList);

                    hand = game.getGamePlayer1().getHand();
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);

                    break;

                case "firstPlayerRangedList":
                    ObservableList<Card> rangedList = game.getGamePlayer1().getRangedCombat();
                    HashMap<Card, List<Integer>> rangedScores = game.getGamePlayer1().getRangedCombatScores();
                    rangedList.add(card);

                    hasCommandersHorn = rangedList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                    rangedScores.computeIfAbsent(card, k -> new ArrayList<>()).add(hasCommandersHorn ? card.getPower() * 2 : card.getPower());

                    game.getGamePlayer1().setRangedCombat(rangedList);

                    hand = game.getGamePlayer1().getHand();
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);

                    break;
            }
            abilitySwitch(game, listView, card);
        } if (user.equals(game.getPlayer2())) {
            switch (Id) {
                case "secondPlayerSiegeList":
                    ObservableList<Card> siegeList = game.getGamePlayer2().getSiege();
                    HashMap<Card, List<Integer>> siegeScores = game.getGamePlayer2().getSiegeScores();
                    siegeList.add(card);

                    boolean hasCommandersHorn = siegeList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                    siegeScores.computeIfAbsent(card, k -> new ArrayList<>()).add(hasCommandersHorn ? card.getPower() * 2 : card.getPower());

                    game.getGamePlayer2().setSiege(siegeList);

                    ObservableList<Card> hand = game.getGamePlayer2().getHand();
                    hand.remove(card);
                    game.getGamePlayer2().setHand(hand);

                    break;

                case "secondPlayerCloseCombatList":
                    ObservableList<Card> closeCombatList = game.getGamePlayer2().getCloseCombat();
                    HashMap<Card, List<Integer>> closeCombatScores = game.getGamePlayer2().getCloseCombatScores();
                    closeCombatList.add(card);

                    hasCommandersHorn = closeCombatList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                    closeCombatScores.computeIfAbsent(card, k -> new ArrayList<>()).add(hasCommandersHorn ? card.getPower() * 2 : card.getPower());

                    game.getGamePlayer2().setCloseCombat(closeCombatList);

                    hand = game.getGamePlayer2().getHand();
                    hand.remove(card);
                    game.getGamePlayer2().setHand(hand);

                    break;

                case "secondPlayerRangedList":
                    ObservableList<Card> rangedList = game.getGamePlayer2().getRangedCombat();
                    HashMap<Card, List<Integer>> rangedScores = game.getGamePlayer2().getRangedCombatScores();
                    rangedList.add(card);

                    hasCommandersHorn = rangedList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                    rangedScores.computeIfAbsent(card, k -> new ArrayList<>()).add(hasCommandersHorn ? card.getPower() * 2 : card.getPower());

                    game.getGamePlayer2().setRangedCombat(rangedList);

                    hand = game.getGamePlayer2().getHand();
                    hand.remove(card);
                    game.getGamePlayer2().setHand(hand);

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
                tightBond(game, listView, card);
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


    private static void commandersHorn(Game game, ListView<Card> listView, Card card) {
        HashMap<Card, List<Integer>> cardScores = rowSwitch(game, listView);

        for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
            Card currentCard = entry.getKey();
            List<Integer> scores = entry.getValue();

            if (currentCard.isHero() || currentCard.equals(card)) {
                continue;
            }

            for (int i = 0; i < scores.size(); i++) {
                scores.set(i, scores.get(i) * 2);
            }
        }
    }

    private static void moralBoost(Game game, ListView<Card> listView, Card thrownCard) {
        HashMap<Card, List<Integer>> cardScores = rowSwitch(game, listView);
        List<Integer> thrownCardScores = cardScores.get(thrownCard);
        int sum = thrownCardScores.stream().mapToInt(Integer::intValue).sum();

        for (int i = 0; i < thrownCardScores.size(); i++) {
            thrownCardScores.set(i, sum);
        }

        cardScores.put(thrownCard, thrownCardScores);
    }

    private static void medic(Game game, ListView listView, Card card) {

    }

    private static HashMap<Card, List<Integer>> rowSwitch(Game game, ListView listView) {
        HashMap<Card, List<Integer>> cardScores = new HashMap<>();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        switch (listView.getId()) {
            case "firstPlayerSiegeList":
                cardScores = firstPlayerGame.getSiegeScores();
                break;
            case "firstPlayerRangedList":
                cardScores = firstPlayerGame.getRangedCombatScores();
                break;
            case "firstPlayerCloseCombatList":
                cardScores = firstPlayerGame.getCloseCombatScores();
                break;
            case "secondPlayerCloseCombatList":
                cardScores = secondPlayerGame.getCloseCombatScores();
                break;
            case "secondPlayerRangedList":
                cardScores = secondPlayerGame.getRangedCombatScores();
                break;
            case "secondPlayerSiegeList":
                cardScores = secondPlayerGame.getSiegeScores();
                break;
            default:
                break;
        }
        return cardScores;
    }

    private static void muster(Game game, ListView listView, Card card) {
    }

    private static void spy(Game game, ListView listView, Card card) {
    }

    private static void tightBond(Game game, ListView listView, Card card) {
    }

    private static void scorch(Game game, ListView listView, Card card) {
    }

    private static void berserker(Game game, ListView listView, Card card) {
    }

    private static void mardroeme(Game game, ListView listView, Card card) {
    }

    private static void transformers(Game game, ListView listView, Card card) {
    }


    private static void commandersHorn(Game game, ImageView imageView, Card card) {
    }

    //3 method for transfer spell weather
}