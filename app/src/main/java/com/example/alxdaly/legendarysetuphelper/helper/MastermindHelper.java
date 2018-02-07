package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.R;
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
    private String mastermind;

    public MastermindHelper(List<Expansions> expansions, List<Mastermind> cards, Context context, String mastermind){
        super(expansions, cards, 1, context);
        this.mastermind = mastermind;
    }

    @Override
    protected Card getCardOption(){
        Masterminds masterminds;
        if(mastermind.equals(context.getResources().getString(R.string.random))){
            masterminds = Masterminds.values()[random.nextInt(Masterminds.values().length)];
        }
        else {
            masterminds = Masterminds.valueOf(mastermind);
        }
        return new Mastermind(masterminds, context);
    }
}
