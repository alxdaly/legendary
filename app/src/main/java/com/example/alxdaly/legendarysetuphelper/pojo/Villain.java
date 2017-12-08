package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.VillainGroups;

/**
 * Created by alxdaly on 1/11/2017.
 */

public class Villain implements Card{
    private VillainGroups villain;
    private Expansions expansion;

    public Villain(VillainGroups villain){
        this.villain = villain;
        this.expansion = setExpansion();
    }

    public VillainGroups getVillain() {
        return this.villain;
    }

    public Expansions getExpansion() {
        return this.expansion;
    }

    @Override
    public String getString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + villain + ",\n";
    }

    private Expansions setExpansion() {
        switch(this.villain){
            case EVIL_DEADPOOL_CORPSE:
            case DEADPOOL_FRIENDS:
                return Expansions.DEADPOOL;
            case GOBLIN_FREAK_SHOW:
            case XMEN_NOIR:
                return Expansions.NOIR;
            case MAXIUMUM_CARNAGE:
            case SINISTER_SIX:
                return Expansions.PAINT_TOWN_RED;
            default:
                return Expansions.BASE;
        }
    }
}
