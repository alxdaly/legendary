package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Henchmen;
import com.example.alxdaly.legendarysetuphelper.enums.Heroes;
import com.example.alxdaly.legendarysetuphelper.enums.TeamIcons;
import com.example.alxdaly.legendarysetuphelper.enums.VillainGroups;
import com.example.alxdaly.legendarysetuphelper.pojo.Henchman;
import com.example.alxdaly.legendarysetuphelper.pojo.Hero;
import com.example.alxdaly.legendarysetuphelper.pojo.Mastermind;
import com.example.alxdaly.legendarysetuphelper.pojo.Scheme;
import com.example.alxdaly.legendarysetuphelper.pojo.Villain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Handles logic of SetupActivity
 *
 * Created by alxdaly on 12/11/2017.
 */

public class DeckHelper {
    private HenchmenHelper henchmenHelper;
    private HeroHelper heroHelper;
    private MastermindHelper mastermindHelper;
    private SchemeHelper schemeHelper;
    private VillainHelper villainHelper;
    private Context context;
    private int numPlayers;
    private int numBystanders;
    private int twists;
    private String notes;
    private Random random;

    public DeckHelper(List<Expansions> expansions, Context context, int numPlayers, int numVillains, int numHenchmen, int numHeroes, int numBystanders) {
        this.context = context;
        this.schemeHelper = new SchemeHelper(expansions, new ArrayList<Scheme>(), context);
        this.mastermindHelper = new MastermindHelper(expansions, new ArrayList<Mastermind>(), context);
        this.henchmenHelper = new HenchmenHelper(expansions, new ArrayList<Henchman>(), numHenchmen, context);
        this.heroHelper = new HeroHelper(expansions, new ArrayList<Hero>(), numHeroes, context);
        this.villainHelper = new VillainHelper(expansions, new ArrayList<Villain>(), numVillains, context);
        this.numPlayers = numPlayers;
        this.numBystanders = numBystanders;
        this.twists = 0;
        this.notes = "";
        this.random = new Random();
    }

    public int getTwists() {
        return twists;
    }

    public String getNotes() {
        return notes;
    }

    public Scheme getScheme() {
        Scheme scheme = (Scheme) schemeHelper.chooseCards().get(0);
        switch(scheme.getScheme()){
            case NEGATIVE_ZONE:
                twists = 8;
                henchmenHelper.incrementNumCards();
                break;
            case MIDTOWN_BANK_ROBBERY:
                twists = 8;
                notes = "12 total Bystanders in the Villain Deck.\n";
                break;
            case CIVIL_WAR:
                if(numPlayers <= 2){
                    twists = 8;
                    heroHelper.setNumCards(4);
                }
                else if(numPlayers == 3){
                    twists = 8;
                }
                else {
                    twists = 5;
                }
                break;
            case LEGACY_VIRUS:
                twists = 8;
                notes = "Wound stack holds 6 wounds per player.\n";
                break;
            case SECRET_INVASION:
                twists = 8;
                heroHelper.setNumCards(6);
                villainHelper.addCard(new Villain(VillainGroups.SKRULLS, context));
                notes = "Put 12 random heroes from Hero Deck into Villain Deck.\n";
                break;
            case KILLBOTS:
                twists = 5;
                notes = "3 additional Twists next to Scheme.\n18 Bystanders in Villain Deck.";
                break;
            case DEADPOOL_KILLS_MARVEL:
                if(numPlayers == 2){
                    heroHelper.setNumCards(4);
                }
                heroHelper.addCard(new Hero(Heroes.DEADPOOL_DEADPOOL, context));
                if(numPlayers <= 3){
                    twists = 6;
                }
                else {
                    twists = 5;
                }
                break;
            case DEADPOOL_WANTS_CHIMICHANGA:
                twists = 6;
                notes = "12 Bystanders in a Villain Deck.";
                if(numPlayers >= 3){
                    villainHelper.incrementNumCards();
                }
                break;
            case DEADPOOL_WRITES_SCHEME:
                twists = 6;
                heroHelper.addCard(new Hero(Heroes.DEADPOOL_DEADPOOL, context));
                break;
            case EVERYONE_HATES_DEADPOOL:
                twists = 6;
                heroHelper.addCard(chooseTeamIconHero(TeamIcons.MERCS_FOR_MONEY));
                break;
            case FIVE_FAMILIES:
                twists = 8;
                villainHelper.incrementNumCards();
                villainHelper.incrementNumCards();
                break;
            case SPIDER_DNA:
                twists = 8;
                villainHelper.addCard(new Villain(VillainGroups.SINISTER_SIX, context));
                break;
            case DAILY_BUGLE:
                twists = 8;
                notes = "Add 6 extra Henchmen from single Henchmen Group to Hero Deck.";
                break;
            case SILENCE_WITNESSES:
                twists = 6;
                break;
            case DARK_DIMENSION:
            case WEB_OF_LIES:
                twists = 7;
                break;
            default:
                twists = 8;
        }
        return scheme;
    }

