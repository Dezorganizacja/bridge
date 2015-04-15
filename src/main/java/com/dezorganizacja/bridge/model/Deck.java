package com.dezorganizacja.bridge.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wiktortendera on 18/03/15.
 */
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
        for(Card.Rank rank : Card.Rank.values()) {
           for (Card.Suit suit : Card.Suit.values()) {
               cards.add(new Card(rank, suit));
           }
        }
    }

    public int getRemainingCardsNumber() {
        return cards.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card getTopCard() {
        if(getRemainingCardsNumber() == 0)
            return null;

        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public void giveCardsToPlayer(Player p) {
        for(int i = 0; i < 13; i++)
            p.addCard(getTopCard());
    }
}
