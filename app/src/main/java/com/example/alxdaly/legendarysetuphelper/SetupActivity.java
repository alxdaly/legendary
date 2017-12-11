package com.example.alxdaly.legendarysetuphelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Henchmen;
import com.example.alxdaly.legendarysetuphelper.enums.Heroes;
import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;
import com.example.alxdaly.legendarysetuphelper.enums.Schemes;
import com.example.alxdaly.legendarysetuphelper.enums.TeamIcons;
import com.example.alxdaly.legendarysetuphelper.enums.VillainGroups;
import com.example.alxdaly.legendarysetuphelper.helper.HenchmenHelper;
import com.example.alxdaly.legendarysetuphelper.helper.HeroHelper;
import com.example.alxdaly.legendarysetuphelper.helper.VillainHelper;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Henchman;
import com.example.alxdaly.legendarysetuphelper.pojo.Hero;
import com.example.alxdaly.legendarysetuphelper.pojo.Mastermind;
import com.example.alxdaly.legendarysetuphelper.pojo.Scheme;
import com.example.alxdaly.legendarysetuphelper.pojo.Villain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SetupActivity extends AppCompatActivity {
    Random random;
    private int numPlayers;
    private int numVillains;
    private int numHenchmen;
    private int numHeroes;
    private int numBystanders;

    private int twists;
    private String notes;
    private Scheme scheme;
    private Mastermind mastermind;
    private List<Villain> villains;
    private List<Henchman> henchmen;
    private List<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        Bundle extra = getIntent().getExtras();
        random = new Random();
        numPlayers = extra.getInt("numberOfPlayers");
        notes = "";
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
        villains = new ArrayList<>();
        heroes = new ArrayList<>();
        henchmen = new ArrayList<>();
    }

    private void setupCards() throws IOException{
        chooseScheme();
        getTwists();
        getBystanders();
        chooseMastermind();
        chooseVillains();
        chooseHenchmen();
        chooseHeroes();
        getNotes();
    }

    private void chooseScheme() {
        scheme = new Scheme(Schemes.values()[random.nextInt(Schemes.values().length)], this);
        switch(scheme.getScheme()){
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
                addVillain(new Villain(VillainGroups.SKRULLS, this));
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
                addHero(new Hero(Heroes.DEADPOOL_DEADPOOL, this));
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
                addHero(new Hero(Heroes.DEADPOOL_DEADPOOL, this));
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
                addVillain(new Villain(VillainGroups.SINISTER_SIX, this));
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
        TextView schemeLabel = (TextView) findViewById(R.id.schemeLabel);
        schemeLabel.setText(scheme.getCardTitle());
    }

    private void getBystanders() {
        TextView bystanderLabel = (TextView) findViewById(R.id.bystanderLabel);
        bystanderLabel.setText(numBystanders + "");
    }

    private void getTwists() {
        TextView twistLabel = (TextView) findViewById(R.id.twistLabel);
        twistLabel.setText(twists + "");
    }

    private Hero chooseTeamIconHero(TeamIcons teamIcon){
        List<Hero> heroes = new ArrayList<>();
        switch(teamIcon){
            case AVENGERS:
                heroes.add(new Hero(Heroes.BLACK_WIDOW, this));
                heroes.add(new Hero(Heroes.CAPT_AMERICA, this));
                heroes.add(new Hero(Heroes.IRON_MAN, this));
                heroes.add(new Hero(Heroes.HULK, this));
                heroes.add(new Hero(Heroes.HAWKEYE, this));
                heroes.add(new Hero(Heroes.THOR, this));
                heroes.add(new Hero(Heroes.IRON_MAN_NOIR, this));
                break;
            case XMEN:
                heroes.add(new Hero(Heroes.STORM, this));
                heroes.add(new Hero(Heroes.WOLVERINE, this));
                heroes.add(new Hero(Heroes.CYCLOPS, this));
                heroes.add(new Hero(Heroes.ROGUE, this));
                heroes.add(new Hero(Heroes.EMMA_FROST, this));
                heroes.add(new Hero(Heroes.GAMBIT, this));
                heroes.add(new Hero(Heroes.ANGEL_NOIR, this));
                break;
            case SPIDER_FRIENDS:
                heroes.add(new Hero(Heroes.SPIDER_MAN, this));
                heroes.add(new Hero(Heroes.SPIDER_MAN_NOIR, this));
                heroes.add(new Hero(Heroes.SPIDER_WOMAN, this));
                heroes.add(new Hero(Heroes.BLACK_CAT, this));
                heroes.add(new Hero(Heroes.SYMBIOTE_SPIDER_MAN, this));
                heroes.add(new Hero(Heroes.SCARLET_SPIDER, this));
                break;
            case SHIELD:
                heroes.add(new Hero(Heroes.NICK_FURY, this));
                break;
            case MERCS_FOR_MONEY:
                heroes.add(new Hero(Heroes.DEADPOOL_DEADPOOL, this));
                heroes.add(new Hero(Heroes.SOLO, this));
                heroes.add(new Hero(Heroes.SLAPSTICK, this));
                heroes.add(new Hero(Heroes.STINGRAY, this));
                break;
            case HYDRA:
                heroes.add(new Hero(Heroes.BOB, this));
                break;
            case MARVEL_KNIGHTS:
                heroes.add(new Hero(Heroes.DAREDEVIL_NOIR, this));
                heroes.add(new Hero(Heroes.LUKE_CAGE_NOIR, this));
                heroes.add(new Hero(Heroes.MOON_KNIGHT, this));
                break;
            default:
                heroes.add(new Hero(Heroes.DEADPOOL_BASE, this));
        }
        int option = random.nextInt(heroes.size());
        return heroes.get(option);
    }

    private void chooseMastermind(){
        mastermind = new Mastermind(Masterminds.values()[random.nextInt(Masterminds.values().length)], this);
        switch(mastermind.getMastermind()){
            case RED_SKULL:
                addVillain(new Villain(VillainGroups.HYDRA, this));
                break;
            case MAGNETO:
                addVillain(new Villain(VillainGroups.BROTHERHOOD, this));
                break;
            case LOKI:
                addVillain(new Villain(VillainGroups.ENEMIES_OF_ASGARD, this));
                break;
            case DR_DOOM:
                addHenchman(new Henchman(Henchmen.DOOMBOT_LEGION, this));
                break;
            case EVIL_DEADPOOL:
                addVillain(new Villain(VillainGroups.EVIL_DEADPOOL_CORPSE, this));
                break;
            case MACHO_GOMEZ:
                addVillain(new Villain(VillainGroups.DEADPOOL_FRIENDS, this));
                break;
            case CHARLES_XAVIER_PROFESSOR_CRIME:
                addVillain(new Villain(VillainGroups.XMEN_NOIR, this));
                break;
            case GOBLIN_UNDERWORLD_BOSS:
                addVillain(new Villain(VillainGroups.GOBLIN_FREAK_SHOW, this));
                break;
            case MYSTERIO:
                addVillain(new Villain(VillainGroups.SINISTER_SIX, this));
                break;
            case CARNAGE:
                addVillain(new Villain(VillainGroups.MAXIUMUM_CARNAGE, this));
            default:
        }
        TextView mastermindLabel = (TextView) findViewById(R.id.mastermindLabel);
        mastermindLabel.setText(mastermind.getCardTitle());
    }

    private void chooseVillains() {
//        while(numVillains > 0){
//            VillainGroups villain = VillainGroups.values()[random.nextInt(VillainGroups.values().length)];
//            boolean pickedAlready = false;
//            for(Villain next: villains){
//                if(next.getVillain() == villain){
//                    pickedAlready = true;
//                    break;
//                }
//            }
//            if(!pickedAlready){
//                addVillain(new Villain(villain, this));
//            }
//        }
        VillainHelper villainHelper = new VillainHelper(new ArrayList<Expansions>(), villains, numVillains, this);
        TextView villainLabel = (TextView) findViewById(R.id.villainLabel);
        villainLabel.setText(buildStringList(villainHelper.chooseCards()));
    }

    private void chooseHeroes() {
        HeroHelper heroHelper = new HeroHelper(new ArrayList<Expansions>(), heroes, numHeroes, this);
        TextView heroesLabel = (TextView) findViewById(R.id.heroesLabel);
        heroesLabel.setText(buildStringList(heroHelper.chooseCards()));
    }

    private void chooseHenchmen() {
        HenchmenHelper henchmenHelper = new HenchmenHelper(new ArrayList<Expansions>(), henchmen, numHenchmen, this);
        TextView henchmenLabel = (TextView) findViewById(R.id.henchmenLabel);
        henchmenLabel.setText(buildStringList(henchmenHelper.chooseCards()));
    }

    private void getNotes() {
        TextView notesLabel = (TextView) findViewById(R.id.notesLabel);
        notesLabel.setText(notes);
    }

    private void addVillain(Villain villain){
        villains.add(villain);
    }

    private void addHero(Hero hero){
        heroes.add(hero);
    }

    private void addHenchman(Henchman henchman){
        henchmen.add(henchman);
    }

    private String buildStringList(List<? extends Card> cards){
        String result = "";
        for(Card next: cards){
            result += next.getCardTitle() + '\n';
        }
        return result;
    }
}
