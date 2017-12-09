package com.example.alxdaly.legendarysetuphelper.pojo;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.R;
import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Schemes;

/**
 * Created by alxdaly on 12/8/2017.
 */

public class Scheme implements Card {
    private Schemes scheme;
    private Expansions expansion;
    private Context context;

    public Scheme(Schemes scheme, Context context){
        this.scheme = scheme;
        this.expansion = setExpansion();
        this.context = context;
    }

    public Schemes getScheme() {
        return this.scheme;
    }

    @Override
    public Expansions getExpansion(){
        return this.expansion;
    }

    @Override
    public String getCardTitle(){
        switch(this.scheme){
            case COSMIC_CUBE:
                return context.getResources().getString(R.string.COSMIC_CUBE);
            case DARK_DIMENSION:
                return context.getResources().getString(R.string.DARK_DIMENSION);
            case NEGATIVE_ZONE:
                return context.getResources().getString(R.string.NEGATIVE_ZONE);
            case MIDTOWN_BANK_ROBBERY:
                return context.getResources().getString(R.string.MIDTOWN_BANK_ROBBERY);
            case CIVIL_WAR:
                return context.getResources().getString(R.string.CIVIL_WAR);
            case LEGACY_VIRUS:
                return context.getResources().getString(R.string.LEGACY_VIRUS);
            case SECRET_INVASION:
                return context.getResources().getString(R.string.SECRET_INVASION);
            case KILLBOTS:
                return context.getResources().getString(R.string.KILLBOTS);
            case DEADPOOL_KILLS_MARVEL:
                return context.getResources().getString(R.string.DEADPOOL_KILLS_MARVEL);
            case DEADPOOL_WANTS_CHIMICHANGA:
                return context.getResources().getString(R.string.DEADPOOL_WANTS_CHIMICHANGA);
            case DEADPOOL_WRITES_SCHEME:
                return context.getResources().getString(R.string.DEADPOOL_WRITES_SCHEME);
            case EVERYONE_HATES_DEADPOOL:
                return context.getResources().getString(R.string.EVERYONE_HATES_DEADPOOL);
            case HIDDEN_HEART_OF_DARKNESS:
                return context.getResources().getString(R.string.HIDDEN_HEART_OF_DARKNESS);
            case FIVE_FAMILIES:
                return context.getResources().getString(R.string.FIVE_FAMILIES);
            case SILENCE_WITNESSES:
                return context.getResources().getString(R.string.SILENCE_WITNESSES);
            case SPLIT_PERSONALITY_KILLER:
                return context.getResources().getString(R.string.SPLIT_PERSONALITY_KILLER);
            case SPIDER_DNA:
                return context.getResources().getString(R.string.SPIDER_DNA);
            case CLONE_SAGA:
                return context.getResources().getString(R.string.CLONE_SAGA);
            case WEB_OF_LIES:
                return context.getResources().getString(R.string.WEB_OF_LIES);
            case DAILY_BUGLE:
                return context.getResources().getString(R.string.DAILY_BUGLE);
            default:
                return "";
        }
    }

    @Override
    public String toString(){
        return "Expansion: " + expansion + ",\n" +
                "Card: " + scheme + ",\n";
    }

    private Expansions setExpansion(){
        switch(this.scheme){
            case DEADPOOL_KILLS_MARVEL:
            case DEADPOOL_WANTS_CHIMICHANGA:
            case DEADPOOL_WRITES_SCHEME:
            case EVERYONE_HATES_DEADPOOL:
                return Expansions.DEADPOOL;
            case HIDDEN_HEART_OF_DARKNESS:
            case FIVE_FAMILIES:
            case SILENCE_WITNESSES:
            case SPLIT_PERSONALITY_KILLER:
                return Expansions.NOIR;
            case SPIDER_DNA:
            case CLONE_SAGA:
            case WEB_OF_LIES:
            case DAILY_BUGLE:
                return Expansions.PAINT_TOWN_RED;
            default:
                return Expansions.BASE;
        }
    }
}
