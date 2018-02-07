package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.R;
import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Schemes;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;
import com.example.alxdaly.legendarysetuphelper.pojo.Scheme;

import java.util.List;

/**
 * Grabs Scheme for DeckHelper
 *
 * Created by alxdaly on 12/11/2017.
 */

public class SchemeHelper extends CardHelper {
    private String scheme;

    public SchemeHelper(List<Expansions> expansions, List<Scheme> cards, Context context, String scheme){
        super(expansions, cards, 1, context);
        this.scheme = scheme;
    }

    @Override
    protected Card getCardOption() {
        Schemes schemes;
        if(scheme.equals(context.getResources().getString(R.string.random))) {
            schemes = Schemes.values()[random.nextInt(Schemes.values().length)];
        }
        else {
            schemes = Schemes.valueOf(scheme);
        }
        return new Scheme(schemes, context);
    }
}
