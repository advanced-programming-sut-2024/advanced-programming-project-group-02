package controller;

import enums.Ability;
import enums.CardType;
import enums.Place;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.skin.CellSkinBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;
import model.EachPlayerGame;
import model.Game;
import model.User;

import java.util.*;

public class Function {
    public GameMenuController gameMenuController;

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

    public void run(GameMenuController gameMenuController, ImageView imageView, Card card) {
        this.gameMenuController = gameMenuController;
        Game game = User.getLoggedInUser().getCurrentGame();
        CardType cardType = card.getCardType();
        switch (cardType) {
            case Weather:
                weather(game, imageView, card);
            case Spell:
                spell(game, imageView, card);

        }

    }

    private void unit(Game game, ListView listView, Card card) {
        User user = game.getActivePlayer();
        String Id = listView.getId();
        if (user.equals(game.getPlayer1())) {
            switch (Id) {
                case "firstPlayerSiegeList":
                    ObservableList<Card>  list = game.getGamePlayer1().getSiege();
                    HashMap<Card, List<Integer>> scoresList = game.getGamePlayer1().getSiegeScores();
                    list.add(card);

                    int power = card.getPower();
                    if (!card.isHero() && (card.getAbility() == null || (card.getAbility() != null &&
                            !card.getAbility().equals(Ability.CommandersHorn))) && (list.contains(Card.getCardByID(609))  || list.contains(Card.getCardByID(121)) ||
                            (game.getGamePlayer1().getMarCoSiege() != null && game.getGamePlayer1().getMarCoSiege().equals(Card.getCardByID(607))))) {
                        power *= 2;
                    } else if (card.getAbility() != null && card.getAbility().equals(Ability.CommandersHorn) &&
                            (game.getGamePlayer1().getMarCoSiege() != null && game.getGamePlayer1().getMarCoSiege().equals(Card.getCardByID(607)))) {
                        power *= 2;
                    }

                    List<Integer> scores = scoresList.getOrDefault(card, new ArrayList<>());
                    scores.add(power);
                    scoresList.put(card, scores);

                    game.getGamePlayer1().setSiege(list);
                    game.getGamePlayer1().setSiegeScores(scoresList);

                    ObservableList<Card> hand = game.getGamePlayer1().getHand();
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);

                    break;

                case "firstPlayerCloseCombatList":
                    list = game.getGamePlayer1().getCloseCombat();
                    scoresList = game.getGamePlayer1().getCloseCombatScores();
                    list.add(card);

                    power = card.getPower();
                    if (!card.isHero() && (card.getAbility() == null || (card.getAbility() != null &&
                            !card.getAbility().equals(Ability.CommandersHorn))) && (list.contains(Card.getCardByID(609)) || list.contains(Card.getCardByID(121)) ||
                            (game.getGamePlayer1().getMarCoCloseCombat() != null && game.getGamePlayer1().getMarCoCloseCombat().equals(Card.getCardByID(607))))) {
                        power *= 2;
                    } else if (card.getAbility() != null && card.getAbility().equals(Ability.CommandersHorn) &&
                            (game.getGamePlayer1().getMarCoSiege() != null && game.getGamePlayer1().getMarCoSiege().equals(Card.getCardByID(607)))) {
                        power *= 2;
                    }

                    scores = scoresList.getOrDefault(card, new ArrayList<>());
                    scores.add(power);
                    scoresList.put(card, scores);

                    game.getGamePlayer1().setCloseCombat(list);
                    game.getGamePlayer1().setCloseCombatScores(scoresList);

                    hand = game.getGamePlayer1().getHand();
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);

                    break;

                case "firstPlayerRangedList":
                    list = game.getGamePlayer1().getRangedCombat();
                    scoresList = game.getGamePlayer1().getRangedCombatScores();
                    list.add(card);

                    power = card.getPower();
                    if (!card.isHero() && (card.getAbility() == null || (card.getAbility() != null &&
                            !card.getAbility().equals(Ability.CommandersHorn))) && (list.contains(Card.getCardByID(609)) || list.contains(Card.getCardByID(121)) ||
                            (game.getGamePlayer1().getMarCoRangedCombat() != null && game.getGamePlayer1().getMarCoRangedCombat().equals(Card.getCardByID(607))))) {
                        power *= 2;
                    } else if (card.getAbility() != null && card.getAbility().equals(Ability.CommandersHorn) &&
                            (game.getGamePlayer1().getMarCoSiege() != null && game.getGamePlayer1().getMarCoSiege().equals(Card.getCardByID(607)))) {
                        power *= 2;
                    }

                    scores = scoresList.getOrDefault(card, new ArrayList<>());
                    scores.add(power);
                    scoresList.put(card, scores);

                    game.getGamePlayer1().setRangedCombat(list);
                    game.getGamePlayer1().setRangedCombatScores(scoresList);

                    hand = game.getGamePlayer1().getHand();
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);

