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
        new Card("Mardoeme", 101, 0, 3,
                false, abilities, CardType.Spell, Place.CSR,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/special_mardroeme.jpg")));
        abilities.clear();

        abilities.add(Ability.Berserker);
        new Card("Berserker", 102, 4, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_berserker.jpg")));
        abilities.clear();

        abilities.add(Ability.MoralBoost);
        new Card("Vidkaarl", 103, 14, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_vildkaarl.jpg")));
        abilities.clear();

        new Card("Svanrige", 104, 4, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_svanrige.jpg")));

        new Card("Udalryk", 105, 4, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_udalryk.jpg")));

        new Card("DonarAnCraite", 106, 4, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_donar.jpg")));

        abilities.add(Ability.TightBond);
        new Card("ClanAnCraite", 107, 6, 3,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_craite_warrior.jpg")));
        abilities.clear();

        new Card("MadmanLugos", 108, 6, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_madmad_lugos.jpg")));

        abilities.add(Ability.Hero);
        abilities.add(Ability.Muster);
        new Card("Creys", 109, 10, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_cerys.jpg")));
        abilities.clear();

        abilities.add(Ability.Hero);
        abilities.add(Ability.Transformers);
        new Card("Kambi", 110, 0, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_kambi.jpg")));
        abilities.clear();

        abilities.add(Ability.Medic);
        new Card("BirnaBran", 111, 2, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_birna.jpg")));
        abilities.clear();

        abilities.add(Ability.TightBond);
        new Card("ClanDrummondShieldmaide", 112, 4, 3,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_shield_maiden.jpg")));
        abilities.clear();

        abilities.add(Ability.Scorch);
        new Card("ClanDimunPirate", 113, 6, 1,
                true, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_dimun_pirate.jpg")));
        abilities.clear();

        new Card("ClanBrokvarArcher", 114, 6, 3,
                true, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_craite_warrior.jpg")));
    }

    public static void setFaction (){

    }

    public static void setQuestion (){

    }
}

