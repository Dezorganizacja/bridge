package com.dezorganizacja.bridge.model;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wiktortendera on 18/03/15.
 */
public class CardTest {
    @Test
    public void getCard() throws Exception {
        Card c = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertEquals(c.getRank(), Card.Rank.ACE);
        assertEquals(c.getSuit(), Card.Suit.SPADES);

    }
}
