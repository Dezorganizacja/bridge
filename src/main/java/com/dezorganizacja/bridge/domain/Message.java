package com.dezorganizacja.bridge.domain;

public class Message {
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}