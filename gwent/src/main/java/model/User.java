package model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Game> games = new ArrayList<>();
    private static User loggedInUser;
    private HashMap<Card, Integer> deck = new HashMap<>();
    //three line for questions
    private String selectedQuestion;
    private String Answer;
    private int AnswerNumber;

    private Faction faction;
    private Card leader;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private int totalCardsInDeck;
    private int numberOfUnitCards;
    private int specialCards;
    private int totalUnitCardStrength;
    private int heroCards;
    private int numberOfAllGames;
    private int numberOfWonGames;
    private int numberOfLostGames;
    private int numberOfTiedGames;
    private int maxScore;

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        //TODO
        //default setting should be done
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        User.users = users;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(String selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
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

    public Card getLeader() {
        return leader;
    }

    public void setLeader(Card leader) {
        this.leader = leader;
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

    public int getTotalUnitCardStrength() {
        return totalUnitCardStrength;
    }

    public void setTotalUnitCardStrength(int totalUnitCardStrength) {
        this.totalUnitCardStrength = totalUnitCardStrength;
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

    public static void addToUsers(User user){
        users.add(user);
    }

    @Override
    public String toString() {
        //TODO
        //uses for user info in profile menu
        return "";
    }
}