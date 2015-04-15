package com.dezorganizacja.bridge.model;

import java.util.ArrayList;

/**
 * Created by wiktortendera on 15/04/15.
 */
public class Player {
    private String name;
    private ArrayList<Card> cards;
    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
