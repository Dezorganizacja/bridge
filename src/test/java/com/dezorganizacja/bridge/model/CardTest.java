package com.dezorganizacja.bridge.model;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wiktortendera on 18/03/15.
 */
public class CardTest {

    @Test
    public void getCard() {
        Card c = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertEquals(c.getRank(), Card.Rank.ACE);
        assertEquals(c.getSuit(), Card.Suit.SPADES);
    }

    @Test
    public void cardsEquality() {
        Card c1 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        Card c2 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        assertTrue(c1.equals(c2));
        assertTrue(c2.equals(c1));
    }

    @Test
    public void cardsInequality() {
        Card c1 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        Card c2 = new Card(Card.Rank.JACK, Card.Suit.DIAMONDS);
        Card c3 = new Card(Card.Rank.TEN, Card.Suit.CLUBS);
        assertFalse(c1.equals(c2));
        assertFalse(c2.equals(c3));
    }

    @Test
    public void cardsCompare() {
        Card c1 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        Card c2 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        Card c3 = new Card(Card.Rank.TEN, Card.Suit.CLUBS);
        assertTrue(c1.compareTo(c2) == 0);
        assertTrue(c2.compareTo(c3) < 0);
        assertTrue(c3.compareTo(c1) > 0);
    }

    @Test
    public void getHash() {
        Card c1 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        Card c2 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
