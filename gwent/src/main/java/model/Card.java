package model;

import enums.Ability;
import enums.CardType;
import enums.Place;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private String name;
    private int ID;
    private int power;
    private int countOfCard;
    private boolean isHero;
    private ArrayList<Ability> abilities;
    private CardType cardType;
    private Place place;
    private Image image;

    public Card(String name, int ID, int power, int countOfCard, boolean isHero, ArrayList<Ability> abilities, CardType cardType, Place place, Image image) {
        cards.add(this);
        this.name = name;
        this.ID = ID;
        this.power = power;
        this.countOfCard = countOfCard;
        this.isHero = isHero;
        this.abilities = abilities;
        this.cardType = cardType;
        this.place = place;
        this.image = image;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public int getID() {
        return ID;
    }

    public static Card getCardByID(int ID){
        ArrayList <Card> cards1 = new ArrayList<>();
        for (Card card : cards1){
            if (card.getID() == ID){
                return card;
            }
        }
        return null;
    }

    public int getPower() {
        return power;
    }

    public int getCountOfCard() {
        return countOfCard;
    }

    public boolean isHero() {
        return isHero;
    }

    public ArrayList<Ability> getAbility() {
        return abilities;
    }

    public CardType getCardType() {
        return cardType;
    }

    public Place getPosition() {
        return place;
    }

    public static void addToCards(Card card) {
        cards.add(card);
    }

    public Place getPlace() {
        return place;
    }

    public Image getImage() {return image;}

    public boolean isSpecial() {
        return this.getCardType().equals(CardType.Spell) || this.getCardType().equals(CardType.Weather);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
