package com.dezorganizacja.bridge.model;

/**
 * Created by wiktortendera on 15/04/15.
 */
public class Game {
    private Player player1, player2, player3, player4;
    private Deck deck;
    public Game(Player player1, Player player2, Player player3, Player player4) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
    }

    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }
    public Player getPlayer3() { return player3; }
    public Player getPlayer4() { return player4; }

    public void start() {
        deck = new Deck();
        deck.shuffleDeck();
        deck.giveCardsToPlayer(player1);
        deck.giveCardsToPlayer(player2);
        deck.giveCardsToPlayer(player3);
        deck.giveCardsToPlayer(player4);
    }
}
