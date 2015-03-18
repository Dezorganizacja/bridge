package com.dezorganizacja.bridge.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wiktortendera on 18/03/15.
 */
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for(Card.Rank rank : Card.Rank.values()) {
           for (Card.Suit suit : Card.Suit.values()) {
               cards.add(new Card(rank, suit));
           }
        }
    }

    public int getRemainingCardsNumber() {
        return cards.size();
    }
}
