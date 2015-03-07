package com.dezorganizacja.bridge.presenter;

import com.dezorganizacja.bridge.domain.Message;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainPresenterTest {
    @Test
    public void testGetMessage() throws Exception {
        Message message = new Message("text");
        MainPresenter mainPresenter = new MainPresenter(message);
        assertEquals("getMessage returned wrong message", message, mainPresenter.getMessage());
    }
}