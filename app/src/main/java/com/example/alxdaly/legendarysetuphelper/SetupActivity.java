package com.example.alxdaly.legendarysetuphelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.helper.DeckHelper;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Henchman;
import com.example.alxdaly.legendarysetuphelper.pojo.Hero;
import com.example.alxdaly.legendarysetuphelper.pojo.Mastermind;
import com.example.alxdaly.legendarysetuphelper.pojo.Scheme;
import com.example.alxdaly.legendarysetuphelper.pojo.Villain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetupActivity extends AppCompatActivity {
    private DeckHelper deckHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        Bundle extra = getIntent().getExtras();
        setup(extra.getInt("numberOfPlayers"));
        try {
            setupCards();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void setup(int numPlayers){
        TextView gameTitle = (TextView) findViewById(R.id.gameTitle);
        int numVillains = 0;
        int numHenchmen = 0;
        int numHeroes = 0;
        int numBystanders = 0;
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
        this.deckHelper = new DeckHelper(new ArrayList<Expansions>(), this, numPlayers, numVillains, numHenchmen, numHeroes, numBystanders);
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
        Scheme scheme = this.deckHelper.getScheme();
        TextView schemeLabel = (TextView) findViewById(R.id.schemeLabel);
        schemeLabel.setText(scheme.getCardTitle());
    }

    private void getBystanders() {
        TextView bystanderLabel = (TextView) findViewById(R.id.bystanderLabel);
        bystanderLabel.setText(this.deckHelper.getNumBystanders() + "");
    }

    private void getTwists() {
        TextView twistLabel = (TextView) findViewById(R.id.twistLabel);
        twistLabel.setText(this.deckHelper.getTwists() + "");
    }

    private void chooseMastermind(){
        Mastermind mastermind = this.deckHelper.getMastermind();
        TextView mastermindLabel = (TextView) findViewById(R.id.mastermindLabel);
        mastermindLabel.setText(mastermind.getCardTitle());
    }

    private void chooseVillains() {
        List<Villain> villains = this.deckHelper.getVillains();
        TextView villainLabel = (TextView) findViewById(R.id.villainLabel);
        villainLabel.setText(buildStringList(villains));
    }

    private void chooseHeroes() {
        List<Hero> heroes = this.deckHelper.getHeroes();
        TextView heroesLabel = (TextView) findViewById(R.id.heroesLabel);
        heroesLabel.setText(buildStringList(heroes));
    }

    private void chooseHenchmen() {
        List<Henchman> henchmen = this.deckHelper.getHenchmen();
        TextView henchmenLabel = (TextView) findViewById(R.id.henchmenLabel);
        henchmenLabel.setText(buildStringList(henchmen));
    }

    private void getNotes() {
        TextView notesLabel = (TextView) findViewById(R.id.notesLabel);
        notesLabel.setText(this.deckHelper.getNotes());
    }

    private String buildStringList(List<? extends Card> cards){
        String result = "";
        for(Card next: cards){
            result += next.getCardTitle() + '\n';
        }
        return result;
    }
}
