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
}
