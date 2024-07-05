package controller;

import enums.CardType;
import enums.Place;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.Card;
import model.Game;
import model.User;

public class Function{
    public static GameMenuController gameMenuController;
    public void run(GameMenuController gameMenuController, ListView listView, Card card){
        this.gameMenuController = gameMenuController;
        Game game = User.getLoggedInUser().getCurrentGame();
        CardType cardType = card.getCardType();
        switch (cardType){
            case CloseCombatUnit:
            case RangedUnit:
            case SiegeUnit:
            case AgileUnit:
                unit(game, listView, card);
        }
    }
    public void run(GameMenuController gameMenuController, ImageView imageView, Card card){

    }
    private static void unit(Game game, ListView listView, Card card){
    }
    private static void unit(ImageView imageView, Card card){

    }
    private static void commandersHorn(ListView listView,Card card){

    }
    private static void commandersHorn(ImageView imageView,Card card){}
    private static void decoy(Place place,Card card){}
    private static void medic(Place place, Card card){}
    private static void moralBoost(Place place,Card card){}
    private static void muster(Place place,Card card){}
    private static void spy(Place place,Card card){}
    private static void tightBond(Place place,Card card){}
    private static void scorch(Place place,Card card){}
    private static void berserker(Place place,Card card){}
    private static void mardroeme(Place place,Card card){}
    private static void transformers(Place place,Card card){}
    private static void nonAbility(Place place,Card card){}

    //3 method for transfer spell weather
}