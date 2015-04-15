package com.dezorganizacja.bridge.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by wiktortendera on 15/04/15.
 */
public class PlayerTest {

    @Test
    public void getName() {
        Player p = new Player("Maniek");
        assertEquals(p.getName(), "Maniek");
    }

    @Test
    public void addCard() {
        Player p = new Player("Maniek");
        p.addCard(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        assertEquals(p.getCards().get(0).getRank(), Card.Rank.ACE);
    }
}
