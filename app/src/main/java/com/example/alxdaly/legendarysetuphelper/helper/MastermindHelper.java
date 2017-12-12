package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Mastermind;

import java.util.List;

/**
 * Grabs Mastermind for DeckHelper
 *
 * Created by alxdaly on 12/11/2017.
 */

public class MastermindHelper extends CardHelper {

    public MastermindHelper(List<Expansions> expansions, List<Mastermind> cards, Context context){
        super(expansions, cards, 1, context);
    }

    @Override
    protected Card getCardOption(){
        Masterminds mastermind = Masterminds.values()[random.nextInt(Masterminds.values().length)];
        return new Mastermind(mastermind, context);
    }
}
