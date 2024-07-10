package controller;

import enums.Ability;
import enums.CardType;
import enums.Place;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
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
                    if (!card.isHero() && scoresList.keySet().stream()
                            .anyMatch(c -> c.getAbility() != null && c.getAbility().equals(Ability.CommandersHorn))) {
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
                    if (!card.isHero() && scoresList.keySet().stream()
                            .anyMatch(c -> c.getAbility() != null && c.getAbility().equals(Ability.CommandersHorn))) {
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
                    if (!card.isHero() && scoresList.keySet().stream()
                            .anyMatch(c -> c.getAbility() != null && c.getAbility().equals(Ability.CommandersHorn))) {
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
                    if (!card.isHero() && scoresList.keySet().stream()
                            .anyMatch(c -> c.getAbility() != null && c.getAbility().equals(Ability.CommandersHorn))) {
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
                    if (!card.isHero() && scoresList.keySet().stream()
                            .anyMatch(c -> c.getAbility() != null && c.getAbility().equals(Ability.CommandersHorn))) {
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
                    ObservableList<Card> rangedList = game.getGamePlayer2().getRangedCombat();
                    HashMap<Card, List<Integer>> rangedScores = game.getGamePlayer2().getRangedCombatScores();
                    rangedList.add(card);

                    if (card.getAbility() != null) {
                        boolean hasCommandersHorn = rangedList.stream()
                                .filter(cards -> cards.getAbility() != null)
                                .anyMatch(cards -> cards.getAbility().equals(Ability.CommandersHorn));
                        rangedScores.computeIfAbsent(card, k -> new ArrayList<>()).add(hasCommandersHorn ? card.getPower() * 2 : card.getPower());
                    }
                    game.getGamePlayer2().setRangedCombat(rangedList);
                    game.getGamePlayer2().setRangedCombatScores(rangedScores);

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
                    mardroeme(game, listView, card);
                    break;
                default:
                    break;
            }
        }
    }


    private void commandersHorn(Game game, ListView<Card> listView, Card card) {
        HashMap<Card, List<Integer>> cardScores = rowSwitch(game, listView);
        Boolean isThereCH = false;
        for (Card card1 : cardScores.keySet()) {
            if (card1.getAbility() == null) continue;
            if (card1.getAbility().equals(Ability.CommandersHorn)) isThereCH = true;
        }
        if (!isThereCH){
            for (Card card2 : cardScores.keySet()) {
                List<Integer> scores = cardScores.get(card2);

                if (card2.isHero() || card2.equals(card)) {
                    continue;
                }

                for (int i = 0; i < scores.size(); i++) {
                    scores.set(i, scores.get(i) * 2);
                }
                setHashMap(game, listView, cardScores);
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

    private void muster(Game game, ListView listView) {
        User user = game.getActivePlayer();
        HashMap<Card, Integer> deck;
        ObservableList<Card> hand;
        if (user.equals(game.getPlayer1())) {
            hand = game.getGamePlayer1().getHand();
            deck = game.getGamePlayer1().getDeck();
            for (Card card : hand) {
                if (card.getAbility() != null) {
                    if (card.getAbility().name().equals("muster")) {
                        deck.put(card, 1);
                        hand.remove(card);
                        game.getGamePlayer1().setHand(hand);
                    }
                }
            }
            for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
                Card currentCard = entry.getKey();
                Integer count = entry.getValue();
                if (currentCard.getAbility() == null) continue;
                if (!currentCard.getAbility().name().equals("muster")) continue;


                for (int i = 0; i < count; i++) {
                    Place place = currentCard.getPlace();
                    switch (place) {
                        case agile:
                            //we have two choices
                            break;
                        case rangedCombat:
                            ObservableList<Card> rangedList = game.getGamePlayer1().getRangedCombat();
                            HashMap<Card, List<Integer>> rangedScores = game.getGamePlayer1().getRangedCombatScores();
                            rangedList.add(currentCard);
                            boolean hasCommandersHorn = rangedList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));
                            rangedScores.computeIfAbsent(currentCard, k -> new ArrayList<>()).add(hasCommandersHorn ? currentCard.getPower() * 2 : currentCard.getPower());
                            game.getGamePlayer1().setRangedCombat(rangedList);

                            break;
                        case closeCombat:
                            ObservableList<Card> closeCombatList = game.getGamePlayer1().getCloseCombat();
                            HashMap<Card, List<Integer>> closeCombatScores = game.getGamePlayer1().getCloseCombatScores();
                            closeCombatList.add(currentCard);
                            hasCommandersHorn = closeCombatList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));
                            closeCombatScores.computeIfAbsent(currentCard, k -> new ArrayList<>()).add(hasCommandersHorn ? currentCard.getPower() * 2 : currentCard.getPower());
                            game.getGamePlayer1().setCloseCombat(closeCombatList);

                            break;
                        case siege:
                            ObservableList<Card> siegeList = game.getGamePlayer1().getSiege();
                            HashMap<Card, List<Integer>> siegeScores = game.getGamePlayer1().getSiegeScores();
                            siegeList.add(currentCard);
                            hasCommandersHorn = siegeList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));
                            siegeScores.computeIfAbsent(currentCard, k -> new ArrayList<>()).add(hasCommandersHorn ? currentCard.getPower() * 2 : currentCard.getPower());
                            game.getGamePlayer1().setSiege(siegeList);

                            break;
                    }
                }
            }


        }

        if (user.equals(game.getPlayer2())) {
            hand = game.getGamePlayer2().getHand();
            deck = game.getGamePlayer2().getDeck();
            for (Card card : hand) {
                if (card.getAbility() != null) {
                    if (card.getAbility().name().equals("muster")) {
                        deck.put(card, 1);
                        hand.remove(card);
                        game.getGamePlayer2().setHand(hand);
                    }
                }
            }
            for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
                Card currentCard = entry.getKey();
                Integer count = entry.getValue();
                if (currentCard.getAbility() == null) continue;
                if (!currentCard.getAbility().name().equals("muster")) continue;


                for (int i = 0; i < count; i++) {
                    Place place = currentCard.getPlace();
                    switch (place) {
                        case agile:
                            //we have two choices
                            break;
                        case rangedCombat:
                            ObservableList<Card> rangedList = game.getGamePlayer2().getRangedCombat();
                            HashMap<Card, List<Integer>> rangedScores = game.getGamePlayer2().getRangedCombatScores();
                            rangedList.add(currentCard);

                            boolean hasCommandersHorn = rangedList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                            rangedScores.computeIfAbsent(currentCard, k -> new ArrayList<>()).add(hasCommandersHorn ? currentCard.getPower() * 2 : currentCard.getPower());

                            game.getGamePlayer2().setRangedCombat(rangedList);

                            break;
                        case closeCombat:
                            ObservableList<Card> closeCombatList = game.getGamePlayer2().getCloseCombat();
                            HashMap<Card, List<Integer>> closeCombatScores = game.getGamePlayer2().getCloseCombatScores();
                            closeCombatList.add(currentCard);

                            hasCommandersHorn = closeCombatList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                            closeCombatScores.computeIfAbsent(currentCard, k -> new ArrayList<>()).add(hasCommandersHorn ? currentCard.getPower() * 2 : currentCard.getPower());

                            game.getGamePlayer1().setCloseCombat(closeCombatList);

                            break;
                        case siege:
                            ObservableList<Card> siegeList = game.getGamePlayer2().getSiege();
                            HashMap<Card, List<Integer>> siegeScores = game.getGamePlayer2().getSiegeScores();
                            siegeList.add(currentCard);

                            hasCommandersHorn = siegeList.stream().anyMatch(c -> c.getAbility().equals(Ability.CommandersHorn));

                            siegeScores.computeIfAbsent(currentCard, k -> new ArrayList<>()).add(hasCommandersHorn ? currentCard.getPower() * 2 : currentCard.getPower());

                            game.getGamePlayer1().setSiege(siegeList);

                            break;
                    }
                }
            }


        }

    }

    private void moralBoost(Game game, ListView<Card> listView, Card card) {
        HashMap<Card, List<Integer>> cardScores = rowSwitch(game, listView);

        for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
            Card currentCard = entry.getKey();
            List<Integer> scores = entry.getValue();

            if (currentCard.isHero() || currentCard.equals(card)) {
                continue;
            }

            for (int i = 0; i < scores.size(); i++) {
                scores.set(i, scores.get(i) + 1);
            }
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

    private void mardroeme(Game game, ListView listView, Card card) {
        if (game.getActivePlayer().equals(game.getPlayer1())) {
            ObservableList<Card> list = game.getGamePlayer1().getCloseCombat();
            for (Card card1 : list) {
                if (card1.getName().equals("Berserker")) {
                    HashMap<Card, List<Integer>> cardScores = game.getGamePlayer1().getCloseCombatScores();
                    list.remove(card1);
                    cardScores.remove(card1);
                    game.getGamePlayer1().setCloseCombatScores(cardScores);
                    game.getGamePlayer1().setCloseCombat(list);
                    run(gameMenuController, listView, Card.getCardByName("Vildkaarl"));
                }
            }
            list = game.getGamePlayer1().getRangedCombat();
            for (Card card1 : list) {
                if (card1.getName().equals("YoungBerserker")) {
                    HashMap<Card, List<Integer>> cardScores = game.getGamePlayer1().getRangedCombatScores();
                    list.remove(card1);
                    cardScores.remove(card1);
                    game.getGamePlayer1().setRangedCombatScores(cardScores);
                    game.getGamePlayer1().setRangedCombat(list);
                    run(gameMenuController, listView, Card.getCardByName("YoungVildkaarl"));
                }
            }
        } else {
            ObservableList<Card> list = game.getGamePlayer2().getCloseCombat();
            for (Card card1 : list) {
                if (card1.getName().equals("Berserker")) {
                    HashMap<Card, List<Integer>> cardScores = game.getGamePlayer2().getCloseCombatScores();
                    list.remove(card1);
                    cardScores.remove(card1);
                    game.getGamePlayer2().setCloseCombatScores(cardScores);
                    game.getGamePlayer2().setCloseCombat(list);
                    run(gameMenuController, listView, Card.getCardByName("Vildkaarl"));
                }
            }
            list = game.getGamePlayer2().getRangedCombat();
            for (Card card1 : list) {
                if (card1.getName().equals("YoungBerserker")) {
                    HashMap<Card, List<Integer>> cardScores = game.getGamePlayer2().getRangedCombatScores();
                    list.remove(card1);
                    cardScores.remove(card1);
                    game.getGamePlayer2().setRangedCombatScores(cardScores);
                    game.getGamePlayer2().setRangedCombat(list);
                    run(gameMenuController, listView, Card.getCardByName("YoungVildkaarl"));
                }
            }
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
        User user = game.getActivePlayer();
        String Id = imageView.getId();
        switch (Id) {
            case "firstPlayerCloseCombatBoost":
                Image image = card.getImage();
                imageView.setImage(image);
                ObservableList<Card> hand = game.getGamePlayer1().getHand();
                Platform.runLater(() -> {
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);
                });
                break;
            case "firstPlayerRangedBoost":
            case "firstPlayerSiegeBoost":
                image = card.getImage();
                imageView.setImage(image);
                hand = game.getGamePlayer1().getHand();
                Platform.runLater(() -> {
                    hand.remove(card);
                    game.getGamePlayer1().setHand(hand);
                });
                break;
            case "secondPlayerSiegeBoost":
            case "secondPlayerCloseCombatBoost":
            case "secondPlayerRangedBoost":
                image = card.getImage();
                imageView.setImage(image);
                hand = game.getGamePlayer2().getHand();
                Platform.runLater(() -> {
                    hand.remove(card);
                    game.getGamePlayer2().setHand(hand);
                });
                break;
        }
        if (card.getAbility() != null) {
            switch (card.getAbility()) {
                case Mardoeme:
                    mardoeme(game, Id, imageView, card);
                    break;
                case CommandersHorn:
                    commandersHorn(game, Id, imageView, card);
                    break;
            }
        }

    }

    private void commandersHorn(Game game, String id, ImageView imageView, Card card) {
        HashMap<Card, List<Integer>> cardScores;
        switch (id) {
            case "firstPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer1().getCloseCombatScores();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    List<Integer> scores = entry.getValue();
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
                game.getGamePlayer1().setCloseCombatScores(cardScores);
                break;
            case "firstPlayerRangedBoost":
                cardScores = game.getGamePlayer1().getRangedCombatScores();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    List<Integer> scores = entry.getValue();
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
                game.getGamePlayer1().setRangedCombatScores(cardScores);
            case "firstPlayerSiegeBoost":
                cardScores = game.getGamePlayer1().getSiegeScores();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    List<Integer> scores = entry.getValue();
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
                game.getGamePlayer1().setSiegeScores(cardScores);
                break;
            case "secondPlayerSiegeBoost":
                cardScores = game.getGamePlayer2().getSiegeScores();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    List<Integer> scores = entry.getValue();
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
                game.getGamePlayer2().setSiegeScores(cardScores);
                break;
            case "secondPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer2().getCloseCombatScores();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    List<Integer> scores = entry.getValue();
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
                game.getGamePlayer2().setCloseCombatScores(cardScores);
                break;
            case "secondPlayerRangedBoost":
                cardScores = game.getGamePlayer2().getRangedCombatScores();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    List<Integer> scores = entry.getValue();
                    for (int i = 0; i < scores.size(); i++) {
                        scores.set(i, scores.get(i) * 2);
                    }
                }
                game.getGamePlayer2().setRangedCombatScores(cardScores);
                break;
        }
    }

    private void mardoeme(Game game, String id, ImageView imageView, Card card) {
        HashMap<Card, List<Integer>> cardScores;
        switch (id) {
            case "firstPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer1().getCloseCombatScores();
                ObservableList<Card> list = game.getGamePlayer1().getCloseCombat();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    if (currentCard.getAbility() == Ability.Berserker){
                        list.remove(currentCard);
                        cardScores.remove(currentCard);
                        game.getGamePlayer1().setCloseCombatScores(cardScores);
                        game.getGamePlayer1().setRangedCombat(list);
                        run(gameMenuController, imageView, Card.getCardByName("YoungVildkaarl"));
                    }
                }
                break;
            case "firstPlayerRangedBoost":
                cardScores = game.getGamePlayer1().getRangedCombatScores();
                list = game.getGamePlayer1().getRangedCombat();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    if (currentCard.getAbility() == Ability.Berserker){
                        list.remove(currentCard);
                        cardScores.remove(currentCard);
                        game.getGamePlayer1().setRangedCombatScores(cardScores);
                        game.getGamePlayer1().setRangedCombat(list);
                        run(gameMenuController, imageView, Card.getCardByName("YoungVildkaarl"));
                    }
                }
                break;
            case "firstPlayerSiegeBoost": //B tasir
                break;
            case "secondPlayerSiegeBoost": // B tasir
                break;
            case "secondPlayerCloseCombatBoost":
                cardScores = game.getGamePlayer2().getCloseCombatScores();
                list = game.getGamePlayer2().getCloseCombat();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    if (currentCard.getAbility() == Ability.Berserker){
                        list.remove(currentCard);
                        cardScores.remove(currentCard);
                        game.getGamePlayer2().setCloseCombatScores(cardScores);
                        game.getGamePlayer2().setRangedCombat(list);
                        run(gameMenuController, imageView, Card.getCardByName("YoungVildkaarl"));
                    }
                }
                break;
            case "secondPlayerRangedBoost":
                cardScores = game.getGamePlayer2().getRangedCombatScores();
                list = game.getGamePlayer2().getRangedCombat();
                for (Map.Entry<Card, List<Integer>> entry : cardScores.entrySet()) {
                    Card currentCard = entry.getKey();
                    if (currentCard.isHero() || currentCard.equals(card)) {
                        continue;
                    }
                    if (currentCard.getAbility() == Ability.Berserker){
                        list.remove(currentCard);
                        cardScores.remove(currentCard);
                        game.getGamePlayer2().setRangedCombatScores(cardScores);
                        game.getGamePlayer2().setRangedCombat(list);
                        run(gameMenuController, imageView, Card.getCardByName("YoungVildkaarl"));
                    }
                }
                break;
        }
    }

    private void weather(Game game, ImageView imageView, Card card) {
        User user = game.getActivePlayer();
        gameMenuController.weatherCard.setImage(card.getImage());
        if (user.equals(game.getPlayer1())) {
            ObservableList<Card> hand1 = game.getGamePlayer1().getHand();
                hand1.remove(card);
                game.getGamePlayer1().setHand(hand1);
        }
        else if (user.equals(game.getPlayer2())) {
            ObservableList<Card> hand2 = game.getGamePlayer2().getHand();
                hand2.remove(card);
                game.getGamePlayer2().setHand(hand2);
        }

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