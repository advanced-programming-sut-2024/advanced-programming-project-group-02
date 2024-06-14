package controller;

import enums.Ability;
import enums.CardType;
import enums.Place;
import javafx.scene.image.Image;
import model.Card;

import java.util.ArrayList;

public class SetDefaults {
    public static void run (){

    }

    public static void setCard (){
        ArrayList<Ability> abilities = new ArrayList<>();
        abilities.add(Ability.Mardoeme);
        Card card = new Card("Mardoeme", 101, 0, 3,
                false, abilities, CardType.Spell, Place.CSR,
                new Image(SetDefaults.class.getResourceAsStream("/Images/special_mardroeme.jpg")));
        abilities.clear();
    }

    public static void setFaction (){

    }

    public static void setQuestion (){

    }
}

