package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EachPlayerGame {

    private ObservableList<Card> hand = FXCollections.observableArrayList();
    private HashMap<Card, Integer> deck;
    private ObservableList<Card> burnedCards = FXCollections.observableArrayList();
    private ObservableList<Card> closeCombat = FXCollections.observableArrayList();
    private ObservableList<Card> rangedCombat = FXCollections.observableArrayList();
    private ObservableList<Card> siege = FXCollections.observableArrayList();
    private HashMap<Card,Integer> closeCombatScores = new HashMap<>();
    private HashMap<Card,Integer> siegeScores = new HashMap<>();
    private HashMap<Card,Integer> rangedCombatScores = new HashMap<>();
    private User player;
    private Faction faction;
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
        this.deck = new HashMap<>(player.getDeck());
        this.player = player;
        faction = player.getFaction();
        drawInitialHand();
        hand = new SortedList<>(hand, Comparator.comparingInt(Card::getPower));
        passedTheGame = false;
        isLeaderCardUsed = false;
        closeCombatScore = 0;
        rangedCombatScore = 0;
        siegeScore = 0;
        crystals = 2;
    }

    private void drawInitialHand() {
        int handSize = 10;
        int totalCardsInDeck = deck.values().stream().mapToInt(Integer::intValue).sum();

        if (totalCardsInDeck < handSize) {
            throw new IllegalArgumentException("Deck does not contain enough cards to draw an initial hand.");
        }

        while (handSize > 0) {
            Card randomCard = getRandomCardFromDeck();
            int deckCount = deck.get(randomCard);

            hand.add(randomCard);
            deck.put(randomCard, deckCount - 1);

            if (deck.get(randomCard) == 0) {
                deck.remove(randomCard);
            }

            handSize--;
        }
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
        return closeCombatScore + rangedCombatScore + siegeScore;
    }

    public ObservableList<Card> getHand() {
        return hand;
    }

    public void setHand(ObservableList<Card> hand) {
        this.hand = hand;
    }

    public HashMap<Card, Integer> getDeck() {
        return deck;
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
        int score = 0;
        for (int value : closeCombatScores.values()) {
            score += value;
        }
        closeCombatScore = score;
        return closeCombatScore;
    }

    public void setCloseCombatScore(int closeCombatScore) {
        this.closeCombatScore = closeCombatScore;
    }

    public int getRangedCombatScore() {
        int score = 0;
        for (int value : rangedCombatScores.values()) {
            score += value;
        }
        rangedCombatScore = score;
        return rangedCombatScore;
    }

    public void setRangedCombatScore(int rangedCombatScore) {
        this.rangedCombatScore = rangedCombatScore;
    }

    public int getSiegeScore() {
        int score = 0;
        for (int value : siegeScores.values()) {
            score += value;
        }
        siegeScore = score;
        return siegeScore;
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
        //the process of calculating the score
        return 0;
    }

    public boolean isLeaderCardUsed() {
        return isLeaderCardUsed;
    }

    public void setLeaderCardUsed(boolean leaderCardUsed) {
        isLeaderCardUsed = leaderCardUsed;
    }

    public HashMap<Card, Integer> getCloseCombatScores() {
        return closeCombatScores;
    }

    public void setCloseCombatScores(HashMap<Card, Integer> closeCombatScores) {
        this.closeCombatScores = closeCombatScores;
    }

    public HashMap<Card, Integer> getSiegeScores() {
        return siegeScores;
    }

    public void setSiegeScores(HashMap<Card, Integer> siegeScores) {
        this.siegeScores = siegeScores;
    }

    public HashMap<Card, Integer> getRangedCombatScores() {
        return rangedCombatScores;
    }

    public void setRangedCombatScores(HashMap<Card, Integer> rangedCombatScores) {
        this.rangedCombatScores = rangedCombatScores;
    }
}
