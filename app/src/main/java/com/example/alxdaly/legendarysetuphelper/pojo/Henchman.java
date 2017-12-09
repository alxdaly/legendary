package com.example.alxdaly.legendarysetuphelper.pojo;

import android.content.Context;
import android.content.res.Resources;

import com.example.alxdaly.legendarysetuphelper.R;
import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Henchmen;

/**
 * Holds Henchmen Information
 *
 * Created by alxdaly on 1/11/2017.
 */

public class Henchman implements Card {
    private Henchmen henchmen;
    private Expansions expansion;
    private Context context;

    public Henchman(Henchmen henchmen, Context context){
        this.henchmen = henchmen;
        this.expansion = setExpansion();
        this.context = context;
    }

    public Henchmen getHenchmen() {
        return this.henchmen;
    }

    public Expansions getExpansion() {
        return this.expansion;
    }

    @Override
    public String getCardTitle() {
        switch(this.henchmen){
            case HAND_NINJAS:
                return context.getResources().getString(R.string.HAND_NINJAS);
            case DOOMBOT_LEGION:
                return context.getResources().getString(R.string.DOOMBOT_LEGION);
            case SAVAGE_LAND_MUTATES:
                return context.getResources().getString(R.string.SAVAGE_LAND_MUTATES);
            case SENTINEL:
                return context.getResources().getString(R.string.SENTINEL);
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + henchmen + ",\n";
    }

    private Expansions setExpansion(){
        switch(this.henchmen){
            default:
                return Expansions.BASE;
        }
    }
}
