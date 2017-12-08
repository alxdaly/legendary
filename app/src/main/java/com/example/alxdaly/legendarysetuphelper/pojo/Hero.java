package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Heroes;
import com.example.alxdaly.legendarysetuphelper.enums.TeamIcons;

/**
 * Holds Hero Information
 *
 * Created by alxdaly on 1/11/2017.
 */

public class Hero extends Card{
    private Heroes hero;
    private TeamIcons teamIcon;

    public Hero(Heroes hero, Expansions expansion, TeamIcons teamIcon){
        super(expansion);
        this.hero = hero;
        this.teamIcon = teamIcon;
    }

    public Heroes getHero() {
        return this.hero;
    }

    public TeamIcons getTeamIcon() {
        return this.teamIcon;
    }

    @Override
    public String getString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + hero + ",\n" +
                "TeamIcon: " + teamIcon + "\n";
    }
}
