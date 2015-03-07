package com.dezorganizacja.bridge.presenter;

import com.dezorganizacja.bridge.domain.Message;

public class MainPresenter {
    private final Message message;

    public MainPresenter(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }
}
