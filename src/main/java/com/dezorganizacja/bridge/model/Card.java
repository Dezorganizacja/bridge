package com.dezorganizacja.bridge.model;

/**
 * Created by wiktortendera on 18/03/15.
 */
public class Card {
    public static enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, JACK, QUEEN, KING, ACE
    }
    public static enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS
    }

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
