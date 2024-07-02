package model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Faction {
    private static ArrayList<Faction> factions = new ArrayList<>();
    private String name;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> leaderCards = new ArrayList<>();
    private Image image;

    public Faction(String name, Image image) {
        this.name = name;
        factions.add(this);
        this.image = image;
    }

    public static boolean isThereFactionWithName(String name) {
        for (Faction faction : factions) {
            if (faction.name.equals(name)) return true;
        }
        return false;
    }

    public static Faction getFactionByName(String name) {
        for (Faction faction : factions) {
            if (faction.name.equals(name)) return faction;
        }
        return null;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public Card getLeaderCArdByID(int ID) {
        for (Card leaderCard : leaderCards) {
            if (leaderCard.getID() == ID) return leaderCard;
        }
        return null;
    }

    public Card getCArdByID(int ID) {
        return cards.get(ID);
    }

    public boolean isThereLeaderWithId(int ID) {
        for (Card leaderCard : leaderCards){
            if (leaderCard.getID() == ID) return true;
        } return false;
    }

    public boolean isThereCardWithId(int ID) {
        for (Card card : cards){
            if (card.getID() == ID) return true;
        } return false;
    }

    public void addToCards(Card card) {
        cards.add(card);
    }

    public void addToLeaderCards(Card card) {
        leaderCards.add(card);
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getLeaderCards() {
        return leaderCards;
    }

    public void setLeaderCards(ArrayList<Card> leaderCards) {
        this.leaderCards = leaderCards;
    }

    public Card getLeaderCardByName(String name) {
        for (Card card : leaderCards) {
            if (card.getName().equals(name)) return card;
        } return null;
    }

    public Image getImage() {
        return image;
    }

    public static void showFactions() {
        //TODO
    }

    public void showLeaderCards() {
        //TODO
    }

    public void showCards() {
        //TODO
    }

}

