package com.dezorganizacja.bridge.model;

import java.util.ArrayList;

/**
 * Created by vereena on 26.04.15.
 */
public class Bidding {
    Game game;
    Bid maxBid;
    Bid [] playersLastBid=new Bid[4];
    int currentPlayer;
    boolean biddingOn;

    public Bidding(Game game)
    {
        this.game=game;
        currentPlayer=0;
        biddingOn=true;
    }

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

    private int howManyPasses()
    {
        int counter=0;
        for(int i=0;i<4;i++)
        {
            if(playersLastBid[0].getType()==BidType.PASS)
                counter++;
        }
        return counter;
    }

    public boolean set_bid(Bid bid)
    {
        if(bid.getType()==BidType.CARD && isGreaterFromMax(bid))
        {
            maxBid=bid;
            playersLastBid[currentPlayer]=maxBid;
            currentPlayer=(currentPlayer+1)%4;
            return true;
        }
        else if(bid.getType()==BidType.CARD)
            return false;
        else if(bid.getType()==BidType.PASS)
        {
            playersLastBid[currentPlayer]=bid;
            if(howManyPasses()==3)
            {
                biddingOn=false;
            }
            return true;
        }
        else if(bid.getType()==BidType.CONTRA)
        {
            if(playersLastBid[(currentPlayer-1)%4].getType()==BidType.CARD)
            {
                playersLastBid[currentPlayer]=bid;
                return true;
            }
            else return false;
        }
        else if(bid.getType()==BidType.RECONTRA)
        {
            if(playersLastBid[(currentPlayer-1)%4].getType()==BidType.CONTRA)
            {
                playersLastBid[currentPlayer]=bid;
                return true;
            }
            else return false;
        }
        return true;
    }

    public Player getCurrentPlayer()
    {
        return game.getPlayer(currentPlayer+1);
    }

    public boolean isBiddingOn(){return this.biddingOn;}
}
