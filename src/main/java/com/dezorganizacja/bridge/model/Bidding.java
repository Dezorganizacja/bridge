package com.dezorganizacja.bridge.model;

public class Bidding {
    private Game game;
    private Bid maxBid;
    private Bid[] playersLastBid = new Bid[4];
    private int currentPlayer;
    private boolean biddingOn;

    //these 4 are for checking who in pair is a winner, which color is atu and whether this bid was contred/recontred
    // (important for counting points for win/lose)
    private int[] winner = new int[2];
    private Bid[] lastPairBid = new Bid[2];
    private boolean[] lastPairBidContred = new boolean[2];
    private boolean[] lastPairBidRecontred = new boolean[2];
    
    //TODO - how many points will be gained by bidding winners if they'll win the game and how many will they lost if they'll lost a game

    public Bidding(Game game) {
        this.game = game;
        currentPlayer = 0;
        biddingOn = true;

        winner[0] = 0;
        winner[1] = 1;
        lastPairBidContred[0] = false;
        lastPairBidContred[1] = false;
        lastPairBidRecontred[0] = false;
        lastPairBidRecontred[1] = false;
    }

    //returns true if bid is greater than maximum bid, if it's not returns false
    private boolean isGreaterFromMax(Bid bid) {
        if (maxBid == null)
            return true;
        if (bid.getCount().compareTo(maxBid.getCount()) > 0)
            return true;
        else if (bid.getCount().equals(maxBid.getCount())) {
            if (bid.getColor().compareTo(maxBid.getColor()) > 0)
                return true;
        }
        return false;
    }

    //counts how many players said "PASS" in a row
    private int getPassCount(int player) {
        int counter = 1;
        if (playersLastBid[(player + 1) % 4] != null && playersLastBid[(player + 1) % 4].getType() == BidType.PASS)
            counter++;
        if (playersLastBid[(player + 2) % 4] != null && playersLastBid[(player + 2) % 4].getType() == BidType.PASS)
            counter++;
        return counter;
    }

