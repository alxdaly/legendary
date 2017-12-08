package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Henchmen;

/**
 * Holds Henchmen Information
 *
 * Created by alxdaly on 1/11/2017.
 */

public class Henchman extends Card {
    private Henchmen henchmen;

    public Henchman(Henchmen henchmen, Expansions expansion){
        super(expansion);
        this.henchmen = henchmen;
    }

    public Henchmen getHenchmen() {
        return this.henchmen;
    }

    @Override
    public String getString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + henchmen + ",\n";
    }
}
