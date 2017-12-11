package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.VillainGroups;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Villain;

import java.util.List;

/**
 * Created by alxdaly on 12/11/2017.
 */

public class VillainHelper extends CardHelper {

    public VillainHelper(List<Expansions> expansions, List<Villain> cards, int numCards, Context context){
        super(expansions, cards, numCards, context);
    }

    @Override
    protected Card getCardOption() {
        VillainGroups villainGroups = VillainGroups.values()[random.nextInt(VillainGroups.values().length)];
        return new Villain(villainGroups, context);
    }
}
