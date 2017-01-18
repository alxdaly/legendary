package com.example.alxdaly.legendarysetuphelper;

/**
 * Created by alxdaly on 1/11/2017.
 */

public class Card {
    String name;
    Expansion expansion;

    public Card(String name, int expansion){
        this.name = name;
        switch(expansion){
            case 1:
                this.expansion = Expansion.deadpool;
                break;
            case 2:
                this.expansion = Expansion.paintthetown;
                break;
            default:
                this.expansion = Expansion.base;
        }
    }

    public String getName() {
        return name;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public String getString() {
        String result = name + " ";
        switch(expansion){
            case deadpool:
                result += "(Dp)";
                break;
            case paintthetown:
                result += "(Red)";
                break;
            default:
        }
        return result;
    }
}
