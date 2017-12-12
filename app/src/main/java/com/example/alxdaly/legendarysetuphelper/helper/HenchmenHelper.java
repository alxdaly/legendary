package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Henchmen;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Henchman;

import java.util.List;

/**
 * Created by alxdaly on 12/10/2017.
 */

public class HenchmenHelper extends CardHelper {

    public HenchmenHelper(List<Expansions> chosenExpansions, List<Henchman> cards, int numCards, Context context) {
        super(chosenExpansions, cards, numCards, context);
    }

    @Override
    protected Card getCardOption() {
        Henchmen henchmen = Henchmen.values()[random.nextInt(Henchmen.values().length)];
        return new Henchman(henchmen, context);
    }
}
