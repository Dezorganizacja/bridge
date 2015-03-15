package com.dezorganizacja.bridge.presenter;

import com.dezorganizacja.bridge.domain.Message;

import java.util.Observable;

public class MainPresenter extends Observable {
    private final Message message;
    private String stage;

    public MainPresenter(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
