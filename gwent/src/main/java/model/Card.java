package model;

import enums.Ability;
import enums.CardType;
import enums.Place;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private int ID;
    private int power;
    private int countOfCard;
    private boolean isHero;
    private Ability ability;
    private CardType cardType;
    private Place place;

    public Card(int ID, int power, int countOfCard, boolean isHero, Ability ability, CardType cardType, Place place) {
        cards.add(this);
        this.ID = ID;
        this.power = power;
        this.countOfCard = countOfCard;
        this.isHero = isHero;
        this.ability = ability;
        this.cardType = cardType;
        this.place = place;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public int getID() {
        return ID;
    }

    public int getPower() {
        return power;
    }

    public int getCountOfCArd() {
        return countOfCard;
    }

    public boolean isHero() {
        return isHero;
    }

    public Ability getAbility() {
        return ability;
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

//    @Override
//    public String toString() {
//        return "";
//    }

}
