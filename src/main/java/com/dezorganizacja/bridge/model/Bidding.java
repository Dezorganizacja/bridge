package com.dezorganizacja.bridge.model;

public class Bidding {
    private Game game;
    private Bid maxBid;
    private Bid [] playersLastBid=new Bid[4];
    private int currentPlayer;
    private boolean biddingOn;

    //TODO - which color wins (atu, important)
    //TODO - who wins (wins a pair after whichs bid there were three passes and the winner is a player from this pair who started bidding in winning color)
    //TODO - if winers was contred/recontred
    //TODO - how many points will be gained by bidding winners if they'll win the game and how many will they lost if they'll lost a game

    public Bidding(Game game)
    {
        this.game=game;
        currentPlayer=0;
        biddingOn=true;
    }

    //returns true if bid is greater than maximum bid, if it's not returns false
    private boolean isGreaterFromMax(Bid bid)
    {
        if(maxBid==null)
            return true;
        if(bid.getCount().compareTo(maxBid.getCount())>0)
            return true;
        else if(bid.getCount().equals(maxBid.getCount()))
        {
            if(bid.getColor().compareTo(maxBid.getColor())>0)
                return true;
        }
        return false;
    }

    //counts how many players said "PASS" in a row
    private int getPassCount(int player)
    {
        int counter=1;
        if(playersLastBid[(player+1)%4]!=null && playersLastBid[(player+1)%4].getType()==BidType.PASS)
            counter++;
        if(playersLastBid[(player+2)%4]!=null && playersLastBid[(player+2)%4].getType()==BidType.PASS)
            counter++;
        return counter;
    }

    //checks if players current bid is possible,
    //if it is, it's being stored in "playersLastBid" and player is changed to next
    public boolean setBid(Bid bid)
    {
        //if players bid is not pass/contra/recontra and it's greater than maximum bid,
        //it's new maximum bid and it's next player turn
        if(bid.getType()==BidType.CARD && isGreaterFromMax(bid))
        {
            maxBid=bid;
            playersLastBid[currentPlayer]=maxBid;
            currentPlayer=(currentPlayer+1)%4;
            return true;
        }

        //if it's not pass/contra/recontra and it's NOT greater than maximum bid, then it's not a possible bid
        else if(bid.getType()==BidType.CARD)
            return false;

        //if it's pass, we have to check if the bidding ends (3 passes in a row)
        else if(bid.getType()==BidType.PASS)
        {
            playersLastBid[currentPlayer]=bid;
            if(getPassCount(currentPlayer)==3)
            {
                biddingOn=false;
            }
            return true;
        }

        //if it's contra, it's possible when:
        //-previous player bid was not pass/contra/recontra
        //-previous player bid was pass, currentPlayer partner(-2) bid wasn't contra and player(-3) bid was a card
        else if(bid.getType()==BidType.CONTRA)
        {
            if(playersLastBid[(currentPlayer-1+4)%4]==null)
                return false;
            if(playersLastBid[(currentPlayer-1+4)%4].getType()==BidType.CARD)
            {
                playersLastBid[currentPlayer]=bid;
                return true;
            }
            else return false;
        }

        //if it's recontra, it's possible when:
        //-previous player bid was contra
        //-previous player bid wasn't contra, currentPlayer partner(-2) bid wasn't recontra and player(-3) bid was contra
        else if(bid.getType()==BidType.RECONTRA)
        {
            if(playersLastBid[(currentPlayer-1+4)%4].getType()==BidType.CONTRA)
            {
                playersLastBid[currentPlayer]=bid;
                return true;
            }
            else return false;
        }
        return true;
    }

    //returns current player (+1, because in bidding they indexes are 0,1,2,3 and in game 1,2,3,4)
    public Player getCurrentPlayer()
    {
        return game.getPlayer(currentPlayer+1);
    }

    //informs if the bidding is on (there weren't 3 passes in a row)
    public boolean isBiddingOn(){return this.biddingOn;}
}
