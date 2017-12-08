package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.VillainGroups;

/**
 * Created by alxdaly on 1/11/2017.
 */

public class Villain extends Card{
    private VillainGroups villain;

    public Villain(VillainGroups villain, Expansions expansion){
        super(expansion);
        this.villain = villain;
    }

    public VillainGroups getVillain() {
        return this.villain;
    }

    @Override
    public String getString() {
        return "Expansion: " + expansion + ",\n" +
                "Card: " + villain + ",\n";
    }
}
