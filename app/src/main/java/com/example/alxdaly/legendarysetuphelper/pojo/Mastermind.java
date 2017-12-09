package com.example.alxdaly.legendarysetuphelper.pojo;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.R;
import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;

/**
 * Created by alxdaly on 1/11/2017.
 */

public class Mastermind implements Card {
    private Masterminds mastermind;
    private Expansions expansion;
    private Context context;

    public Mastermind(Masterminds mastermind, Context context){
        this.mastermind = mastermind;
        this.expansion = setExpansion();
        this.context = context;
    }

    public Masterminds getMastermind() {
        return this.mastermind;
    }

    public Expansions getExpansion() {
        return this.expansion;
    }

    @Override
    public String getCardTitle(){
        switch(this.mastermind){
            case RED_SKULL:
                return context.getResources().getString(R.string.RED_SKULL);
            case MAGNETO:
                return context.getResources().getString(R.string.MAGNETO);
            case LOKI:
                return context.getResources().getString(R.string.LOKI);
            case DR_DOOM:
                return context.getResources().getString(R.string.DR_DOOM);
            case EVIL_DEADPOOL:
                return context.getResources().getString(R.string.EVIL_DEADPOOL);
            case MACHO_GOMEZ:
                return context.getResources().getString(R.string.MACHO_GOMEZ);
            case CHARLES_XAVIER_PROFESSOR_CRIME:
                return context.getResources().getString(R.string.CHARLES_XAVIER_PROFESSOR_CRIME);
            case GOBLIN_UNDERWORLD_BOSS:
                return context.getResources().getString(R.string.GOBLIN_UNDERWORLD_BOSS);
            case MYSTERIO:
                return context.getResources().getString(R.string.MYSTERIO);
            case CARNAGE:
                return context.getResources().getString(R.string.CARNAGE);
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + mastermind + ",\n";
    }

    private Expansions setExpansion() {
        switch(this.mastermind){
            case EVIL_DEADPOOL:
            case MACHO_GOMEZ:
                return Expansions.DEADPOOL;
            case CHARLES_XAVIER_PROFESSOR_CRIME:
            case GOBLIN_UNDERWORLD_BOSS:
                return Expansions.NOIR;
            case MYSTERIO:
            case CARNAGE:
                return Expansions.PAINT_TOWN_RED;
            default:
                return Expansions.BASE;
        }
    }
}
