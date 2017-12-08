package com.example.alxdaly.legendarysetuphelper.pojo;

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

    public Henchman(Henchmen henchmen){
        this.henchmen = henchmen;
        this.expansion = setExpansion();
    }

    public Henchmen getHenchmen() {
        return this.henchmen;
    }

    public Expansions getExpansion() {
        return this.expansion;
    }

    @Override
    public String getString() {
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
