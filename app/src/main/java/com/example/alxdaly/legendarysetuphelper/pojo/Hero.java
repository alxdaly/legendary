package com.example.alxdaly.legendarysetuphelper.pojo;

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

    public Hero(Heroes hero){
        this.hero = hero;
        this.expansion = setExpansion();
        this.teamIcon = setTeamIcon();
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
    public String getString() {
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