    public Mastermind getMastermind() {
        Mastermind mastermind = (Mastermind) mastermindHelper.chooseCards().get(0);
        switch(mastermind.getMastermind()){
            case RED_SKULL:
                villainHelper.addCard(new Villain(VillainGroups.HYDRA, context));
                break;
            case MAGNETO:
                villainHelper.addCard(new Villain(VillainGroups.BROTHERHOOD, context));
                break;
            case LOKI:
                villainHelper.addCard(new Villain(VillainGroups.ENEMIES_OF_ASGARD, context));
                break;
            case DR_DOOM:
                henchmenHelper.addCard(new Henchman(Henchmen.DOOMBOT_LEGION, context));
                break;
            case EVIL_DEADPOOL:
                villainHelper.addCard(new Villain(VillainGroups.EVIL_DEADPOOL_CORPSE, context));
                break;
            case MACHO_GOMEZ:
                villainHelper.addCard(new Villain(VillainGroups.DEADPOOL_FRIENDS, context));
                break;
            case CHARLES_XAVIER_PROFESSOR_CRIME:
                villainHelper.addCard(new Villain(VillainGroups.XMEN_NOIR, context));
                break;
            case GOBLIN_UNDERWORLD_BOSS:
                villainHelper.addCard(new Villain(VillainGroups.GOBLIN_FREAK_SHOW, context));
                break;
            case MYSTERIO:
                villainHelper.addCard(new Villain(VillainGroups.SINISTER_SIX, context));
                break;
            case CARNAGE:
                villainHelper.addCard(new Villain(VillainGroups.MAXIUMUM_CARNAGE, context));
            default:
        }
        return mastermind;
    }

    public List<Henchman> getHenchmen() {
        return (List<Henchman>) henchmenHelper.chooseCards();
    }

    public List<Hero> getHeroes() {
        return (List<Hero>) heroHelper.chooseCards();
    }

    public List<Villain> getVillains() {
        return (List<Villain>) villainHelper.chooseCards();
    }

    public int getNumBystanders() {
        return this.numBystanders;
    }

    private Hero chooseTeamIconHero(TeamIcons teamIcon){
        List<Hero> heroes = new ArrayList<>();
        switch(teamIcon){
            case AVENGERS:
                heroes.add(new Hero(Heroes.BLACK_WIDOW, context));
                heroes.add(new Hero(Heroes.CAPT_AMERICA, context));
                heroes.add(new Hero(Heroes.IRON_MAN, context));
                heroes.add(new Hero(Heroes.HULK, context));
                heroes.add(new Hero(Heroes.HAWKEYE, context));
                heroes.add(new Hero(Heroes.THOR, context));
                heroes.add(new Hero(Heroes.IRON_MAN_NOIR, context));
                break;
            case XMEN:
                heroes.add(new Hero(Heroes.STORM, context));
                heroes.add(new Hero(Heroes.WOLVERINE, context));
                heroes.add(new Hero(Heroes.CYCLOPS, context));
                heroes.add(new Hero(Heroes.ROGUE, context));
                heroes.add(new Hero(Heroes.EMMA_FROST, context));
                heroes.add(new Hero(Heroes.GAMBIT, context));
                heroes.add(new Hero(Heroes.ANGEL_NOIR, context));
                break;
            case SPIDER_FRIENDS:
                heroes.add(new Hero(Heroes.SPIDER_MAN, context));
                heroes.add(new Hero(Heroes.SPIDER_MAN_NOIR, context));
                heroes.add(new Hero(Heroes.SPIDER_WOMAN, context));
                heroes.add(new Hero(Heroes.BLACK_CAT, context));
                heroes.add(new Hero(Heroes.SYMBIOTE_SPIDER_MAN, context));
                heroes.add(new Hero(Heroes.SCARLET_SPIDER, context));
                break;
            case SHIELD:
                heroes.add(new Hero(Heroes.NICK_FURY, context));
                break;
            case MERCS_FOR_MONEY:
                heroes.add(new Hero(Heroes.DEADPOOL_DEADPOOL, context));
                heroes.add(new Hero(Heroes.SOLO, context));
                heroes.add(new Hero(Heroes.SLAPSTICK, context));
                heroes.add(new Hero(Heroes.STINGRAY, context));
                break;
            case HYDRA:
                heroes.add(new Hero(Heroes.BOB, context));
                break;
            case MARVEL_KNIGHTS:
                heroes.add(new Hero(Heroes.DAREDEVIL_NOIR, context));
                heroes.add(new Hero(Heroes.LUKE_CAGE_NOIR, context));
                heroes.add(new Hero(Heroes.MOON_KNIGHT, context));
                break;
            default:
                heroes.add(new Hero(Heroes.DEADPOOL_BASE, context));
        }
        int option = random.nextInt(heroes.size());
        return heroes.get(option);
    }
}
