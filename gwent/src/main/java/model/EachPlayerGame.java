package model;

import java.util.HashMap;

public class EachPlayerGame {

    private HashMap<Card, Integer> hand = new HashMap<Card, Integer>();
    private HashMap<Card, Integer> deck;
    private HashMap<Card, Integer> discardPile = new HashMap<Card, Integer>();
    private HashMap<Card, Integer> closeCombat = new HashMap<Card, Integer>();
    private HashMap<Card, Integer> rangedCombat = new HashMap<Card, Integer>();
    private HashMap<Card, Integer> siege = new HashMap<Card, Integer>();
    private User player;
    private Faction faction;
    private int lives;
    private int closeCombatScore;
    private int rangedCombatScore;
    private int siegeScore;
    private boolean passedTheGame;
    private Card MarCoCloseCombat;
    private Card MarCoRangedCombat;
    private Card MarCoSiege;

    public EachPlayerGame(HashMap<Card, Integer> deck, User player) {
        this.deck = deck;
        this.player = player;

    }

    public HashMap<Card, Integer> getHand() {
        return hand;
    }

    public void setHand(HashMap<Card, Integer> hand) {
        this.hand = hand;
    }

    public HashMap<Card, Integer> getDeck() {
        return deck;
    }

    public void setDeck(HashMap<Card, Integer> deck) {
        this.deck = deck;
    }

    public HashMap<Card, Integer> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(HashMap<Card, Integer> discardPile) {
        this.discardPile = discardPile;
    }

    public HashMap<Card, Integer> getCloseCombat() {
        return closeCombat;
    }

    public void setCloseCombat(HashMap<Card, Integer> closeCombat) {
        this.closeCombat = closeCombat;
    }

    public HashMap<Card, Integer> getRangedCombat() {
        return rangedCombat;
    }

    public void setRangedCombat(HashMap<Card, Integer> rangedCombat) {
        this.rangedCombat = rangedCombat;
    }

    public HashMap<Card, Integer> getSiege() {
        return siege;
    }

    public void setSiege(HashMap<Card, Integer> siege) {
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getCloseCombatScore() {
        return closeCombatScore;
    }

    public void setCloseCombatScore(int closeCombatScore) {
        this.closeCombatScore = closeCombatScore;
    }

    public int getRangedCombatScore() {
        return rangedCombatScore;
    }

    public void setRangedCombatScore(int rangedCombatScore) {
        this.rangedCombatScore = rangedCombatScore;
    }

    public int getSiegeScore() {
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
}
