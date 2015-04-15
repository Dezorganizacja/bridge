package com.dezorganizacja.bridge.model;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by wiktortendera on 15/04/15.
 */
public class GameTest {
    @Test
    public void startGame() {
        Player p1 = new Player("Maniek"), p2 = new Player("Janek"),
                p3 = new Player("Wacek"), p4 = new Player("Klocek");
        Game g = new Game(p1, p2, p3, p4);
        assertEquals(g.getPlayer1(), p1);
        assertEquals(g.getPlayer4(), p4);
        g.start();
        assertEquals(g.getPlayer4().getCards().size(), 13);
        assertEquals(g.getPlayer2().getCards().size(), 13);
    }
}
