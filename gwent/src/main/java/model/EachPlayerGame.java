package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class EachPlayerGame {

    private ObservableList<Card> hand;
    private SortedList<Card> sortedHand;
    private HashMap<Card, Integer> deck;
    private ObservableList<Card> burnedCards = FXCollections.observableArrayList();
    private ObservableList<Card> closeCombat = FXCollections.observableArrayList();
    private ObservableList<Card> rangedCombat = FXCollections.observableArrayList();
    private ObservableList<Card> siege = FXCollections.observableArrayList();
    private HashMap<Card, List<Integer>> closeCombatScores = new HashMap<>();
    private HashMap<Card, List<Integer>> siegeScores = new HashMap<>();
    private HashMap<Card, List<Integer>> rangedCombatScores = new HashMap<>();
    private User player;
    private Faction faction;
    private int firstRoundScore;
    private int secondRoundScore;
    private int thirdRoundScore;
    private int crystals;
    private int closeCombatScore;
    private int rangedCombatScore;
    private int siegeScore;
    private boolean passedTheGame;
    private boolean isLeaderCardUsed;
    private Card MarCoCloseCombat;
    private Card MarCoRangedCombat;
    private Card MarCoSiege;
    private final Random random = new Random();

    public EachPlayerGame(User player) {
        this.deck = player.getDeck();
        this.player = player;
        faction = player.getFaction();
        this.hand = FXCollections.observableArrayList();
        this.sortedHand = new SortedList<>(hand, Comparator.comparingInt(Card::getPower));
        drawInitialHand();
        passedTheGame = false;
        isLeaderCardUsed = false;
        closeCombatScore = 0;
        rangedCombatScore = 0;
        siegeScore = 0;
        crystals = 2;
    }

    private void drawInitialHand() {
//        int handSize = 10;
//        int totalCardsInDeck = deck.values().stream().mapToInt(Integer::intValue).sum();
//
//        if (totalCardsInDeck < handSize) {
//            throw new IllegalArgumentException("Deck does not contain enough cards to draw an initial hand.");
//        }
//
//        while (handSize > 0) {
//            Card randomCard = getRandomCardFromDeck();
//            int deckCount = deck.get(randomCard) - 1;
//
//            hand.add(randomCard);
//            if (deckCount != 0) deck.put(randomCard, deckCount);
//            else deck.remove(randomCard);
//
//            handSize--;
//        }
                        for (Card card : deck.keySet()) {
                            for (int i = 0; i < deck.get(card); i++) {
                                hand.add(card);
                            }
                        }
                        deck.clear();
    }

    private Card getRandomCardFromDeck() {
        int index = random.nextInt(deck.size());
        int i = 0;
        for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
            if (i == index) {
                return entry.getKey();
            }
            i++;
        }
        throw new IllegalStateException("Unexpected state: failed to get a random card from deck.");
    }

    public int getTotalBoardPower() {
        return getCloseCombatScore() + getRangedCombatScore() + getSiegeScore();
    }

    public ObservableList<Card> getHand() {
        return hand;
    }

    public SortedList<Card> getSortedHand() {
        return hand.sorted(Comparator.comparingInt(Card::getPower));
    }

    public void setHand(ObservableList<Card> hand) {
        this.hand = hand;
        this.sortedHand = new SortedList<>(hand, Comparator.comparingInt(Card::getPower));
    }

    public HashMap<Card, Integer> getDeck() {
        return deck;
    }

    public int getNumberOfCardsInDeck() {
        int total = 0;
        for (Card card : deck.keySet()) {
            total += deck.get(card);
        }
        return total;
    }

    public int getFirstRoundScore() {
        return firstRoundScore;
    }

    public void setFirstRoundScore(int firstRoundScore) {
        this.firstRoundScore = firstRoundScore;
    }

    public int getSecondRoundScore() {
        return secondRoundScore;
    }

    public void setSecondRoundScore(int secondRoundScore) {
        this.secondRoundScore = secondRoundScore;
    }

    public int getThirdRoundScore() {
        return thirdRoundScore;
    }

    public void setThirdRoundScore(int thirdRoundScore) {
        this.thirdRoundScore = thirdRoundScore;
    }

    public void setDeck(HashMap<Card, Integer> deck) {
        this.deck = deck;
    }

    public ObservableList<Card> getBurnedCards() {
        return burnedCards;
    }

    public void setBurnedCards(ObservableList<Card> burnedCards) {
        this.burnedCards = burnedCards;
    }

    public ObservableList<Card> getCloseCombat() {
        return closeCombat;
    }

    public void setCloseCombat(ObservableList<Card> closeCombat) {
        this.closeCombat = closeCombat;
    }

    public ObservableList<Card> getRangedCombat() {
        return rangedCombat;
    }

    public void setRangedCombat(ObservableList<Card> rangedCombat) {
        this.rangedCombat = rangedCombat;
    }

    public ObservableList<Card> getSiege() {
        return siege;
    }

    public void setSiege(ObservableList<Card> siege) {
        this.siege = siege;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public int getCrystals() {
        return crystals;
    }

    public void setCrystals(int crystals) {
        this.crystals = crystals;
    }

    public int getCloseCombatScore() {
        HashMap<Card , List<Integer>> list = closeCombatScores;
        int total = 0;
        for (Card card : list.keySet()) {
            for (Integer score : list.get(card)) {
                total += score;
            }
        }
        return total;
    }

    public int getCloseCombatScoreWithWeather() {
        HashMap<Card , List<Integer>> list = closeCombatScores;
        int total = 0;
        for (Card card : list.keySet()) {
            if (card.isHero()) {
                for (Integer score : list.get(card)) {
                    total += score;
                }
            } else {
                for (int i = 0; i < list.get(card).size(); i++) {
                    total += 1;
                }
            }
        }
        return total;
    }

    public void setCloseCombatScore(int closeCombatScore) {
        this.closeCombatScore = closeCombatScore;
    }

    public int getRangedCombatScore() {
        HashMap<Card , List<Integer>> list = rangedCombatScores;
        int total = 0;
        for (Card card : list.keySet()) {
            for (Integer score : list.get(card)) {
                total += score;
            }
        }
        return total;
    }

    public int getRangedCombatScoreWithWeather() {
        HashMap<Card , List<Integer>> list = rangedCombatScores;
        int total = 0;
        for (Card card : list.keySet()) {
            if (card.isHero()) {
                for (Integer score : list.get(card)) {
                    total += score;
                }
            } else {
                for (int i = 0; i < list.get(card).size(); i++) {
                    total += 1;
                }
            }
        }
        return total;
    }

    public void setRangedCombatScore(int rangedCombatScore) {
        this.rangedCombatScore = rangedCombatScore;
    }

    public int getSiegeScore() {
        HashMap<Card , List<Integer>> list = siegeScores;
        int total = 0;
        for (Card card : list.keySet()) {
            for (Integer score : list.get(card)) {
                total += score;
            }
        }
        return total;
    }

    public int getSiegeScoreWithWeather() {
        HashMap<Card , List<Integer>> list = siegeScores;
        int total = 0;
        for (Card card : list.keySet()) {
            if (card.isHero()) {
                for (Integer score : list.get(card)) {
                    total += score;
                }
            } else {
                for (int i = 0; i < list.get(card).size(); i++) {
                    total += 1;
                }
            }
        }
        return total;
    }

    public void setSiegeScore(int siegeScore) {
        this.siegeScore = siegeScore;
    }

    public boolean isPassedTheGame() {
        return passedTheGame;
    }

    public void setPassedTheGame(boolean passedTheGame) {
        this.passedTheGame = passedTheGame;
    }

    public Card getMarCoCloseCombat() {
        return MarCoCloseCombat;
    }

    public void setMarCoCloseCombat(Card marCoCloseCombat) {
        MarCoCloseCombat = marCoCloseCombat;
    }

    public Card getMarCoRangedCombat() {
        return MarCoRangedCombat;
    }

    public void setMarCoRangedCombat(Card marCoRangedCombat) {
        MarCoRangedCombat = marCoRangedCombat;
    }

    public Card getMarCoSiege() {
        return MarCoSiege;
    }

    public void setMarCoSiege(Card marCoSiege) {
        MarCoSiege = marCoSiege;
    }

    public int totalScore() {
        // the process of calculating the score
        return 0;
    }

    public boolean isLeaderCardUsed() {
        return isLeaderCardUsed;
    }

    public void setLeaderCardUsed(boolean leaderCardUsed) {
        isLeaderCardUsed = leaderCardUsed;
    }

    public HashMap<Card, List<Integer>> getCloseCombatScores() {
        return closeCombatScores;
    }

    public void setCloseCombatScores(HashMap<Card, List<Integer>> closeCombatScores) {
        this.closeCombatScores = closeCombatScores;
    }

    public HashMap<Card, List<Integer>> getSiegeScores() {
        return siegeScores;
    }

    public void setSiegeScores(HashMap<Card, List<Integer>> siegeScores) {
        this.siegeScores = siegeScores;
    }

    public HashMap<Card, List<Integer>> getRangedCombatScores() {
        return rangedCombatScores;
    }

    public void setRangedCombatScores(HashMap<Card, List<Integer>> rangedCombatScores) {
        this.rangedCombatScores = rangedCombatScores;
    }
}
