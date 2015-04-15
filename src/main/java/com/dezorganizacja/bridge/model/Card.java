package com.dezorganizacja.bridge.model;

/**
 * Created by wiktortendera on 18/03/15.
 */
public class Card implements Comparable<Card>{


    public static enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    }
    public static enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS;
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

    @Override
    public boolean equals(Object o) {
        if( !(o instanceof Card)) {
            return false;
        }
        return this.compareTo((Card)o) == 0;
    }

    @Override
    public int compareTo(Card o) {
        if(this.getRank().compareTo(o.getRank()) != 0) {
            return this.getRank().compareTo(o.getRank());
        }
        return this.getSuit().compareTo(o.getSuit());
    }

    @Override
    public int hashCode() {
        return getRank().hashCode() * 67 + getSuit().hashCode();
    }


}
