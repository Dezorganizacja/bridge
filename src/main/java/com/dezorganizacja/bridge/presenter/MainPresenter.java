package com.dezorganizacja.bridge.presenter;

import com.dezorganizacja.bridge.domain.Message;

import java.util.Observable;

public class MainPresenter extends Observable {
    private final Message message;
    private String state;

    public MainPresenter(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }
}
