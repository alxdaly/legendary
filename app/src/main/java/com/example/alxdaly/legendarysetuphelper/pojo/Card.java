package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;

/**
 * Base for all cards
 *
 * Created by alxdaly on 1/11/2017.
 */

public interface Card {
    Expansions getExpansion();
    String getString();
}
