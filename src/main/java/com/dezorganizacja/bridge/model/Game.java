package com.dezorganizacja.bridge.model;

import java.util.ArrayList;

/**
 * Created by wiktortendera on 15/04/15.
 */
public class Game {
    ArrayList<Player> players;
    private Deck deck;
    public Game(Player player1, Player player2, Player player3, Player player4) {
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    public Player getPlayer(int index) {
        if(index > 4 || index <=0)
            return null;
        return players.get(--index);
    }

    public void start() {
        deck = new Deck();
        deck.shuffleDeck();
        for(Player p : players) {
            deck.giveCardsToPlayer(p);
        }
    }
}
