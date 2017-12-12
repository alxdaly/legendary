package com.example.alxdaly.legendarysetuphelper.helper;

import android.content.Context;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.pojo.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Abstract class to help choose cards to add
 *
 * Created by alxdaly on 12/10/2017.
 */

public abstract class CardHelper {
    protected List<Expansions> chosenExpansions;
    protected List<? extends Card> cards;
    protected int numCards;
    protected Random random;
    protected Context context;

    public CardHelper(List<Expansions> chosenExpansions, List<? extends Card> cards, int numCards, Context context) {
        this.chosenExpansions = chosenExpansions;
        this.cards = setCards(cards);
        this.numCards = numCards;
        this.random = new Random();
        this.context = context;
    }

    private List<Card> setCards(List<? extends Card> cards){
        return (ArrayList<Card>) cards;
    }

    public List<? extends Card> chooseCards() {
        List<Card> cardCollection = (ArrayList<Card>) cards;
        while(cards.size() < numCards){
            Card card = getCardOption();
            if(isInChosenExpansions(card) && notInCards(card)){
                cardCollection.add(card);
            }
        }
        cards = cardCollection;
        return cards;
    }

    protected Card getCardOption() {
        return null;
    }

    protected boolean isInChosenExpansions(Card card) {
        return chosenExpansions.contains(card.getExpansion()) || chosenExpansions.size() == 0;
    }

    protected boolean notInCards(Card card) {
        for(Card next: cards){
            if(card.equals(next)){
                return false;
            }
        }
        return true;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public int getNumCards() {
        return numCards;
    }

    public void incrementNumCards() {
        this.numCards++;
    }

    public List<Card> getCards() {
        return (List<Card>) this.cards;
    }

    public void addCard(Card card){
        ((List<Card>) cards).add(card);
    }
}
