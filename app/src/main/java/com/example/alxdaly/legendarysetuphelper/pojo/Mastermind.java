package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;

/**
 * Created by alxdaly on 1/11/2017.
 */

public class Mastermind extends Card {
    private Masterminds mastermind;

    public Mastermind(Masterminds mastermind, Expansions expansion){
        super(expansion);
        this.mastermind = mastermind;
    }

    public Masterminds getMastermind() {
        return mastermind;
    }

    @Override
    public String getString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + mastermind + ",\n";
    }
}
