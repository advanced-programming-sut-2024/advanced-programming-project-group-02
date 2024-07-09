package controller;

import enums.Ability;
import enums.CardType;
import enums.Place;
import javafx.scene.image.Image;
import model.Card;
import model.Faction;

import java.util.ArrayList;

public class SetDefaults {
    public static void run() {
        setCard();
        setFaction();
        setQuestion();
    }

    public static void setCard() {

        Card mardoemeCard = new Card("Mardoeme", 101, 0, 3,
                false, Ability.Mardoeme, CardType.Spell, Place.CSR,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/special_mardroeme.jpg")));

        Card berserkerCard = new Card("Berserker", 102, 4, 1,
                false, Ability.Berserker, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_berserker.jpg")));

        Card vidkaarlCard = new Card("Vidkaarl", 103, 14, 1,
                false, Ability.MoralBoost, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_vildkaarl.jpg")));

        Card svanrigeCard = new Card("Svanrige", 104, 4, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_svanrige.jpg")));

        Card udalrykCard = new Card("Udalryk", 105, 4, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_udalryk.jpg")));

        Card donarAnCraiteCard = new Card("DonarAnCraite", 106, 4, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_donar.jpg")));

        Card clanAnCraiteCard = new Card("ClanAnCraite", 107, 6, 3,
                false, Ability.TightBond, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_craite_warrior.jpg")));

        Card madmanLugosCard = new Card("MadmanLugos", 108, 6, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_madmad_lugos.jpg")));

        Card creysCard = new Card("Creys", 109, 10, 1,
                true, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_cerys.jpg")));

        Card kambiCard = new Card("Kambi", 110, 0, 1,
                true, Ability.Transformers, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_kambi.jpg")));

        Card birnaBranCard = new Card("BirnaBran", 111, 2, 1,
                false, Ability.Medic, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_birna.jpg")));

        Card clanDrummondShieldmaideCard = new Card("ClanDrummondShieldmaide", 112, 4, 3,
                false, Ability.TightBond, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_shield_maiden.jpg")));

        Card clanDimunPirateCard = new Card("ClanDimunPirate", 113, 6, 1,
                false, Ability.Scorch, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_dimun_pirate.jpg")));

        Card clanBrokvarArcherCard = new Card("ClanBrokvarArcher", 114, 6, 3,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_craite_warrior.jpg")));

        Card ermionCard = new Card("Ermion", 115, 8, 1,
                true, Ability.Mardoeme, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_ermion.jpg")));

        Card hjalmarCard = new Card("Hjalmar", 116, 10, 1,
                true, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_hjalmar.jpg")));

        Card yongBerserkerCard = new Card("YoungBerserker", 117, 2, 3,
                false, Ability.Berserker, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_young_berserker.jpg")));

        Card youngVildkaarlCard = new Card("YoungVildkaarl", 118, 8, 1,
                false, Ability.TightBond, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_young_vildkaarl.jpg")));

        Card lightLongshipCard = new Card("LightLongship", 119, 4, 3,
                false, Ability.Muster, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_light_longship.jpg")));

        Card warLongshipCard = new Card("WarLongship", 120, 6, 3,
                false, Ability.TightBond, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_war_longship.jpg")));

        Card draigBonDhoCard = new Card("DraigBonDho", 121, 2, 1,
                false, Ability.CommandersHorn, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_draig.jpg")));

        Card olafCard = new Card("Olaf", 122, 12, 1,
                false, Ability.CommandersHorn, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_olaf.jpg")));

        new Card("Blueboy Lugos", 123, 6, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_blueboy.jpg")));

        new Card("Clan Tordarroch Armorsmith", 124, 4, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_tordarroch.jpg")));

        new Card("Holger Blackhand", 125, 4, 1,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/skellige_holger.jpg")));


        Card elvenSkirmisherCard = new Card("ElvenSkirmisher", 201, 2, 3,
                false, Ability.Muster, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_elven_skirmisher.jpg")));

        Card yaevinnCard = new Card("Yaevinn", 202, 6, 1,
                false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_yaevinn.jpg")));

        Card ciaranAepCard = new Card("CiaranAep", 203, 3, 1,
                false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_ciaran.jpg")));

        Card dennisCranmerCard = new Card("DennisCranmer", 204, 6, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_dennis.jpg")));

        Card dolBlathannaScoutCard = new Card("DolBlathannaScout", 205, 6, 3,
                false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_dol_blathanna_scout.jpg")));

        Card dolBlathannaArcherCard = new Card("DolBlathannaArcher", 206, 4, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_dol_archer.jpg")));

        Card dwarvenSkirmisherCard = new Card("DwarvenSkirmisher", 207, 3, 3,
                false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_dwarven_skirmisher.jpg")));

        Card havekarHealerCard = new Card("HavekarHealer", 208, 0, 3,
                false, Ability.Medic, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_havekar_healer.jpg")));

        Card havekarSmugglerCard = new Card("HavekarSmuggler", 209, 5, 3,
                false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_havekar_smuggler.jpg")));

        Card idaEmeanAepCard = new Card("IdaEmeanAep", 210, 6, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_ida.jpg")));

        Card rordainCard = new Card("Rordain", 211, 1, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_riordain.jpg")));

        Card toruvielCard = new Card("Toruviel", 212, 2, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_toruviel.jpg")));

        Card virheddBrigadeRecruitCard = new Card("VirheddBrigadeRecruit", 213, 4, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_vrihedd_brigade_recruit.jpg")));

        Card virheddBrigadeVeteranCard = new Card("VirheddBrigadeVeteran", 214, 5, 2,
                false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_vrihedd_brigade_veteran.jpg")));

        Card milvaCard = new Card("Milva", 215, 10, 1,
                false, Ability.MoralBoost, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_milva.jpg")));

        Card seasenthessisCard = new Card("Seasenthessis", 216, 10, 1,
                true, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_seasenthessis.jpg")));

        Card schirruCard = new Card("Schirru", 217, 8, 1,
                false, Ability.Scorch, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_schirru.jpg")));

        Card eithneCard = new Card("Eithne", 218, 10, 1,
                true, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_eithne.jpg")));

        Card isngrimfaolitiarnaCard = new Card("Isngrimfaolitiarna", 219, 10, 1,
                true, Ability.MoralBoost, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_isengrim.jpg")));

        new Card("Iorveth", 220, 10, 1,
                true, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_iorveth.jpg")));

        new Card("Filavandrel", 221, 6, 1,
                false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_filavandrel.jpg")));

        new Card("Mahakaman Defender", 222, 5, 5,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_mahakam.jpg")));

        new Card("Barclay Els", 223, 6, 1,
                false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/scoiatael_barclay.jpg")));


        Card ballistaCard = new Card("Ballista", 301, 6, 2,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_ballista.jpg")));

        Card catapultCard = new Card("Catapult", 302, 8, 2,
                false, Ability.TightBond, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_catapult.jpg")));

        Card dragonHunterCard = new Card("DragonHunter", 303, 5, 3,
                false, Ability.TightBond, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_dragon_hunter.jpg")));

        Card dunBannerMedicCard = new Card("DunBannerMedic", 304, 5, 1,
                false, Ability.Medic, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_dun_banner_medic.jpg")));

        Card esteradThyssenCard = new Card("esteradThyssen", 305, 10, 1,
                true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_esterad.jpg")));

        Card johnNatalisCard = new Card("JohnNatalis", 306, 10, 1,
                true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_natalis.jpg")));

        Card kaedweniSiegeExpertCard = new Card("KaedweniSiegeExpert", 307, 1, 3,
                false, Ability.MoralBoost, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_kaedwen_siege.jpg")));

        Card phillipaEirhartCard = new Card("PhillipaEirhart", 308, 10, 1,
                true, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_philippa.jpg")));

        Card poorFuckingInfantryCard = new Card("PoorFuckingInfantry", 309, 1, 4,
                false, Ability.TightBond, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_poor_infantry.jpg")));

        Card princeStennisCard = new Card("PrinceStennis", 310, 5, 1,
                false, Ability.Spy, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_stennis.jpg")));

        Card redanianFootSoldierCard = new Card("RedanianFootSoldier", 311, 1, 2,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_redania.jpg")));

        Card sabrinaGlevissingCard = new Card("SabrinaGlevissing", 312, 4, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_sabrina.jpg")));

        Card siegeTowerCard = new Card("SiegeTower", 313, 6, 1,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_siege_tower.jpg")));

        Card siegfriedOfDenesleCard = new Card("SiegfriedOfDenesle", 314, 5, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_siegfried.jpg")));

        Card sigismundDijkstraCard = new Card("SigismundDijkstra", 315, 4, 1,
                false, Ability.Spy, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_dijkstra.jpg")));

        Card sileDeTansarvilleCard = new Card("SileDeTansarville", 316, 5, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_sile_de_tansarville.jpg")));

        Card thalerCard = new Card("Thaler", 317, 1, 1,
                false, Ability.Spy, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_thaler.jpg")));

        Card vernonRocheCard = new Card("VernonRoche", 318, 10, 1,
                true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_vernon.jpg")));

        Card vesCard = new Card("Ves", 319, 5, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_ves.jpg")));

        Card yarpenZirgrinCard = new Card("YarpenZirgrin", 320, 2, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_yarpen.jpg")));

        Card blueStripesCommandoCard = new Card("BlueStripesCommando", 321, 4, 3,
                false, Ability.TightBond, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_blue_stripes.jpg")));

        Card dethmoldCard = new Card("Dethmold", 322, 6, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_dethmold.jpg")));

        Card keiraMetzCard = new Card("KeiraMetz", 323, 5, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_keira.jpg")));

        Card sheldonSkaggsCard = new Card("SheldonSkaggs", 324, 4, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_sheldon.jpg")));

        Card trebuchetCard = new Card("Trebuchet", 325, 6, 2,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/realms_trebuchet.jpg")));


        Card imperaBrigadeGuardCard = new Card("Impera Brigade Guard", 401, 3, 4,
                false, Ability.TightBond, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_imperal_brigade.jpg")));

        Card stefanSkellenCard = new Card("Stefan Skellen", 402, 9, 1,
                false, Ability.Spy, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_stefan.jpg")));

        Card youngEmissaryCard = new Card("YoungEmissary", 403, 5, 2,
                false, Ability.TightBond, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_young_emissary.jpg")));

        Card cahirMawrDyffrynAepCeallachCard = new Card("Cahir Mawr Dyffryn Aep Ceallach", 404, 6, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_cahir.jpg")));

        Card vattierDeRideauxCard = new Card("Vattier De Rideaux", 405, 4, 1,
                false, Ability.Spy, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_vattier.jpg")));

        Card mennoCoehornCard = new Card("Menno Coehorn", 406, 10, 1,
                true, Ability.Medic, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_menno.jpg")));

        Card puttkammerCard = new Card("Puttkammer", 407, 3, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_puttkammer.jpg")));

        Card blackInfantryArcherCard = new Card("Black Infantry Archer", 408, 10, 2,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_black_archer.jpg")));

        Card tiborEggebrachtCard = new Card("Tibor Eggebracht", 409, 10, 1,
                true, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_tibor.jpg")));

        Card renualdAepMatsenCard = new Card("Renuald Aep Matsen", 410, 5, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_renuald.jpg")));

        Card fringillaVigoCard = new Card("Fringilla Vigo", 411, 6, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_fringilla.jpg")));

        Card rottenMangonelCard = new Card("Rotten Mangonel", 412, 3, 1,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_rotten.jpg")));

        Card zerrikanianFireScorpionCard = new Card("Zerrikanian Fire Scorpion", 413, 5, 1,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_zerri.jpg")));

        Card siegeEngineerCard = new Card("Siege Engineer", 414, 6, 1,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_siege_engineer.jpg")));

        Card morvranVoorhisCard = new Card("Morvran Voorhis", 415, 10, 1,
                true, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_moorvran.jpg")));

        Card cynthiaCard = new Card("Cynthia", 416, 4, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_cynthia.jpg")));

        Card etolianAuxiliaryArchersCard = new Card("Etolian Auxiliary Archers", 417, 1, 2,
                false, Ability.Medic, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_etolian.jpg")));

        Card mennoCoehoornCard2 = new Card("Menno Coehoorn", 418, 10, 1,
                true, Ability.Medic, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_menno.jpg")));

        Card morteisenCard = new Card("Morteisen", 419, 3, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_morteisen.jpg")));

        Card nausicaaCavalryRiderCard = new Card("Nausicaa Cavalry Rider", 420, 2, 3,
                false, Ability.TightBond, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_nauzicaa.jpg")));

        Card siegeTechnicianCard = new Card("Siege Technician", 421, 0, 1,
                false, Ability.Medic, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_siege_technician.jpg")));

        Card sweersCard = new Card("Sweers", 422, 2, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_sweers.jpg")));

        Card vanhemarCard = new Card("Vanhemar", 423, 4, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_vanhemar.jpg")));

        Card vreemdeCard = new Card("Vreemde", 424, 2, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_vreemde.jpg")));

        Card shilardFitzOesterlenCard = new Card("Shilard Fitz-Oesterlen", 425, 7, 1,
                false, Ability.Spy, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_shilard.jpg")));

        Card assireVarAnahidCard = new Card("Assire var Anahid", 426, 6, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_assire.jpg")));

        Card heavyZerrikanianFireScorpionCard = new Card("Heavy Zerrikanian Fire Scorpion", 427, 10, 1,
                false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_heavy_zerri.jpg")));

        Card albrichCard = new Card("Albrich", 428, 2, 1,
                false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_albrich.jpg")));

        Card lethoOfGuletCard = new Card("Letho of Gulet", 429, 10, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_letho.jpg")));

        Card rainfarnCard = new Card("Rainfarn", 430, 4, 1,
                false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/nilfgaard_rainfarn.jpg")));


        new Card("Draug", 501, 10, 1, true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_draug.jpg")));

        new Card("Leshen", 502, 10, 1, true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_leshen.jpg")));

        new Card("Kayran", 503, 8, 1, true, Ability.MoralBoost, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_kayran.jpg")));

        new Card("Toad", 504, 7, 1, false, Ability.Scorch, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_toad.jpg")));

        new Card("Arachas Behemoth", 505, 6, 1, false, Ability.Muster, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_arachas_behemoth.jpg")));

        new Card("Crone: Weavess", 506, 6, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_weavess.jpg")));

        new Card("Crone: Whispess", 507, 6, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_whispess.jpg")));

        new Card("Earth Elemental", 508, 6, 1, false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_earth_elemental.jpg")));

        new Card("Fiend", 509, 6, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_fiend.jpg")));

        new Card("Fire Elemental", 510, 6, 1, false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_fire_elemental.jpg")));

        new Card("Forktail", 511, 5, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_forktail.jpg")));

        new Card("Grave Hag", 512, 5, 1, false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_gravehag.jpg")));

        new Card("Griffin", 513, 5, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_griffin.jpg")));

        new Card("Ice Giant", 514, 5, 1, false, null, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_ice_giant.jpg")));

        new Card("Plague Maiden", 515, 5, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_plague_maiden.jpg")));

        new Card("Vampire: Katakan", 516, 5, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_katakan.jpg")));

        new Card("Werewolf", 517, 5, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_werewolf.jpg")));

        new Card("Arachas", 518, 4, 3, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_arachas.jpg")));

        new Card("Vampire: Bruxa", 519, 4, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_bruxa.jpg")));

        new Card("Vampire: Ekimmara", 520, 4, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_ekkima.jpg")));

        new Card("Vampire: Fleder", 521, 4, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_fleder.jpg")));

        new Card("Vampire: Garkain", 522, 4, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_garkain.jpg")));

        new Card("Cockatrice", 523, 2, 1, false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_cockatrice.jpg")));

        new Card("Endrega", 524, 2, 1, false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_endrega.jpg")));

        new Card("Foglet", 525, 2, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_foglet.jpg")));

        new Card("Harpy", 526, 2, 1, false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_harpy.jpg")));

        new Card("Nekker", 527, 2, 3, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_nekker.jpg")));

        new Card("Wyvern", 528, 2, 1, false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_wyvern.jpg")));

        new Card("Ghoul", 529, 1, 3, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_ghoul.jpg")));

        new Card("Imlerith", 530, 10, 1, true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_imlerith.jpg")));

        new Card("Crone:Brewess", 531, 6, 1, false, Ability.Muster, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_crone_brewess.jpg")));

        new Card("Frightener", 532, 5, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_frightener.jpg")));

        new Card("Botchling", 533, 4, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_botchiling.jpg")));

        new Card("Celaeno Harpy", 534, 2, 1, false, null, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_celaeno_harpy.jpg")));

        new Card("Gargoyle", 535, 2, 1, false, null, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/monsters_gargoyle.jpg")));


        new Card("Biting Frost", 601, 0, 3, false, null, CardType.Weather, Place.weatherPlace,
            new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/weather_biting_frost.jpg")));

        new Card("Impenetrable Fog", 602, 0, 3, false, null, CardType.Weather, Place.weatherPlace,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/weather_fog.jpg")));

        new Card("Torrential Rain", 603, 0, 3, false, null, CardType.Weather, Place.weatherPlace,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/weather_rain.jpg")));

        new Card("Skellige Storm", 604, 0, 3, false, null, CardType.Weather, Place.weatherPlace,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/weather_storm.jpg")));

        new Card("Clear Weather", 605, 0, 3, false, null, CardType.Weather, Place.weatherPlace,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/weather_clear.jpg")));

        new Card("Scorch", 606, 0, 3, false, null, CardType.Spell, Place.CSRMarCo,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/special_scorch.jpg")));

        new Card("Commander's Horn", 607, 0, 3, false, null, CardType.Spell, Place.CSRMarCo,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/special_horn.jpg")));

        new Card("Decoy", 608, 0, 3, false, null, CardType.Spell, Place.CSR,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/special_decoy.jpg")));

        new Card("Dandelion", 609, 2, 3, false, Ability.CommandersHorn, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_dandelion.jpg")));

        new Card("Cow", 610, 0, 1, false, Ability.Transformers, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_cow.jpg")));

        new Card("Emiel Regis", 611, 5, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_emiel.jpg")));

        new Card("Gaunter O’Dimm", 612, 2, 1, false, Ability.Muster, CardType.SiegeUnit, Place.siege,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_gaunter_odimm.jpg")));

        new Card("Gaunter O’Dimm Darkness", 613, 4, 3, false, Ability.Muster, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_gaunter_odimm_darkness.jpg")));

        new Card("Geralt Of Rivia", 614, 15, 1, true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_geralt.jpg")));

        new Card("Mysterious Elf", 615, 0, 1, true, Ability.Spy, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_mysterious_elf.jpg")));

        new Card("Olgierd Von Everec", 616, 6, 1, false, Ability.MoralBoost, CardType.AgileUnit, Place.agile,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_olgierd.jpg")));

        new Card("Triss Merigold", 617, 7, 1, true, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_triss.jpg")));

        new Card("Vesemir", 618, 6, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_vesemir.jpg")));

        new Card("Villentretenmerth", 619, 7, 1, false, Ability.Scorch, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_villen.jpg")));

        new Card("Yennefer of Vengerberg", 620, 7, 1, true, Ability.Medic, CardType.RangedUnit, Place.rangedCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_yennefer.jpg")));

        new Card("Zoltan Chivay", 621, 5, 1, false, null, CardType.CloseCombatUnit, Place.closeCombat,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/special/neutral_zoltan.jpg")));



        new Card("Crach an Craite", 11, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/skellige_crach_an_craite.jpg")));

        new Card("King Bran", 12, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/skellige_king_bran.jpg")));

        new Card("Queen of Dol Blathanna", 21, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/scoiatael_francesca_silver.jpg")));

        new Card("The Beautiful", 22, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/scoiatael_francesca_gold.jpg")));

        new Card("Daisy of the Valley", 23, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/scoiatael_francesca_copper.jpg")));

        new Card("Pureblood Elf", 24, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/scoiatael_francesca_bronze.jpg")));

        new Card("Hope of the Aen Seidhe", 25, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/scoiatael_francesca_hope_of_the_aen_seidhe.jpg")));

        new Card("The Siegemaster", 31, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/realms_foltest_silver.jpg")));

        new Card("The Steel-Forged", 32, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/realms_foltest_gold.jpg")));

        new Card("King of Temeria", 33, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/realms_foltest_copper.jpg")));

        new Card("Lord Commander of the North", 34, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/realms_foltest_bronze.jpg")));

        new Card("Son of Medell", 35, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/realms_foltest_son_of_medell.jpg")));

        new Card("The White Flame", 41, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/nilfgaard_emhyr_silver.jpg")));

        new Card("His Imperial Majesty", 42, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/nilfgaard_emhyr_copper.jpg")));

        new Card("Emperor of Nilfgaard", 43, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/nilfgaard_emhyr_bronze.jpg")));

        new Card("The Relentless", 44, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/nilfgaard_emhyr_gold.jpg")));

        new Card("Invader of the North", 45, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/nilfgaard_emhyr_invader_of_the_north.jpg")));

        new Card("Bringer of Death", 51, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/monsters_eredin_silver.jpg")));

        new Card("King of the Wild Hunt", 52, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/monsters_eredin_bronze.jpg")));

        new Card("Destroyer of Worlds", 53, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/monsters_eredin_gold.jpg")));

        new Card("Commander of the Red Riders", 54, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/monsters_eredin_copper.jpg")));

        new Card("The Treacherous", 55, 0, 1, false, null, CardType.Leader, Place.Leader,
                new Image(SetDefaults.class.getResourceAsStream("/images/cards/leaders/monsters_eredin_the_treacherous.jpg")));

    }

    public static void setFaction() {
        Faction skellige = new Faction("Skellige", new Image(SetDefaults.class.getResourceAsStream("/images/cards/skellige/faction_skellige.jpg")));
        for (Card card : Card.getCards()) {
            if ((card.getID() > 100 && card.getID() < 200) || (card.getID() > 600 && card.getID() < 700)) {
                skellige.addToCards(card);
            } else if (card.getID() > 10 && card.getID() < 20) skellige.addToLeaderCards(card);
        }


        Faction scoiatael = new Faction("Scoia'tael", new Image(SetDefaults.class.getResourceAsStream("/images/cards/scoiatael/faction_scoiatael.jpg")));
        for (Card card : Card.getCards()) {
            if ((card.getID() > 200 && card.getID() < 300) || (card.getID() > 600 && card.getID() < 700)) {
                scoiatael.addToCards(card);
            } else if (card.getID() > 20 && card.getID() < 30) scoiatael.addToLeaderCards(card);
        }

        Faction northernRealms = new Faction("Northern Realms", new Image(SetDefaults.class.getResourceAsStream("/images/cards/northernRealms/faction_realms.jpg")));
        for (Card card : Card.getCards()) {
            if ((card.getID() > 300 && card.getID() < 400) || (card.getID() > 600 && card.getID() < 700)) {
                northernRealms.addToCards(card);
            } else if (card.getID() > 30 && card.getID() < 40) northernRealms.addToLeaderCards(card);
        }

        Faction nilfgaard = new Faction("Nilfgaard", new Image(SetDefaults.class.getResourceAsStream("/images/cards/nilfgaard/faction_nilfgaard.jpg")));
        for (Card card : Card.getCards()) {
            if ((card.getID() > 400 && card.getID() < 500) || (card.getID() > 600 && card.getID() < 700)) {
                nilfgaard.addToCards(card);
            } else if (card.getID() > 40 && card.getID() < 50) nilfgaard.addToLeaderCards(card);
        }

        Faction monsters = new Faction("Monsters", new Image(SetDefaults.class.getResourceAsStream("/images/cards/monsters/faction_monsters.jpg")));
        for (Card card : Card.getCards()) {
            if ((card.getID() > 500 && card.getID() < 600) || (card.getID() > 600 && card.getID() < 700)) {
                monsters.addToCards(card);
            } else if (card.getID() > 50 && card.getID() < 60) monsters.addToLeaderCards(card);
        }
    }

    public static void setQuestion() {

    }
}

