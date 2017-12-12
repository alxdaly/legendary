package com.example.alxdaly.legendarysetuphelper.pojo;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;

/**
 * Interface for all cards to use
 *
 * Created by alxdaly on 1/11/2017.
 */

public interface Card {
    String getCardTitle();
    Expansions getExpansion();
    String toString();
}
