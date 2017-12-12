package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Heroes;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Hero;

import java.util.List;

/**
 * Grab Heroes for DeckHelper
 *
 * Created by alxdaly on 12/10/2017.
 */

public class HeroHelper extends CardHelper {

    public HeroHelper(List<Expansions> chosenExpansions, List<Hero> cards, int numCards, Context context){
        super(chosenExpansions, cards, numCards, context);
    }

    @Override
    protected Card getCardOption() {
        Heroes hero = Heroes.values()[random.nextInt(Heroes.values().length)];
        return new Hero(hero, context);
    }
}
