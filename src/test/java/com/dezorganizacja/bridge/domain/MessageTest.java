package com.dezorganizacja.bridge.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {
    @Test
    public void testGetText() throws Exception {
        String text = "asdasd";
        Message message = new Message(text);
        assertEquals("getText returned wrong string", text, message.getText());
    }
}