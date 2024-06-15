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
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_berserker.jpg")));
        abilities.clear();

        abilities.add(Ability.MoralBoost);
        new Card("Vidkaarl", 103, 14, 1,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_vildkaarl.jpg")));
        abilities.clear();

        new Card("Svanrige", 104, 4, 1,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_svanrige.jpg")));

        new Card("Udalryk", 105, 4, 1,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_udalryk.jpg")));

        new Card("DonarAnCraite", 106, 4, 1,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_donar.jpg")));

        abilities.add(Ability.TightBond);
        new Card("ClanAnCraite", 107, 6, 3,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_craite_warrior.jpg")));
        abilities.clear();

        new Card("MadmanLugos", 108, 6, 1,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
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
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_kambi.jpg")));
        abilities.clear();

        abilities.add(Ability.Medic);
        new Card("BirnaBran", 111, 2, 1,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_birna.jpg")));
        abilities.clear();

        abilities.add(Ability.TightBond);
        new Card("ClanDrummondShieldmaide", 112, 4, 3,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_shield_maiden.jpg")));
        abilities.clear();

        abilities.add(Ability.Scorch);
        new Card("ClanDimunPirate", 113, 6, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_dimun_pirate.jpg")));
        abilities.clear();

        new Card("ClanBrokvarArcher", 114, 6, 3,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_craite_warrior.jpg")));

        abilities.add(Ability.Hero);
        abilities.add(Ability.Mardoeme);
        new Card("Ermion", 115, 8, 1,
                true, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_ermion.jpg")));
        abilities.clear();

        abilities.add(Ability.Hero);
        new Card("Hjalmar", 116, 10, 1,
                true, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_hjalmar.jpg")));
        abilities.clear();

        abilities.add(Ability.Berserker);
        new Card("YongBerserker", 117, 2, 3,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_young_berserker.jpg")));
        abilities.clear();

        abilities.add(Ability.TightBond);
        new Card("YoungVildkaarl", 118, 8, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_young_vildkaarl.jpg")));
        abilities.clear();

        abilities.add(Ability.Muster);
        new Card("LightLongship", 119, 4, 3,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_light_longship.jpg")));
        abilities.clear();

        abilities.add(Ability.TightBond);
        new Card("WarLongship", 120, 6, 3,
                false, abilities, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_war_longship.jpg")));
        abilities.clear();

        abilities.add(Ability.CommandersHorn);
        new Card("DraigBonDho", 121, 2, 1,
                false, abilities, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_draig.jpg")));
        abilities.clear();

        abilities.add(Ability.CommandersHorn);
        new Card("Olaf", 122, 12, 1,
                false, abilities, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/skellige/skellige_olaf.jpg")));
        abilities.clear();




        abilities.add(Ability.Muster);
        new Card("ElvenSkirmisher", 201, 2, 3,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_elven_skirmisher.jpg")));
        abilities.clear();

        new Card("Yaevinn", 202, 6, 1,
                false, abilities, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_yaevinn.jpg")));

        new Card("CiaranAep", 203, 3, 1,
                false, abilities, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_ciaran.jpg")));

        new Card("DennisCranmer", 204, 6, 1,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_dennis.jpg")));

        new Card("DolBlathannaScout", 205, 6, 3,
                false, abilities, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_dol_blathanna_scout.jpg")));

        new Card("DolBlathannaArcher", 206, 4, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_dol_archer.jpg")));

        abilities.add(Ability.Muster);
        new Card("DwarvenSkirmisher", 207, 3, 3,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_dwarven_skirmisher.jpg")));
        abilities.clear();

        abilities.add(Ability.Medic);
        new Card("HavekarHealer", 208, 0, 3,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_havekar_healer.jpg")));
        abilities.clear();

        abilities.add(Ability.Muster);
        new Card("HavekarSmuggler", 209, 5, 3,
                false, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_havekar_smuggler.jpg")));
        abilities.clear();

        new Card("IdaEmeanAep", 210, 6, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_ida.jpg")));

        new Card("Rordain", 211, 1, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_riordain.jpg")));

        new Card("Toruviel", 212, 2, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_toruviel.jpg")));

        new Card("VirheddBrigadeRecruit", 213, 4, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_vrihedd_brigade_recruit.jpg")));

        new Card("VirheddBrigadeVeteran", 214, 5, 2,
                false, abilities, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_vrihedd_brigade_veteran.jpg")));

        abilities.add(Ability.MoralBoost);
        new Card("Milva", 215, 10, 1,
                false, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_milva.jpg")));
        abilities.clear();

        abilities.add(Ability.Hero);
        new Card("Seasenthessis", 216, 10, 1,
                true, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_seasenthessis.jpg")));
        abilities.clear();

        abilities.add(Ability.Scorch);
        new Card("Schirru", 217, 8, 1,
                false, abilities, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_schirru.jpg")));
        abilities.clear();

        abilities.add(Ability.Hero);
        new Card("Eithne", 218, 10, 1,
                true, abilities, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_eithne.jpg")));
        abilities.clear();

        abilities.add(Ability.Hero);
        abilities.add(Ability.MoralBoost);
        new Card("Isngrimfaolitiarna", 219, 10, 1,
                true, abilities, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("images/cards/scoiatael/scoiatael_isengrim.jpg")));
        abilities.clear();
    }

    public static void setFaction () {

    }

    public static void setQuestion (){

    }
}

