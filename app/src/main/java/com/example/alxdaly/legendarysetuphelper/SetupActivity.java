package com.example.alxdaly.legendarysetuphelper;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alxdaly.legendarysetuphelper.pojo.Card;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SetupActivity extends AppCompatActivity {
    Random random;
    private int numPlayers;
    private int numVillains;
    private int numHenchmen;
    private int numHeroes;
    private int numBystanders;
    private ArrayList<Card> masterminds;
    private ArrayList<Card> schemes;
    private ArrayList<Card> villains;
    private ArrayList<Card> henchmen;
    private ArrayList<Card> heroes;

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
        masterminds = parseCards("masterminds.txt");
        schemes = parseCards("schemes.txt");
        villains = parseCards("villains.txt");
        henchmen = parseCards("henchmen.txt");
        heroes = parseCards("heroes.txt");
        chooseMastermind();
        chooseScheme();
        getBystanders();
        chooseVillains();
        chooseHenchmen();
        chooseHeroes();
    }

    private ArrayList<Card> parseCards(String textFile) throws IOException {
        ArrayList<Card> list = new ArrayList<>();
        Card curr = new Card(null, 0);
        AssetManager assetManager = getAssets();
        InputStream file = assetManager.open(textFile);
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            Scanner word = new Scanner(scan.nextLine());
            String expansion = word.next();
            String name = "";
            while(word.hasNext()){
                name += word.next() + " ";
            }
            switch(expansion){
                case "base":
                    curr = new Card(name, 0);
                    break;
                case "deadpool":
                    curr = new Card(name, 1);
                    break;
                case "paint":
                    curr = new Card(name, 2);
                    break;
            }
            list.add(curr);
        }
        return list;
    }

    private void chooseMastermind() {
        TextView mastermindLabel = (TextView) findViewById(R.id.mastermindLabel);
        int next = random.nextInt();
        next = next % masterminds.size();
        if(next < 0){
            next *= -1;
        }
        mastermindLabel.setText(masterminds.get(next).getString());
    }

    private void chooseScheme() {
        TextView schemeLabel = (TextView) findViewById(R.id.schemeLabel);
        int next = random.nextInt();
        next = next % schemes.size();
        if(next < 0){
            next *= -1;
        }
        schemeLabel.setText(schemes.get(next).getString());
    }

    private void getBystanders() {
        TextView bystanderLabel = (TextView) findViewById(R.id.bystanderLabel);
        bystanderLabel.setText(numBystanders + "");
    }

    private void chooseVillains() {
        TextView villainLabel = (TextView) findViewById(R.id.villainLabel);
        int villainCount = 0;
        if(numPlayers > 1){
            Card find = null;
            TextView mastermindLabel = (TextView) findViewById(R.id.mastermindLabel);
            String mastermind = mastermindLabel.getText().toString();
            if(mastermind.contains("Red Skull")){
                find = new Card("Hydra", 0);
            }
            else if(mastermind.contains("Loki")){
                find = new Card("Enemies of Asgard", 0);
            }
            else if(mastermind.contains("Magneto")){
                find = new Card("Brotherhood", 0);
            }
            else if(mastermind.contains("Evil Deadpool")){
                find = new Card("Evil Deadpool Corpse", 1);
            }
            else if(mastermind.contains("Macho Gomez")){
                find = new Card("Deadpool's \"Friends\"", 1);
            }
            else if(mastermind.contains("Mysterio")){
                find = new Card("Sinister Six", 2);
            }
            else if(mastermind.contains("Carnage")){
                find = new Card("Maximum Carnage", 2);
            }
            if(find != null) {
                villains.remove(find);
                villainLabel.setText(find.getString() + "\n");
                villainCount++;
            }
        }
        while(villainCount < numVillains){
            int next = random.nextInt();
            next = next % villains.size();
            if(next < 0){
                next *= -1;
            }
            villainLabel.append(villains.remove(next).getString() + "\n");
            villainCount++;
        }
    }

    private void chooseHenchmen() {
        int henchmenCount = 0;
        TextView henchmenLabel = (TextView) findViewById(R.id.henchmenLabel);
        if(numPlayers > 1){
            Card find = null;
            TextView mastermindLabel = (TextView) findViewById(R.id.mastermindLabel);
            String mastermind = mastermindLabel.getText().toString();
            if(mastermind.contains("Dr. Doom")){
                find = new Card("Doombot Legion", 0);
            }
            if(find != null) {
                henchmen.remove(find);
                henchmenLabel.setText(find.getString() + "\n");
                henchmenCount++;
            }
        }
        else{
            TextView henchmen1P = (TextView) findViewById(R.id.p1henchLabel);
            henchmen1P.setVisibility(View.VISIBLE);
        }
        while(henchmenCount < numHenchmen){
            int next = random.nextInt();
            next = next % henchmen.size();
            if(next < 0){
                next *= -1;
            }
            henchmenLabel.append(henchmen.remove(next).getString() + "\n");
            henchmenCount++;
        }
    }

    private void chooseHeroes() {
        int heroCount = 0;
        TextView heroesLabel = (TextView) findViewById(R.id.heroesLabel);
        while(heroCount < numHeroes){
            int next = random.nextInt();
            next = next % heroes.size();
            if(next < 0){
                next *= -1;
            }
            heroesLabel.append(heroes.remove(next).getString() + "\n");
            heroCount++;
        }
    }
}
