package model;


import java.util.ArrayList;
import java.util.HashMap;


public class User {

    public static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Game> games = new ArrayList<>();

    private static User loggedInUser;

    private HashMap<Card, Integer> deck = new HashMap<>();

    //three line for questions

    private String selectedQuestion;

    private String Answer;

    private int AnswerNumber;


    private Faction faction;

    private Card leaderCard;

    private String username;

    private String password;


    private String nickname;

    private String email;

    private Game currentGame;

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

    public User(String username, String password, String email, String nickname) {
        if (!users.contains(User.getUserWithName(username))) {
            this.username = username;

            this.password = password;

            this.email = email;
            this.nickname = nickname;
            users.add(this);

            loggedInUser = this;

            this.faction = Faction.getFactionByName("Skellige");

            this.leaderCard = faction.getLeaderCArdByID(11);

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

            currentGame = null;
        }

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


    public void addToDeck(Card card) {

        int count = deck.getOrDefault(card, 0);

        deck.put(card, count + 1);


    }


    public void removeFromDeck(Card card) {

        int count = deck.getOrDefault(card, 0);

        if (count > 1) {

            deck.put(card, count - 1);

        } else {

            deck.remove(card);

        }

    }


    public void clearDeck() {

        deck.clear();

        totalCardsInDeck = 0;

        numberOfUnitCards = 0;

        specialCards = 0;

        totalUnitCardsStrength = 0;

        heroCards = 0;

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

        int total = 0;
        for (Card card : deck.keySet()) {
            total += deck.get(card);
        }
        return total;

    }


    public int getNumberOfUnitCards() {

        int total = 0;
        for (Card card : deck.keySet()) {
            if (!card.isSpecial() && !card.isHero()) total += deck.get(card);
        }
        return total;

    }


    public int getSpecialCards() {

        int total = 0;
        for (Card card : deck.keySet()) {
            if (card.isSpecial()) total += deck.get(card);
        }
        return total;

    }


    public int getTotalUnitCardsStrength() {

        int total = 0;
        for (Card card : deck.keySet()) {
            total += card.getPower() * deck.get(card);
        }
        return total;

    }


    public int getHeroCards() {

        int total = 0;
        for (Card card : deck.keySet()) {
            if (card.isHero()) total += deck.get(card);
        }
        return total;

    }


    public Game getCurrentGame() {

        return currentGame;

    }


    public void setCurrentGame(Game currentGame) {

        this.currentGame = currentGame;

    }


    public int getNumberOfAllGames() {

        return numberOfAllGames;

    }


    public void increaseNumberOfAllGames() {

        numberOfAllGames++;

    }


    public int getNumberOfWonGames() {

        return numberOfWonGames;

    }


    public void increaseNumberOfWonGames() {

        numberOfWonGames++;

    }


    public int getNumberOfLostGames() {

        return numberOfLostGames;

    }


    public void increaseNumberOfLostGames() {

        numberOfLostGames++;

    }


    public int getNumberOfTiedGames() {

        return numberOfTiedGames;

    }


    public void increaseNumberOfTiedGames() {

        numberOfTiedGames++;

    }


    public void setTotalCardsInDeck(int totalCardsInDeck) {

        this.totalCardsInDeck = totalCardsInDeck;

    }


    public void setNumberOfUnitCards(int numberOfUnitCards) {

        this.numberOfUnitCards = numberOfUnitCards;

    }


    public void setSpecialCards(int specialCards) {

        this.specialCards = specialCards;

    }


    public void setTotalUnitCardsStrength(int totalUnitCardsStrength) {

        this.totalUnitCardsStrength = totalUnitCardsStrength;

    }


    public void setHeroCards(int heroCards) {

        this.heroCards = heroCards;

    }

    public int getMaxScore() {

        return maxScore;

    }

    public void setMaxScore(int maxScore) {

        this.maxScore = maxScore;

    }

    public static void addToUsers(User user) {
        users.add(user);
    }

    public Card getLeaderCard() {
        return leaderCard;
    }

    public void setLeaderCard(Card leaderCard) {
        this.leaderCard = leaderCard;
    }
}