                    break;

            }
            abilitySwitch(game, listView, card);
        }
        if (user.equals(game.getPlayer2())) {
            switch (Id) {
                case "secondPlayerSiegeList":
                    ObservableList<Card>  list = game.getGamePlayer2().getSiege();
                    HashMap<Card, List<Integer>> scoresList = game.getGamePlayer2().getSiegeScores();
                    list.add(card);

                    int power = card.getPower();
                    if (!card.isHero() && (card.getAbility() == null || (card.getAbility() != null &&
                            !card.getAbility().equals(Ability.CommandersHorn))) && (list.contains(Card.getCardByID(609)) || list.contains(Card.getCardByID(121)) ||
                            (game.getGamePlayer2().getMarCoSiege() != null &&
                            game.getGamePlayer2().getMarCoSiege().equals(Card.getCardByID(607))))) {
                        power *= 2;
                    } else if (card.getAbility() != null && card.getAbility().equals(Ability.CommandersHorn) &&
                            (game.getGamePlayer1().getMarCoSiege() != null && game.getGamePlayer1().getMarCoSiege().equals(Card.getCardByID(607)))) {
                        power *= 2;
                    }

                    List<Integer> scores = scoresList.getOrDefault(card, new ArrayList<>());
                    scores.add(power);
                    scoresList.put(card, scores);

                    game.getGamePlayer2().setSiege(list);
                    game.getGamePlayer2().setSiegeScores(scoresList);

                    ObservableList<Card> hand = game.getGamePlayer2().getHand();
                    hand.remove(card);
                    game.getGamePlayer2().setHand(hand);

                    break;

                case "secondPlayerCloseCombatList":
                    list = game.getGamePlayer2().getCloseCombat();
                    scoresList = game.getGamePlayer2().getCloseCombatScores();
                    list.add(card);

                    power = card.getPower();
                    if (!card.isHero() && (card.getAbility() == null || (card.getAbility() != null &&
                            !card.getAbility().equals(Ability.CommandersHorn))) && (list.contains(Card.getCardByID(609))  || list.contains(Card.getCardByID(121)) ||
                            (game.getGamePlayer2().getMarCoCloseCombat() != null && game.getGamePlayer2().getMarCoCloseCombat().equals(Card.getCardByID(607))))) {
                        power *= 2;
                    } else if (card.getAbility() != null && card.getAbility().equals(Ability.CommandersHorn) &&
                            (game.getGamePlayer1().getMarCoSiege() != null && game.getGamePlayer1().getMarCoSiege().equals(Card.getCardByID(607)))) {
                        power *= 2;
                    }

                    scores = scoresList.getOrDefault(card, new ArrayList<>());
                    scores.add(power);
                    scoresList.put(card, scores);

                    game.getGamePlayer2().setCloseCombat(list);
                    game.getGamePlayer2().setCloseCombatScores(scoresList);

                    hand = game.getGamePlayer2().getHand();
                    hand.remove(card);
                    game.getGamePlayer2().setHand(hand);

                    break;

                case "secondPlayerRangedList":
                    list = game.getGamePlayer2().getRangedCombat();
                    scoresList = game.getGamePlayer2().getRangedCombatScores();
                    list.add(card);

                    power = card.getPower();
                    if (!card.isHero() && (card.getAbility() == null || (card.getAbility() != null &&
                            !card.getAbility().equals(Ability.CommandersHorn))) && (list.contains(Card.getCardByID(609)) || list.contains(Card.getCardByID(121)) ||
                            (game.getGamePlayer2().getMarCoRangedCombat() != null && game.getGamePlayer2().getMarCoRangedCombat().equals(Card.getCardByID(607))))) {
                        power *= 2;
                    } else if (card.getAbility() != null && card.getAbility().equals(Ability.CommandersHorn) &&
                            (game.getGamePlayer1().getMarCoSiege() != null && game.getGamePlayer1().getMarCoSiege().equals(Card.getCardByID(607)))) {
                        power *= 2;
                    }

                    scores = scoresList.getOrDefault(card, new ArrayList<>());
                    scores.add(power);
                    scoresList.put(card, scores);

                    game.getGamePlayer2().setRangedCombat(list);
                    game.getGamePlayer2().setRangedCombatScores(scoresList);

                    hand = game.getGamePlayer2().getHand();
                    hand.remove(card);
                    game.getGamePlayer2().setHand(hand);

                    break;
            }
            abilitySwitch(game, listView, card);
        }

    }

    private void abilitySwitch(Game game, ListView listView, Card card) {
        Ability ability = card.getAbility();
        if (ability != null) {
            switch (ability) {
                case Muster:
                    muster(game, listView);
                    break;
                case Medic:
                    medic(game, listView);
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
                    mardoeme(game, listView, card);
                    break;
                default:
                    break;
            }
        }
    }

    private Card boostSwitch(Game game, ListView<Card> listView) {
        switch (listView.getId()) {
            case "firstPlayerSiegeList" :
                return game.getGamePlayer1().getMarCoSiege();
            case "firstPlayerCloseCombatList" :
                return game.getGamePlayer1().getMarCoCloseCombat();
            case "firstPlayerRangedList" :
                return game.getGamePlayer1().getMarCoRangedCombat();
            case "secondPlayerSiegeList" :
                return game.getGamePlayer2().getMarCoSiege();
            case "secondPlayerCloseCombatList" :
                return game.getGamePlayer2().getMarCoCloseCombat();
            case "secondPlayerRangedList" :
                return game.getGamePlayer2().getMarCoRangedCombat();
            default:
                return null;
        }

    }


    private void commandersHorn(Game game, ListView<Card> listView, Card card) {
        HashMap<Card, List<Integer>> cardScores = rowSwitch(game, listView);
        ObservableList<Card> list = rowSwitchList(game, listView);
        Card boost = boostSwitch(game, listView);
        int cmTotal = 0;
        for (Card card1 : list) {
            if (card1.getAbility() != null && card1.getAbility().equals(Ability.CommandersHorn)) cmTotal++;
        }
        if (cmTotal == 1 && (boost == null || boost.equals(Card.getCardByID(607)))){
            for (Card card2 : cardScores.keySet()) {
                if (!card2.isHero() && !card2.equals(card) ) {
                    List<Integer> scores = cardScores.get(card2);
                    for (int i = 0; i < scores.size(); i++) {
                        int score = scores.get(i) * 2;
                        scores.set(i, score);
                    }
                    setHashMap(game, listView, cardScores);
                }
            }
        }
    }

    private void tightBond(Game game, ListView<Card> listView, Card thrownCard) {
        HashMap<Card, List<Integer>> cardScores = rowSwitch(game, listView);
        List<Integer> thrownCardScores = cardScores.get(thrownCard);
        int sum = 0;
        for (Integer score : thrownCardScores) {
            sum += score;
        }

        for (int i = 0; i < thrownCardScores.size(); i++) {
            thrownCardScores.set(i, sum);
        }

        cardScores.put(thrownCard, thrownCardScores);
        setHashMap(game, listView, cardScores);
    }

    private void medic(Game game, ListView listView) {
        User user = game.getActivePlayer();
        ObservableList<Card> burnedCards;
        ObservableList<Card> hand;

        if (user.equals(game.getPlayer1())) {
            burnedCards = game.getGamePlayer1().getBurnedCards();
            if (burnedCards.isEmpty()) {
                return;
            }
            Random random = new Random();
            int randomIndex = random.nextInt(burnedCards.size());
            Card card = burnedCards.get(randomIndex);
            hand = game.getGamePlayer1().getHand();
            hand.add(card);
            game.getGamePlayer1().setHand(hand);
            burnedCards.remove(card);
            game.getGamePlayer1().setBurnedCards(burnedCards);
        }
        if (user.equals(game.getPlayer2())) {
            burnedCards = game.getGamePlayer2().getBurnedCards();
            if (burnedCards.isEmpty()) {
                return;
            }
            Random random = new Random();
            int randomIndex = random.nextInt(burnedCards.size());
            Card card = burnedCards.get(randomIndex);
            hand = game.getGamePlayer2().getHand();
            hand.add(card);
            game.getGamePlayer2().setHand(hand);
            burnedCards.remove(card);
            game.getGamePlayer2().setBurnedCards(burnedCards);
        }
    }

    private void setHashMap(Game game, ListView<Card> listView, HashMap<Card, List<Integer>> cardScores) {
        switch (listView.getId()) {
            case "firstPlayerCloseCombatList":
                game.getGamePlayer1().setCloseCombatScores(cardScores);
                break;
            case "firstPlayerRangedList":
                game.getGamePlayer1().setRangedCombatScores(cardScores);
                break;
            case "firstPlayerSiegeList":
                game.getGamePlayer1().setSiegeScores(cardScores);
                break;
            case "secondPlayerCloseCombatList":
                game.getGamePlayer2().setCloseCombatScores(cardScores);
                break;
            case "secondPlayerRangedList":
                game.getGamePlayer2().setRangedCombatScores(cardScores);
                break;
            case "secondPlayerSiegeList":
                game.getGamePlayer2().setSiegeScores(cardScores);
                break;
            default:
                break;
        }
    }

    private HashMap<Card, List<Integer>> rowSwitch(Game game, ListView listView) {
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

    private ObservableList<Card> rowSwitchList(Game game, ListView listView) {
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        switch (listView.getId()) {
            case "firstPlayerSiegeList":
                return firstPlayerGame.getSiege();
            case "firstPlayerRangedList":
                return firstPlayerGame.getRangedCombat();
            case "firstPlayerCloseCombatList":
                return firstPlayerGame.getCloseCombat();
            case "secondPlayerCloseCombatList":
                return secondPlayerGame.getCloseCombat();
            case "secondPlayerRangedList":
                return secondPlayerGame.getRangedCombat();
            case "secondPlayerSiegeList":
                return secondPlayerGame.getSiege();
            default:
                break;
        }
        return null;
    }
    private void muster(Game game, ListView listView) {
        User user = game.getActivePlayer();
        HashMap<Card, Integer> deck;
        ObservableList<Card> hand;

        if (user.equals(game.getPlayer1())) {
            hand = game.getGamePlayer1().getHand();
            deck = game.getGamePlayer1().getDeck();

            Iterator<Card> iterator = hand.iterator();
            while (iterator.hasNext()) {
                Card card = iterator.next();
                if (card.getAbility() != null && card.getAbility().equals(Ability.Muster)) {
                    deck.put(card, deck.getOrDefault(card, 0) + 1);
                    iterator.remove();
                }
            }
            game.getGamePlayer1().setHand(hand);

            for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
                Card currentCard = entry.getKey();
                Integer count = entry.getValue();
                if (currentCard.getAbility() == null || !currentCard.getAbility().equals(Ability.Muster)) continue;

                ObservableList<Card> siegeList = game.getGamePlayer1().getSiege();
                ObservableList<Card> rangedList = game.getGamePlayer1().getRangedCombat();
                ObservableList<Card> closeCombatList = game.getGamePlayer1().getCloseCombat();

                switch (currentCard.getPosition()) {
                    case siege:
                        HashMap<Card, List<Integer>> cardScores = game.getGamePlayer1().getSiegeScores();
                        List<Integer> scores = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            scores.add(currentCard.getPower());
                        }
                        cardScores.put(currentCard, scores);
                        siegeList.add(currentCard);
                        game.getGamePlayer1().setSiegeScores(cardScores);
                        break;
                    case closeCombat:
                        cardScores = game.getGamePlayer1().getCloseCombatScores();
                        scores = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            scores.add(currentCard.getPower());
                        }
                        cardScores.put(currentCard, scores);
                        closeCombatList.add(currentCard);
                        game.getGamePlayer1().setCloseCombatScores(cardScores);
                        break;
                    case rangedCombat:
                        cardScores = game.getGamePlayer1().getRangedCombatScores();
                        scores = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            scores.add(currentCard.getPower());
                        }
                        cardScores.put(currentCard, scores);
                        rangedList.add(currentCard);
                        game.getGamePlayer1().setRangedCombatScores(cardScores);
                        break;
                }

                game.getGamePlayer1().setSiege(siegeList);
                game.getGamePlayer1().setRangedCombat(rangedList);
                game.getGamePlayer1().setCloseCombat(closeCombatList);
            }

        } else {
            hand = game.getGamePlayer2().getHand();
            deck = game.getGamePlayer2().getDeck();

            Iterator<Card> iterator = hand.iterator();
            while (iterator.hasNext()) {
                Card card = iterator.next();
                if (card.getAbility() != null && card.getAbility().equals(Ability.Muster)) {
                    deck.put(card, deck.getOrDefault(card, 0) + 1);
                    iterator.remove();
                }
            }
            game.getGamePlayer2().setHand(hand);

            for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
                Card currentCard = entry.getKey();
                Integer count = entry.getValue();
                if (currentCard.getAbility() == null || !currentCard.getAbility().equals(Ability.Muster)) continue;

                ObservableList<Card> siegeList = game.getGamePlayer2().getSiege();
                ObservableList<Card> rangedList = game.getGamePlayer2().getRangedCombat();
                ObservableList<Card> closeCombatList = game.getGamePlayer2().getCloseCombat();

                switch (currentCard.getPosition()) {
                    case siege:
                        HashMap<Card, List<Integer>> cardScores = game.getGamePlayer2().getSiegeScores();
                        List<Integer> scores = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            scores.add(currentCard.getPower());
                        }
                        cardScores.put(currentCard, scores);
                        siegeList.add(currentCard);
                        game.getGamePlayer2().setSiegeScores(cardScores);
                        break;
                    case closeCombat:
                        cardScores = game.getGamePlayer2().getCloseCombatScores();
                        scores = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            scores.add(currentCard.getPower());
                        }
                        cardScores.put(currentCard, scores);
                        closeCombatList.add(currentCard);
                        game.getGamePlayer2().setCloseCombatScores(cardScores);
                        break;
                    case rangedCombat:
                        cardScores = game.getGamePlayer2().getRangedCombatScores();
                        scores = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            scores.add(currentCard.getPower());
                        }
                        cardScores.put(currentCard, scores);
                        rangedList.add(currentCard);
                        game.getGamePlayer2().setRangedCombatScores(cardScores);
                        break;
                }

                game.getGamePlayer2().setSiege(siegeList);
                game.getGamePlayer2().setRangedCombat(rangedList);
                game.getGamePlayer2().setCloseCombat(closeCombatList);
            }
        }
    }

    private void moralBoost(Game game, ListView<Card> listView, Card card) {
        HashMap<Card, List<Integer>> cardScores = new HashMap<>();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        switch (listView.getId()) {
            case "firstPlayerSiegeList":
                cardScores = firstPlayerGame.getSiegeScores();
                for (Card card1 : cardScores.keySet()) {
                    List<Integer> scores = cardScores.get(card1);

                    if (!(card1.isHero() || card1.equals(card))) {
                        for (int i = 0; i < scores.size(); i++) {
                            scores.set(i, scores.get(i) + 1);
                        }
                        cardScores.put(card1, scores);
                    }
                }
                firstPlayerGame.setSiegeScores(cardScores);
                break;
            case "firstPlayerRangedList":
                cardScores = firstPlayerGame.getRangedCombatScores();
                for (Card card1 : cardScores.keySet()) {
                    List<Integer> scores = cardScores.get(card1);

                    if (!(card1.isHero() || card1.equals(card))) {
                        for (int i = 0; i < scores.size(); i++) {
                            scores.set(i, scores.get(i) + 1);
                        }
                        cardScores.put(card1, scores);
                    }
                }
                firstPlayerGame.setRangedCombatScores(cardScores);
                break;
            case "firstPlayerCloseCombatList":
                cardScores = firstPlayerGame.getCloseCombatScores();
                for (Card card1 : cardScores.keySet()) {
                    List<Integer> scores = cardScores.get(card1);

                    if (!(card1.isHero() || card1.equals(card))) {
                        for (int i = 0; i < scores.size(); i++) {
                            scores.set(i, scores.get(i) + 1);
                        }
                        cardScores.put(card1, scores);
                    }
                }
                firstPlayerGame.setCloseCombatScores(cardScores);
                break;
            case "secondPlayerCloseCombatList":
                cardScores = secondPlayerGame.getCloseCombatScores();
                for (Card card1 : cardScores.keySet()) {
                    List<Integer> scores = cardScores.get(card1);

                    if (!(card1.isHero() || card1.equals(card))) {
                        for (int i = 0; i < scores.size(); i++) {
                            scores.set(i, scores.get(i) + 1);
                        }
                        cardScores.put(card1, scores);
                    }
                }
                secondPlayerGame.setCloseCombatScores(cardScores);
                break;
            case "secondPlayerRangedList":
                cardScores = secondPlayerGame.getRangedCombatScores();
                for (Card card1 : cardScores.keySet()) {
                    List<Integer> scores = cardScores.get(card1);

                    if (!(card1.isHero() || card1.equals(card))) {
                        for (int i = 0; i < scores.size(); i++) {
                            scores.set(i, scores.get(i) + 1);
                        }
                        cardScores.put(card1, scores);
                    }
                }
                secondPlayerGame.setRangedCombatScores(cardScores);
                break;
            case "secondPlayerSiegeList":
                cardScores = secondPlayerGame.getSiegeScores();
                for (Card card1 : cardScores.keySet()) {
                    List<Integer> scores = cardScores.get(card1);

                    if (!(card1.isHero() || card1.equals(card))) {
                        for (int i = 0; i < scores.size(); i++) {
                            scores.set(i, scores.get(i) + 1);
                        }
                        cardScores.put(card1, scores);
                    }
                }
                secondPlayerGame.setSiegeScores(cardScores);
                break;
            default:
                break;
        }


    }

    private void scorch(Game game, ListView listView, Card card) {
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();
        ObservableList<Card> firstPlayerCloseCombat = firstPlayerGame.getCloseCombat();
        HashMap<Card, List<Integer>> firstPlayerCloseCombatScores = firstPlayerGame.getCloseCombatScores();
        ObservableList<Card> firstPlayerRangedCombat = firstPlayerGame.getRangedCombat();
        HashMap<Card, List<Integer>> firstPlayerRangedCombatScores = firstPlayerGame.getRangedCombatScores();
        ObservableList<Card> firstPlayerSiege = firstPlayerGame.getSiege();
        HashMap<Card, List<Integer>> firstPlayerSiegeScores = firstPlayerGame.getSiegeScores();
        ObservableList<Card> secondPlayerCloseCombat = secondPlayerGame.getCloseCombat();
        HashMap<Card, List<Integer>> secondPlayerCloseCombatScores = secondPlayerGame.getCloseCombatScores();
        ObservableList<Card> secondPlayerRangedCombat = secondPlayerGame.getRangedCombat();
        HashMap<Card, List<Integer>> secondPlayerRangedCombatScores = secondPlayerGame.getRangedCombatScores();
        ObservableList<Card> secondPlayerSiege = secondPlayerGame.getSiege();
        HashMap<Card, List<Integer>> secondPlayerSiegeScores = secondPlayerGame.getSiegeScores();

        int highestScore = 0;

        HashMap<Card, List<Integer>> cardScores = new HashMap<>();
        if (!card.isSpecial()) {
            switch (listView.getId()) {
                case "firstPlayerSiegeList":
                    highestScore = findHighestScore(highestScore, firstPlayerSiege, firstPlayerSiegeScores);
                    removeCardWithHighestScore(firstPlayerSiege, firstPlayerSiegeScores, highestScore);
                    break;
                case "firstPlayerRangedList":
                    highestScore = findHighestScore(highestScore, firstPlayerRangedCombat, firstPlayerRangedCombatScores);
                    removeCardWithHighestScore(firstPlayerRangedCombat, firstPlayerRangedCombatScores, highestScore);
                    break;
                case "firstPlayerCloseCombatList":
                    highestScore = findHighestScore(highestScore, firstPlayerCloseCombat, firstPlayerCloseCombatScores);
                    removeCardWithHighestScore(firstPlayerCloseCombat, firstPlayerCloseCombatScores, highestScore);
                    break;
                case "secondPlayerCloseCombatList":
                    highestScore = findHighestScore(highestScore, secondPlayerCloseCombat, secondPlayerCloseCombatScores);
                    removeCardWithHighestScore(secondPlayerCloseCombat, secondPlayerCloseCombatScores, highestScore);
                    break;
                case "secondPlayerRangedList":
                    highestScore = findHighestScore(highestScore, secondPlayerRangedCombat, secondPlayerRangedCombatScores);
                    removeCardWithHighestScore(secondPlayerRangedCombat, secondPlayerRangedCombatScores, highestScore);
                    break;
                case "secondPlayerSiegeList":
                    highestScore = findHighestScore(highestScore, secondPlayerSiege, secondPlayerSiegeScores);
                    removeCardWithHighestScore(secondPlayerSiege, secondPlayerSiegeScores, highestScore);
                    break;
                default:
                    break;
            }
        } else {
            highestScore = findHighestScore(highestScore, firstPlayerCloseCombat, firstPlayerCloseCombatScores);
            highestScore = findHighestScore(highestScore, firstPlayerRangedCombat, firstPlayerRangedCombatScores);
            highestScore = findHighestScore(highestScore, firstPlayerSiege, firstPlayerSiegeScores);
            highestScore = findHighestScore(highestScore, secondPlayerCloseCombat, secondPlayerCloseCombatScores);
            highestScore = findHighestScore(highestScore, secondPlayerRangedCombat, secondPlayerRangedCombatScores);
            highestScore = findHighestScore(highestScore, secondPlayerSiege, secondPlayerSiegeScores);

            removeCardWithHighestScore(firstPlayerSiege, firstPlayerSiegeScores, highestScore);
            removeCardWithHighestScore(firstPlayerRangedCombat, firstPlayerRangedCombatScores, highestScore);
            removeCardWithHighestScore(firstPlayerCloseCombat, firstPlayerCloseCombatScores, highestScore);
            removeCardWithHighestScore(secondPlayerCloseCombat, secondPlayerCloseCombatScores, highestScore);
            removeCardWithHighestScore(secondPlayerRangedCombat, secondPlayerRangedCombatScores, highestScore);
            removeCardWithHighestScore(secondPlayerSiege, secondPlayerSiegeScores, highestScore);
        }
    }

    private void removeCardWithHighestScore(ObservableList<Card> list, HashMap<Card, List<Integer>> scores, int highestScore) {
        Iterator<Card> iterator = list.iterator();

        while (iterator.hasNext()) {
            Card card = iterator.next();
            List<Integer> values = scores.get(card);

            if (values != null && values.contains(highestScore)) {
                values.remove(Integer.valueOf(highestScore));

                if (values.isEmpty()) {
                    scores.remove(card);
                    iterator.remove();
                    addToBurnedCard(User.getLoggedInUser().getCurrentGame(), card);
                } else {
                    scores.put(card, values);
                }
            }
        }
    }


    private int findHighestScore(int highestScore, ObservableList<Card> cards, HashMap<Card, List<Integer>> cardsScore) {
        for (Card card : cards) {
            int maxScore = cardsScore.get(card).stream().max(Integer::compare).orElse(0);
            if (maxScore > highestScore) {
                highestScore = maxScore;
            }
        }
        return highestScore;
    }

    private void mardoeme(Game game, ListView listView, Card card) {
        HashMap<Card, List<Integer>> cardScores;
        ObservableList<Card> list;
        ObservableList<Card> copyList;

        if (game.getPlayer1().equals(game.getActivePlayer())) {
            cardScores = game.getGamePlayer1().getRangedCombatScores();
            list = game.getGamePlayer1().getRangedCombat();
            copyList = FXCollections.observableArrayList(list);

            for (Card card1 : copyList) {
                if (card1.equals(Card.getCardByID(117))) {
                    list.remove(card1);
                    list.add(Card.getCardByID(118));
                }
            }

            if (copyList.contains(Card.getCardByID(117))) {
                int count = cardScores.get(Card.getCardByID(117)).size();
                List<Integer> scores = cardScores.get(Card.getCardByID(117));
                cardScores.remove(Card.getCardByID(117));
                scores = new ArrayList<>(Collections.nCopies(count, 8));
                cardScores.put(Card.getCardByID(118), scores);
            }

            game.getGamePlayer1().setRangedCombat(list);
            game.getGamePlayer1().setRangedCombatScores(cardScores);
        } else {
            cardScores = game.getGamePlayer2().getRangedCombatScores();
            list = game.getGamePlayer2().getRangedCombat();
            copyList = FXCollections.observableArrayList(list);

            for (Card card1 : copyList) {
                if (card1.equals(Card.getCardByID(117))) {
                    list.remove(card1);
                    list.add(Card.getCardByID(118));
                }
            }

            if (copyList.contains(Card.getCardByID(117))) {
                int count = cardScores.get(Card.getCardByID(117)).size();
                List<Integer> scores = cardScores.get(Card.getCardByID(117));
                cardScores.remove(Card.getCardByID(117));
                scores = new ArrayList<>(Collections.nCopies(count, 8));
                cardScores.put(Card.getCardByID(118), scores);
            }

            game.getGamePlayer2().setRangedCombat(list);
            game.getGamePlayer2().setRangedCombatScores(cardScores);
        }
    }

    private void spy(Game game, ListView<Card> listView, Card card) {
        EachPlayerGame activePlayerGame;
        if (game.getActivePlayer().equals(game.getPlayer1())) {
            activePlayerGame = game.getGamePlayer1();
        } else {
            activePlayerGame = game.getGamePlayer2();
        }

        HashMap<Card, Integer> deck = activePlayerGame.getDeck();
        ObservableList<Card> hand = activePlayerGame.getHand();

        List<Card> deckCards = new ArrayList<>();
        for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                deckCards.add(entry.getKey());
            }
        }

        if (deckCards.size() < 2) {
            hand.addAll(deckCards);
            deck.clear();
        } else {
            for (int i = 0; i < 2; i++) {
                int randomIndex = (int) (Math.random() * deckCards.size());
                Card randomCard = deckCards.get(randomIndex);

                hand.add(randomCard);

                if (deck.containsKey(randomCard)) {
                    int count = deck.get(randomCard);
                    if (count > 1) {
                        deck.put(randomCard, count - 1);
                    } else {
                        deck.remove(randomCard);
                    }
                }
                deckCards.remove(randomIndex);
            }
        }
        activePlayerGame.setDeck(deck);
        activePlayerGame.setHand(hand);
    }


    private void addToBurnedCard(Game game, Card card) {
        User user = game.getActivePlayer();
        ObservableList<Card> burnedCard = null;
        if (user.equals(game.getPlayer1())) {
            burnedCard = game.getGamePlayer1().getBurnedCards();
            burnedCard.add(card);
        }
        if (user.equals(game.getPlayer2())) {
            burnedCard = game.getGamePlayer2().getBurnedCards();
            burnedCard.add(card);
        }
    }

    private void spell(Game game, ImageView imageView, Card card) {
        String Id = imageView.getId();
        ObservableList<Card> hand;

        User user = game.getActivePlayer();
        Image image;
        if (user.equals(game.getPlayer1())){
            switch (Id) {
                case "firstPlayerCloseCombatBoost":
                    hand = game.getGamePlayer1().getHand();
                    ObservableList<Card> finalHand = hand;
                    finalHand.remove(card);
                    game.getGamePlayer1().setHand(finalHand);
                    game.getGamePlayer1().setMarCoCloseCombat(card);
                    break;
                case "firstPlayerRangedBoost":
                    hand = game.getGamePlayer1().getHand();
                    finalHand = hand;
                    finalHand.remove(card);
                    game.getGamePlayer1().setHand(finalHand);
                    game.getGamePlayer1().setMarCoRangedCombat(card);
                    break;
                case "firstPlayerSiegeBoost":
                    hand = game.getGamePlayer1().getHand();
                    finalHand = hand;
                    finalHand.remove(card);
                    game.getGamePlayer1().setHand(finalHand);
                    game.getGamePlayer1().setMarCoSiege(card);
                    break;
            }
        } else{
            switch (Id){
                case "secondPlayerSiegeBoost":
                    hand = game.getGamePlayer2().getHand();
                    ObservableList<Card> finalHand = hand;
                    finalHand.remove(card);
                    game.getGamePlayer2().setHand(finalHand);
                    game.getGamePlayer2().setMarCoSiege(card);
                    break;
                case "secondPlayerCloseCombatBoost":
                    hand = game.getGamePlayer2().getHand();
                    finalHand = hand;
                    finalHand.remove(card);
                    game.getGamePlayer2().setHand(finalHand);
                    game.getGamePlayer2().setMarCoCloseCombat(card);
                    break;
                case "secondPlayerRangedBoost":
                    hand = game.getGamePlayer2().getHand();
                    finalHand = hand;
                    finalHand.remove(card);
                    game.getGamePlayer2().setHand(finalHand);
                    game.getGamePlayer2().setMarCoRangedCombat(card);
                    break;
            }

        }
        switch (card.getName()) {
            case "Mardoeme":
                mardoeme(game, Id, imageView, card);
                break;
            case "Commander's Horn":
                commandersHorn(game, Id, imageView, card);
                break;
        }

    }

    private void commandersHorn(Game game, String id, ImageView imageView, Card card) {
        HashMap<Card, List<Integer>> cardScores;
        List<Card> list;

        switch (id) {
            case "firstPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer1().getCloseCombatScores();
                list = game.getGamePlayer1().getCloseCombat();
                cardScores = X2(cardScores, list);
                game.getGamePlayer1().setCloseCombatScores(cardScores);
                break;
            case "firstPlayerRangedBoost":
                cardScores = game.getGamePlayer1().getRangedCombatScores();
                list = game.getGamePlayer1().getRangedCombat();
                cardScores = X2(cardScores, list);
                game.getGamePlayer1().setRangedCombatScores(cardScores);
                break;
            case "firstPlayerSiegeBoost":
                cardScores = game.getGamePlayer1().getSiegeScores();
                list = game.getGamePlayer1().getSiege();
                cardScores = X2(cardScores, list);
                game.getGamePlayer1().setSiegeScores(cardScores);
                break;
            case "secondPlayerSiegeBoost":
                cardScores = game.getGamePlayer2().getSiegeScores();
                list = game.getGamePlayer2().getSiege();
                cardScores = X2(cardScores, list);
                game.getGamePlayer2().setSiegeScores(cardScores);
                break;
            case "secondPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer2().getCloseCombatScores();
                list = game.getGamePlayer2().getCloseCombat();
                cardScores = X2(cardScores, list);
                game.getGamePlayer2().setCloseCombatScores(cardScores);
                break;
            case "secondPlayerRangedBoost":
                cardScores = game.getGamePlayer2().getRangedCombatScores();
                list = game.getGamePlayer2().getRangedCombat();
                cardScores = X2(cardScores, list);
                game.getGamePlayer2().setRangedCombatScores(cardScores);
                break;
        }
    }

    private HashMap<Card, List<Integer>> X2(HashMap<Card, List<Integer>> cardScores, List<Card> list) {
        boolean hasCommandersHorn = (list.contains(Card.getCardByID(609)) || list.contains(Card.getCardByID(121)));

        for (Card card : cardScores.keySet()) {
            List<Integer> scores = cardScores.get(card);
            if (hasCommandersHorn) {
                if (card.equals(Card.getCardByID(609)) || card.equals(Card.getCardByID(121))) {
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
            } else {
                if (!card.isHero()) {
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
            }
            cardScores.put(card, scores);
        }
        return cardScores;
    }

    private void mardoeme(Game game, String id, ImageView imageView, Card card) {
        HashMap<Card, List<Integer>> cardScores;
        ObservableList<Card> list;
        ObservableList<Card> copyList;

        switch (id) {
            case "firstPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer1().getCloseCombatScores();
                list = game.getGamePlayer1().getCloseCombat();
                copyList = FXCollections.observableArrayList(list); // Create a copy of the list

                for (Card card1 : copyList) {
                    if (card1.equals(Card.getCardByID(102))) {
                        list.remove(card1);
                        list.add(Card.getCardByID(103));
                    }
                }

                if (copyList.contains(Card.getCardByID(102))) {
                    int count = cardScores.get(Card.getCardByID(102)).size();
                    List<Integer> scores = cardScores.get(Card.getCardByID(102));
                    cardScores.remove(Card.getCardByID(102));
                    scores = new ArrayList<>(Collections.nCopies(count, 8)); // Create a new list with '8's
                    cardScores.put(Card.getCardByID(103), scores);
                }

                game.getGamePlayer1().setCloseCombat(list);
                game.getGamePlayer1().setCloseCombatScores(cardScores);

                break;
            case "firstPlayerRangedBoost":
                cardScores = game.getGamePlayer1().getRangedCombatScores();
                list = game.getGamePlayer1().getRangedCombat();
                copyList = FXCollections.observableArrayList(list);

                for (Card card1 : copyList) {
                    if (card1.equals(Card.getCardByID(117))) {
                        list.remove(card1);
                        list.add(Card.getCardByID(118));
                    }
                }

                if (copyList.contains(Card.getCardByID(117))) {
                    int count = cardScores.get(Card.getCardByID(117)).size();
                    List<Integer> scores = cardScores.get(Card.getCardByID(117));
                    cardScores.remove(Card.getCardByID(117));
                    scores = new ArrayList<>(Collections.nCopies(count, 8));
                    cardScores.put(Card.getCardByID(118), scores);
                }

                game.getGamePlayer1().setRangedCombat(list);
                game.getGamePlayer1().setRangedCombatScores(cardScores);

                break;
            case "secondPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer2().getCloseCombatScores();
                list = game.getGamePlayer2().getCloseCombat();
                copyList = FXCollections.observableArrayList(list);

                for (Card card1 : copyList) {
                    if (card1.equals(Card.getCardByID(102))) {
                        list.remove(card1);
                        list.add(Card.getCardByID(103));
                    }
                }

                if (copyList.contains(Card.getCardByID(102))) {
                    int count = cardScores.get(Card.getCardByID(102)).size();
                    List<Integer> scores = cardScores.get(Card.getCardByID(102));
                    cardScores.remove(Card.getCardByID(102));
                    scores = new ArrayList<>(Collections.nCopies(count, 8));
                    cardScores.put(Card.getCardByID(103), scores);
                }

                game.getGamePlayer2().setCloseCombat(list);
                game.getGamePlayer2().setCloseCombatScores(cardScores);

                break;
            case "secondPlayerRangedBoost":
                cardScores = game.getGamePlayer2().getRangedCombatScores();
                list = game.getGamePlayer2().getRangedCombat();
                copyList = FXCollections.observableArrayList(list);

                for (Card card1 : copyList) {
                    if (card1.equals(Card.getCardByID(117))) {
                        list.remove(card1);
                        list.add(Card.getCardByID(118));
                    }
                }

                if (copyList.contains(Card.getCardByID(117))) {
                    int count = cardScores.get(Card.getCardByID(117)).size();
                    List<Integer> scores = cardScores.get(Card.getCardByID(117));
                    cardScores.remove(Card.getCardByID(117));
                    scores = new ArrayList<>(Collections.nCopies(count, 8));
                    cardScores.put(Card.getCardByID(118), scores);
                }

                game.getGamePlayer2().setRangedCombat(list);
                game.getGamePlayer2().setRangedCombatScores(cardScores);

                break;
        }
    }


    private void weather(Game game, ImageView imageView, Card card) {
        User user = game.getActivePlayer();
        Image image = card.getImage();
        gameMenuController.weatherCard.setImage(image);
        gameMenuController.weatherCard.setImage(card.getImage());

        if (user.equals(game.getPlayer1())) {
            ObservableList<Card> hand1 = game.getGamePlayer1().getHand();
            hand1.remove(card);
            game.getGamePlayer1().setHand(hand1);
        }
        else {
            ObservableList<Card> hand2 = game.getGamePlayer1().getHand();
            hand2.remove(card);
            game.getGamePlayer2().setHand(hand2);
            game.setWeatherCard(card);
        }

        game.setWeatherCard(card);

    }


//    private void addToHand(Game game, Card card) {
//        User user = game.getActivePlayer();
//        ObservableList<Card> hand;
//        ObservableList<Card> burnedCard = null;
//        if (user.equals(game.getPlayer1())) {
//            hand = game.getGamePlayer1().getHand();
//            hand.add(card);
//            burnedCard = game.getGamePlayer1().getBurnedCards();
//            burnedCard.remove(card);
//        }
//        if (user.equals(game.getPlayer2())) {
//            hand = game.getGamePlayer2().getHand();
//            hand.add(card);
//            burnedCard = game.getGamePlayer2().getBurnedCards();
//            burnedCard.remove(card);
//        }
//    }

    //3 method for transfer spell weather


}