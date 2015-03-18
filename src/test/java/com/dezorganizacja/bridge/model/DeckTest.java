package com.dezorganizacja.bridge.model;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by wiktortendera on 18/03/15.
 */
public class DeckTest {
    @Test
    public void getDeck() {
        Deck d = new Deck();
        assertEquals(d.getRemainingCardsNumber(), 52);
    }

    @Test
    public void topCard() {
        Deck deck = new Deck();
        Card top = deck.getTopCard();
        Card card = new Card(Card.Rank.TWO, Card.Suit.SPADES);
        assertNotNull(top);
        assertEquals(top, card);
    }

    @Test
    public void decrementsRemainingCards() {
        Deck deck = new Deck();
        int newVal, oldVal = deck.getRemainingCardsNumber();
        assertEquals(oldVal, 52);

        while(deck.getRemainingCardsNumber() > 0) {
            deck.getTopCard();
            newVal = deck.getRemainingCardsNumber();
            assertEquals(oldVal - newVal, 1);
            oldVal = newVal;
        }
    }

    @Test
    public void emptyDeck() {
        Deck deck = new Deck();
        Card top = null;
        while(deck.getRemainingCardsNumber() > 0) {
            top = deck.getTopCard();
        }
        top = deck.getTopCard();
        assertNull(top);
    }


}
