package com.dezorganizacja.bridge.presenter;

import com.dezorganizacja.bridge.domain.Message;

public class GamePresenter {
    private final Message message;

    public GamePresenter(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }
}
