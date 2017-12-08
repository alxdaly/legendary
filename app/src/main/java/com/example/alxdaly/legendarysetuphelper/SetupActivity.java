package com.example.alxdaly.legendarysetuphelper;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alxdaly.legendarysetuphelper.enums.Henchmen;
import com.example.alxdaly.legendarysetuphelper.enums.Heroes;
import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;
import com.example.alxdaly.legendarysetuphelper.enums.Schemes;
import com.example.alxdaly.legendarysetuphelper.enums.TeamIcons;
import com.example.alxdaly.legendarysetuphelper.enums.VillainGroups;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Henchman;
import com.example.alxdaly.legendarysetuphelper.pojo.Hero;
import com.example.alxdaly.legendarysetuphelper.pojo.Mastermind;
import com.example.alxdaly.legendarysetuphelper.pojo.Villain;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SetupActivity extends AppCompatActivity {
    Random random;
    private int numPlayers;
    private int numVillains;
    private int numHenchmen;
    private int numHeroes;
    private int numBystanders;

    private int twists;
    private String notes;
    private Schemes scheme;
    private Mastermind mastermind;
    private ArrayList<Villain> villains;
    private ArrayList<Henchman> henchmen;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        Bundle extra = getIntent().getExtras();
        random = new Random();
        numPlayers = extra.getInt("numberOfPlayers");
        setup(numPlayers);
        try {
            setupCards();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void setup(int numPlayers){
        TextView gameTitle = (TextView) findViewById(R.id.gameTitle);
        switch(numPlayers){
            case 1:
                gameTitle.setText(getString(R.string.P1));
                TextView p1Hench = (TextView) findViewById(R.id.p1henchLabel);
                p1Hench.setVisibility(View.VISIBLE);
                numVillains = 1;
                numHenchmen = 1;
                numHeroes = 3;
                numBystanders = 1;
                break;
            case 2:
                gameTitle.setText(getString(R.string.P2));
                numVillains = 2;
                numHenchmen = 1;
                numHeroes = 5;
                numBystanders = 2;
                break;
            case 3:
                gameTitle.setText(getString(R.string.P3));
                numVillains = 3;
                numHenchmen = 1;
                numHeroes = 5;
                numBystanders = 8;
                break;
            case 4:
                gameTitle.setText(getString(R.string.P4));
                numVillains = 3;
                numHenchmen = 2;
                numHeroes = 5;
                numBystanders = 8;
                break;
            case 5:
                gameTitle.setText(getString(R.string.P5));
                numVillains = 4;
                numHenchmen = 2;
                numHeroes = 6;
                numBystanders = 12;
                break;
        }
    }

    private void setupCards() throws IOException{
        chooseScheme();
        chooseMastermind();
        chooseVillains();
        chooseHenchmen();
        chooseHeroes();
    }

    private void chooseScheme() {
        scheme = Schemes.values()[random.nextInt(Schemes.values().length)];
        switch(scheme){
            case NEGATIVE_ZONE:
                twists = 8;
                numHenchmen++;
                break;
            case MIDTOWN_BANK_ROBBERY:
                twists = 8;
                notes = "12 total Bystanders in the Villain Deck.\n";
                break;
            case CIVIL_WAR:
                if(numPlayers <= 2){
                    twists = 8;
                    numHeroes = 4;
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
                numHeroes = 6;
                addVillain(new Villain(VillainGroups.SKRULLS));
                notes = "Put 12 random heroes from Hero Deck into Villain Deck.\n";
                break;
            case KILLBOTS:
                twists = 5;
                notes = "3 additional Twists next to Scheme.\n18 Bystanders in Villain Deck.";
                break;
            case DEADPOOL_KILLS_MARVEL:
                if(numPlayers == 2){
                    numHeroes = 4;
                }
                addHero(new Hero(Heroes.DEADPOOL_DEADPOOL));
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
                    numVillains++;
                }
                break;
            case DEADPOOL_WRITES_SCHEME:
                twists = 6;
                addHero(new Hero(Heroes.DEADPOOL_DEADPOOL));
                break;
            case EVERYONE_HATES_DEADPOOL:
                twists = 6;
                addHero(chooseTeamIconHero(TeamIcons.MERCS_FOR_MONEY));
                break;
            case FIVE_FAMILIES:
                twists = 8;
                numVillains += 2;
                break;
            case SPIDER_DNA:
                twists = 8;
                addVillain(new Villain(VillainGroups.SINISTER_SIX));
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
    }

    private Hero chooseTeamIconHero(TeamIcons teamIcon){
        List<Hero> heroes = new ArrayList<>();
        switch(teamIcon){
            case AVENGERS:
                heroes.add(new Hero(Heroes.BLACK_WIDOW));
                heroes.add(new Hero(Heroes.CAPT_AMERICA));
                heroes.add(new Hero(Heroes.IRON_MAN));
                heroes.add(new Hero(Heroes.HULK));
                heroes.add(new Hero(Heroes.HAWKEYE));
                heroes.add(new Hero(Heroes.THOR));
                heroes.add(new Hero(Heroes.IRON_MAN_NOIR));
                break;
            case XMEN:
                heroes.add(new Hero(Heroes.STORM));
                heroes.add(new Hero(Heroes.WOLVERINE));
                heroes.add(new Hero(Heroes.CYCLOPS));
                heroes.add(new Hero(Heroes.ROGUE));
                heroes.add(new Hero(Heroes.EMMA_FROST));
                heroes.add(new Hero(Heroes.GAMBIT));
                heroes.add(new Hero(Heroes.ANGEL_NOIR));
                break;
            case SPIDER_FRIENDS:
                heroes.add(new Hero(Heroes.SPIDER_MAN));
                heroes.add(new Hero(Heroes.SPIDER_MAN_NOIR));
                heroes.add(new Hero(Heroes.SPIDER_WOMAN));
                heroes.add(new Hero(Heroes.BLACK_CAT));
                heroes.add(new Hero(Heroes.SYMBIOTE_SPIDER_MAN));
                heroes.add(new Hero(Heroes.SCARLET_SPIDER));
                break;
            case SHIELD:
                heroes.add(new Hero(Heroes.NICK_FURY));
                break;
            case MERCS_FOR_MONEY:
                heroes.add(new Hero(Heroes.DEADPOOL_DEADPOOL));
                heroes.add(new Hero(Heroes.SOLO));
                heroes.add(new Hero(Heroes.SLAPSTICK));
                heroes.add(new Hero(Heroes.STINGRAY));
                break;
            case HYDRA:
                heroes.add(new Hero(Heroes.BOB));
                break;
            case MARVEL_KNIGHTS:
                heroes.add(new Hero(Heroes.DAREDEVIL_NOIR));
                heroes.add(new Hero(Heroes.LUKE_CAGE_NOIR));
                heroes.add(new Hero(Heroes.MOON_KNIGHT));
                break;
            default:
                heroes.add(new Hero(Heroes.DEADPOOL_BASE));
        }
        int option = random.nextInt(heroes.size());
        return heroes.get(option);
    }

    private void chooseMastermind(){
        mastermind = new Mastermind(Masterminds.values()[random.nextInt(Masterminds.values().length)]);
        switch(mastermind.getMastermind()){
            case RED_SKULL:
                addVillain(new Villain(VillainGroups.HYDRA));
                break;
            case MAGNETO:
                addVillain(new Villain(VillainGroups.BROTHERHOOD));
                break;
            case LOKI:
                addVillain(new Villain(VillainGroups.ENEMIES_OF_ASGARD));
                break;
            case DR_DOOM:
                addHenchman(new Henchman(Henchmen.DOOMBOT_LEGION));
                break;
            case EVIL_DEADPOOL:
                addVillain(new Villain(VillainGroups.EVIL_DEADPOOL_CORPSE));
                break;
            case MACHO_GOMEZ:
                addVillain(new Villain(VillainGroups.DEADPOOL_FRIENDS));
                break;
            case CHARLES_XAVIER_PROFESSOR_CRIME:
                addVillain(new Villain(VillainGroups.XMEN_NOIR));
                break;
            case GOBLIN_UNDERWORLD_BOSS:
                addVillain(new Villain(VillainGroups.GOBLIN_FREAK_SHOW));
                break;
            case MYSTERIO:
                addVillain(new Villain(VillainGroups.SINISTER_SIX));
                break;
            case CARNAGE:
                addVillain(new Villain(VillainGroups.MAXIUMUM_CARNAGE));
            default:
        }
    }

    private void chooseVillains() {
        while(numVillains > 0){
            VillainGroups villain = VillainGroups.values()[random.nextInt(VillainGroups.values().length)];
            boolean pickedAlready = false;
            for(Villain next: villains){
                if(next.getVillain() == villain){
                    pickedAlready = true;
                    break;
                }
            }
            if(!pickedAlready){
                addVillain(new Villain(villain));
            }
        }
    }

    private void chooseHeroes() {
        while(numHeroes > 0){
            Heroes hero = Heroes.values()[random.nextInt(Heroes.values().length)];
            boolean pickedAlready = false;
            for(Hero next: heroes){
                if(next.getHero() == hero){
                    pickedAlready = true;
                    break;
                }
            }
            if(!pickedAlready){
                addHero(new Hero(hero));
            }
        }
    }

    private void chooseHenchmen() {
        while(numHenchmen > 0){
            Henchmen henchman = Henchmen.values()[random.nextInt(Henchmen.values().length)];
            boolean pickedAlready = false;
            for(Henchman next: henchmen){
                if(next.getHenchmen() == henchman){
                    pickedAlready = true;
                    break;
                }
            }
            if(!pickedAlready){
                addHenchman(new Henchman(henchman));
            }
        }
    }

    private void addVillain(Villain villain){
        villains.add(villain);
        numVillains--;
    }

    private void addHero(Hero hero){
        heroes.add(hero);
        numHeroes--;
    }

    private void addHenchman(Henchman henchman){
        henchmen.add(henchman);
        numHenchmen--;
    }
}
