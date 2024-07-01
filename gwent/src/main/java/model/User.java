package model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private static final ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Game> games = new ArrayList<>();
    private static User loggedInUser;
    private HashMap<Card, Integer> deck = new HashMap<>();
    //two line for questions
    private String Answer;
    private int AnswerNumber;

    private Faction faction;
    private String username;
    private String password;
    private int totalCardsInDeck;
    private int numberOfUnitCards;
    private int specialCards;
    private int totalUnitCardsStrength;
    private int heroCards;
    private int numberOfAllGames;
    private int numberOfWonGames;
    private int numberOfLostGames;
    private int numberOfTiedGames;
    private int maxScore;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        users.add(this);
        loggedInUser = this;
        this.faction = Faction.getFactionByName("Skellige");
        totalCardsInDeck = 0;
        numberOfAllGames = 0;
        numberOfLostGames = 0;
        numberOfTiedGames = 0;
        numberOfUnitCards = 0;
        numberOfWonGames = 0;
        specialCards = 0;
        totalUnitCardsStrength = 0;
        heroCards = 0;
        maxScore = 0;
    }

    public static boolean isThereUserWithName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) return true;
        }
        return false;
    }

    public int getAnswerNumber() {
        return AnswerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        AnswerNumber = answerNumber;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public static User getUserWithName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) return user;
        }
        return null;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static void setGames(ArrayList<Game> games) {
        User.games = games;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public void saveDeckInAddress(String address) {
        //TODO
    }

    public void saveDeckWithName(String name) {
        //TODO
    }

    public void loadDeckFromAddress(String address) {
        //TODO
    }

    public void loadDeckWithName(String name) {
        //TODO
    }

    public void showDeck() {
        //TODO
    }

    public void addToDeck(Card card, int countOfCard) {
        //TODO
    }

    public void removeFromDeck(Card card, int countOfCard) {
        //TODO
    }

    public void clearDeck() {
        //TODO
    }

    public int calculateRank() {
        int rank = 1;
        int userMaxScore = this.maxScore;
        for (User user : users) {
            if (user.getMaxScore() < userMaxScore) rank++;
        }
        return rank;
    }

    public void showUserInfo() {
        //TODO
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Card, Integer> getDeck() {
        return deck;
    }

    public void setDeck(HashMap<Card, Integer> deck) {
        this.deck = deck;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public int getTotalCardsInDeck() {
        return totalCardsInDeck;
    }

    public void setTotalCardsInDeck(int totalCardsInDeck) {
        this.totalCardsInDeck = totalCardsInDeck;
    }

    public int getNumberOfUnitCards() {
        return numberOfUnitCards;
    }

    public void setNumberOfUnitCards(int numberOfUnitCards) {
        this.numberOfUnitCards = numberOfUnitCards;
    }

    public int getSpecialCards() {
        return specialCards;
    }

    public void setSpecialCards(int specialCards) {
        this.specialCards = specialCards;
    }

    public int getTotalUnitCardsStrength() {
        return totalUnitCardsStrength;
    }

    public void setTotalUnitCardsStrength(int totalUnitCardsStrength) {
        this.totalUnitCardsStrength = totalUnitCardsStrength;
    }

    public int getHeroCards() {
        return heroCards;
    }

    public void setHeroCards(int heroCards) {
        this.heroCards = heroCards;
    }

    public int getNumberOfAllGames() {
        return numberOfAllGames;
    }

    public void setNumberOfAllGames(int numberOfAllGames) {
        this.numberOfAllGames = numberOfAllGames;
    }

    public int getNumberOfWonGames() {
        return numberOfWonGames;
    }

    public void setNumberOfWonGames(int numberOfWonGames) {
        this.numberOfWonGames = numberOfWonGames;
    }

    public int getNumberOfLostGames() {
        return numberOfLostGames;
    }

    public void setNumberOfLostGames(int numberOfLostGames) {
        this.numberOfLostGames = numberOfLostGames;
    }

    public int getNumberOfTiedGames() {
        return numberOfTiedGames;
    }

    public void setNumberOfTiedGames(int numberOfTiedGames) {
        this.numberOfTiedGames = numberOfTiedGames;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        //TODO
        //uses for user info in profile menu
        return "";
    }
}