package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;

/**
 * Created by alxdaly on 1/11/2017.
 */

public class Mastermind implements Card {
    private Masterminds mastermind;
    private Expansions expansion;

    public Mastermind(Masterminds mastermind){
        this.mastermind = mastermind;
        this.expansion = setExpansion();
    }

    public Masterminds getMastermind() {
        return this.mastermind;
    }

    public Expansions getExpansion() {
        return this.expansion;
    }

    @Override
    public String getString() {
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
