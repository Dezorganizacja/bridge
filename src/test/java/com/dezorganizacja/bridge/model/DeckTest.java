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
}
