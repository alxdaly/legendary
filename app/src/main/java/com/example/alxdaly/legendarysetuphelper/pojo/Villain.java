package com.example.alxdaly.legendarysetuphelper.pojo;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.R;
import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.VillainGroups;

/**
 * Card that holds Villain info
 *
 * Created by alxdaly on 1/11/2017.
 */

public class Villain implements Card{
    private VillainGroups villain;
    private Expansions expansion;
    private Context context;

    public Villain(VillainGroups villain, Context context){
        this.villain = villain;
        this.expansion = setExpansion();
        this.context = context;
    }

    public VillainGroups getVillain() {
        return this.villain;
    }

    public Expansions getExpansion() {
        return this.expansion;
    }

    @Override
    public String getCardTitle() {
        switch(this.villain){
            case HYDRA:
                return context.getResources().getString(R.string.HYDRA);
            case SKRULLS:
                return context.getResources().getString(R.string.SKRULLS);
            case SPIDER_FOES:
                return context.getResources().getString(R.string.SPIDER_FOES);
            case ENEMIES_OF_ASGARD:
                return context.getResources().getString(R.string.ENEMIES_OF_ASGARD);
            case BROTHERHOOD:
                return context.getResources().getString(R.string.BROTHERHOOD);
            case RADIATION:
                return context.getResources().getString(R.string.RADIATION);
            case MASTERS_OF_EVIL:
                return context.getResources().getString(R.string.MASTERS_OF_EVIL);
            case EVIL_DEADPOOL_CORPSE:
                return context.getResources().getString(R.string.EVIL_DEADPOOL_CORPSE);
            case DEADPOOL_FRIENDS:
                return context.getResources().getString(R.string.DEADPOOL_FRIENDS);
            case GOBLIN_FREAK_SHOW:
                return context.getResources().getString(R.string.GOBLIN_FREAK_SHOW);
            case XMEN_NOIR:
                return context.getResources().getString(R.string.XMEN_NOIR);
            case MAXIUMUM_CARNAGE:
                return context.getResources().getString(R.string.MAXIUMUM_CARNAGE);
            case SINISTER_SIX:
                return context.getResources().getString(R.string.SINISTER_SIX);
            default:
                return "";
        }
    }

    @Override
    public String toString() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Villain villain1 = (Villain) o;

        if (villain != villain1.villain) return false;
        return expansion == villain1.expansion;
    }

    @Override
    public int hashCode() {
        int result = villain != null ? villain.hashCode() : 0;
        result = 31 * result + (expansion != null ? expansion.hashCode() : 0);
        return result;
    }
}
