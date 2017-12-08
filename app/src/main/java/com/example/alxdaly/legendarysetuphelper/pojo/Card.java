package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;

/**
 * Base for all cards
 *
 * Created by alxdaly on 1/11/2017.
 */

public class Card {
    Expansions expansion;

    public Card(Expansions expansion){
        this.expansion = expansion;
    }

    public Expansions getExpansion() {
        return expansion;
    }

    public String getString() {
        String result = "Expansion: " + expansion;
        return result;
    }
}
