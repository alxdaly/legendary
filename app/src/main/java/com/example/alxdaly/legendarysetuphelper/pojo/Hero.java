package com.example.alxdaly.legendarysetuphelper.pojo;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.R;
import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Heroes;
import com.example.alxdaly.legendarysetuphelper.enums.TeamIcons;

/**
 * Holds Hero Information
 *
 * Created by alxdaly on 1/11/2017.
 */

public class Hero implements Card{
    private Heroes hero;
    private Expansions expansion;
    private TeamIcons teamIcon;
    private Context context;

    public Hero(Heroes hero, Context context){
        this.hero = hero;
        this.expansion = setExpansion();
        this.teamIcon = setTeamIcon();
        this.context = context;
    }

    public Heroes getHero() {
        return this.hero;
    }

    public TeamIcons getTeamIcon() {
        return this.teamIcon;
    }

    @Override
    public Expansions getExpansion(){
        return this.expansion;
    }


    @Override
    public String getCardTitle(){
        switch(this.hero){
            case BLACK_WIDOW:
                return context.getResources().getString(R.string.BLACK_WIDOW);
            case CAPT_AMERICA:
                return context.getResources().getString(R.string.CAPT_AMERICA);
            case IRON_MAN:
                return context.getResources().getString(R.string.IRON_MAN);
            case HULK:
                return context.getResources().getString(R.string.HULK);
            case HAWKEYE:
                return context.getResources().getString(R.string.HAWKEYE);
            case THOR:
                return context.getResources().getString(R.string.THOR);
            case STORM:
                return context.getResources().getString(R.string.STORM);
            case WOLVERINE:
                return context.getResources().getString(R.string.WOLVERINE);
            case CYCLOPS:
                return context.getResources().getString(R.string.CYCLOPS);
            case ROGUE:
                return context.getResources().getString(R.string.ROGUE);
            case EMMA_FROST:
                return context.getResources().getString(R.string.EMMA_FROST);
            case GAMBIT:
                return context.getResources().getString(R.string.GAMBIT);
            case SPIDER_MAN:
                return context.getResources().getString(R.string.SPIDER_MAN);
            case NICK_FURY:
                return context.getResources().getString(R.string.NICK_FURY);
            case DEADPOOL_BASE:
                return context.getResources().getString(R.string.DEADPOOL_BASE);
            case DEADPOOL_DEADPOOL:
                return context.getResources().getString(R.string.DEADPOOL_DEADPOOL);
            case SOLO:
                return context.getResources().getString(R.string.SOLO);
            case SLAPSTICK:
                return context.getResources().getString(R.string.SLAPSTICK);
            case BOB:
                return context.getResources().getString(R.string.BOB);
            case STINGRAY:
                return context.getResources().getString(R.string.STINGRAY);
            case ANGEL_NOIR:
                return context.getResources().getString(R.string.ANGEL_NOIR);
            case DAREDEVIL_NOIR:
                return context.getResources().getString(R.string.DAREDEVIL_NOIR);
            case IRON_MAN_NOIR:
                return context.getResources().getString(R.string.IRON_MAN_NOIR);
            case LUKE_CAGE_NOIR:
                return context.getResources().getString(R.string.LUKE_CAGE_NOIR);
            case SPIDER_MAN_NOIR:
                return context.getResources().getString(R.string.SPIDER_MAN_NOIR);
            case SPIDER_WOMAN:
                return context.getResources().getString(R.string.SPIDER_WOMAN);
            case MOON_KNIGHT:
                return context.getResources().getString(R.string.MOON_KNIGHT);
            case BLACK_CAT:
                return context.getResources().getString(R.string.BLACK_CAT);
            case SYMBIOTE_SPIDER_MAN:
                return context.getResources().getString(R.string.SYMBIOTE_SPIDER_MAN);
            case SCARLET_SPIDER:
                return context.getResources().getString(R.string.SCARLET_SPIDER);
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + hero + ",\n" +
                "TeamIcon: " + teamIcon + "\n";
    }

    private Expansions setExpansion(){
        switch(this.hero){
            case DEADPOOL_DEADPOOL:
            case SOLO:
            case SLAPSTICK:
            case BOB:
            case STINGRAY:
                return Expansions.DEADPOOL;
            case ANGEL_NOIR:
            case DAREDEVIL_NOIR:
            case IRON_MAN_NOIR:
            case LUKE_CAGE_NOIR:
            case SPIDER_MAN_NOIR:
                return Expansions.NOIR;
            case SPIDER_WOMAN:
            case MOON_KNIGHT:
            case BLACK_CAT:
            case SYMBIOTE_SPIDER_MAN:
            case SCARLET_SPIDER:
                return Expansions.PAINT_TOWN_RED;
            default:
                return Expansions.BASE;
        }
    }

    public TeamIcons setTeamIcon(){
        switch(this.hero){
            case BLACK_WIDOW:
            case CAPT_AMERICA:
            case IRON_MAN:
            case HULK:
            case HAWKEYE:
            case THOR:
            case IRON_MAN_NOIR:
                return TeamIcons.AVENGERS;
            case STORM:
            case WOLVERINE:
            case CYCLOPS:
            case ROGUE:
            case EMMA_FROST:
            case GAMBIT:
            case ANGEL_NOIR:
                return TeamIcons.XMEN;
            case SPIDER_MAN:
            case SPIDER_MAN_NOIR:
            case SPIDER_WOMAN:
            case BLACK_CAT:
            case SYMBIOTE_SPIDER_MAN:
            case SCARLET_SPIDER:
                return TeamIcons.SPIDER_FRIENDS;
            case NICK_FURY:
                return TeamIcons.SHIELD;
            case DEADPOOL_DEADPOOL:
            case SOLO:
            case SLAPSTICK:
            case STINGRAY:
                return TeamIcons.MERCS_FOR_MONEY;
            case BOB:
                return TeamIcons.HYDRA;
            case DAREDEVIL_NOIR:
            case LUKE_CAGE_NOIR:
            case MOON_KNIGHT:
                return TeamIcons.MARVEL_KNIGHTS;
            default:
                return TeamIcons.NONE;
        }
    }
}
