package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Schemes;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Scheme;

import java.util.List;

/**
 * Created by alxdaly on 12/11/2017.
 */

public class SchemeHelper extends CardHelper {

    public SchemeHelper(List<Expansions> expansions, List<Scheme> cards, Context context){
        super(expansions, cards, 1, context);
    }

    @Override
    protected Card getCardOption() {
        Schemes scheme = Schemes.values()[random.nextInt(Schemes.values().length)];
        return new Scheme(scheme, context);
    }
}