    //checks if players current bid is possible,
    //if it is, it's being stored in "playersLastBid" and player is changed to next
    public boolean setBid(Bid bid) {
        //if players bid is not pass/contra/recontra and it's greater than maximum bid,
        //it's new maximum bid and it's next player turn
        if (bid.getType() == BidType.CARD && isGreaterFromMax(bid)) {
            //if color changed or this is the first color - currentPlayer is gonna play, when they win the bidding
            if (lastPairBid[currentPlayer % 2] == null || lastPairBid[currentPlayer % 2].getColor() != bid.getColor()) {
                winner[currentPlayer % 2] = currentPlayer;
                lastPairBid[currentPlayer % 2] = bid;
                lastPairBidContred[currentPlayer % 2] = false;
                lastPairBidRecontred[currentPlayer % 2] = false;
            }
            //if they continue bidding the same color - previous contra and recontra are disabled, winner is not being changed
            else {
                lastPairBid[currentPlayer % 2] = bid;
                lastPairBidContred[currentPlayer % 2] = false;
                lastPairBidRecontred[currentPlayer % 2] = false;
            }
            maxBid = bid;
            playersLastBid[currentPlayer] = maxBid;
            currentPlayer = (currentPlayer + 1) % 4;
            return true;
        }

        //if it's not pass/contra/recontra and it's NOT greater than maximum bid, then it's not a possible bid
        else if (bid.getType() == BidType.CARD)
            return false;

            //if it's pass, we have to check if the bidding ends (3 passes in a row)
        else if (bid.getType() == BidType.PASS) {
            playersLastBid[currentPlayer] = bid;
            if (getPassCount(currentPlayer) == 3) {
                biddingOn = false;
                currentPlayer--;
            }
            currentPlayer = (currentPlayer + 1) % 4;
            return true;
        }

        //if it's contra, it's possible when:
        //-previous player bid was not pass/contra/recontra
        //-previous player bid partner (-3) bid was not pass/contra/recontra and current player partner (-2) bid wasn't contra
        else if (bid.getType() == BidType.CONTRA) {
            //first possibility
            if (playersLastBid[(currentPlayer - 1 + 4) % 4] == null)
                return false;
            if (playersLastBid[(currentPlayer - 1 + 4) % 4].getType() == BidType.CARD) {
                //other pair bid is contred
                lastPairBidContred[(currentPlayer + 1) % 2] = true;
                playersLastBid[currentPlayer] = bid;
                currentPlayer = (currentPlayer + 1) % 4;
                return true;
            }

            //second possibility
            if (playersLastBid[(currentPlayer - 2 + 4) % 4] == null || playersLastBid[(currentPlayer - 3 + 4) % 4] == null)
                return false;
            if (playersLastBid[(currentPlayer - 3 + 4) % 4].getType() == BidType.CARD && playersLastBid[(currentPlayer - 2 + 4) % 4].getType() != BidType.CONTRA) {
                //other pair bid is contred
                lastPairBidContred[(currentPlayer + 1) % 2] = true;
                playersLastBid[currentPlayer] = bid;
                currentPlayer = (currentPlayer + 1) % 4;
                return true;
            }
            //else wrong "contra"
            else return false;
        }

        //if it's recontra, it's possible when:
        //-previous player bid was contra
        //-previous player partner(-3) bid was contra and current player partner (-2) bid wasn't recontra
        else if (bid.getType() == BidType.RECONTRA) {
            //first possibility
            if (playersLastBid[(currentPlayer - 1 + 4) % 4] == null)
                return false;
            if (playersLastBid[(currentPlayer - 1 + 4) % 4].getType() == BidType.CONTRA) {
                //this pair bid is recontred
                lastPairBidRecontred[currentPlayer % 2] = true;
                playersLastBid[currentPlayer] = bid;
                currentPlayer = (currentPlayer + 1) % 4;
                return true;
            }

            //second possibility
            if (playersLastBid[(currentPlayer - 2 + 4) % 4] == null || playersLastBid[(currentPlayer - 3 + 4) % 4] == null)
                return false;
            if (playersLastBid[(currentPlayer - 3 + 4) % 4].getType() == BidType.CONTRA && playersLastBid[(currentPlayer - 2 + 4) % 4].getType() != BidType.RECONTRA) {
                //this pair bid is recontred
                lastPairBidRecontred[currentPlayer % 2] = true;
                playersLastBid[currentPlayer] = bid;
                currentPlayer = (currentPlayer + 1) % 4;
                return true;
            }
            //else wrong "contra"
            else return false;
        }
        return true;
    }

    //returns current player (+1, because in bidding they indexes are 0,1,2,3 and in game 1,2,3,4)
    public Player getCurrentPlayer() {
        return game.getPlayer(currentPlayer + 1);
    }

    //informs if the bidding is on (there weren't 3 passes in a row)
    public boolean isBiddingOn() {
        return this.biddingOn;
    }

    //returns which player will be the playing one in this game
    public Player returnBiddingWinner()
    {
        if(isBiddingOn())
        {
            return null;
        }
        if(lastPairBid[0]==maxBid)
        {
            return game.getPlayer(winner[0] + 1);
        }
        return game.getPlayer(winner[1] + 1);
    }

    //returns how many turns bidding winners must win and which color is atu
    public Bid returnWinnerBid()
    {
        if(isBiddingOn())
        {
            return null;
        }
        return maxBid;
    }

    //if the winner of bidding is contred
    public boolean isWinnerIsContred()
    {
        if(isBiddingOn())
        {
            return false;
        }
        if(lastPairBid[0]==maxBid)
        {
            return lastPairBidContred[0];
        }
        return lastPairBidContred[1];
    }

    //if the winner of bidding recontred
    public boolean isWinnerIsRecontred()
    {
        if(isBiddingOn())
        {
            return false;
        }
        if(lastPairBid[0]==maxBid)
        {
            return lastPairBidRecontred[0];
        }
        return lastPairBidRecontred[1];
    }
}
