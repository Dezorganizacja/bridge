package com.dezorganizacja.bridge.view.text;

import com.dezorganizacja.bridge.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by maciek on 13.04.15.
 */
public class TerminalApplication implements Observer {
    private static MainPresenter mainPresenter;
    private OrdersHandler handler = new OrdersHandler ();
    private String state;

    public static void setMainPresenter(MainPresenter mainPresenter) {
        TerminalApplication.mainPresenter = mainPresenter;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void launch () {
        TerminalApplication.mainPresenter.addObserver(this);
        this.showWelcome();
        this.setState("loading");
        this.startHandling ();
    }

    public void update(Observable observable, Object o) {
        this.changeState();
    }

    public void startHandling () {
        Scanner input = new Scanner(System.in);
        handler.dispatchOrder("menu", new ArrayList<>());
        while(input.hasNextLine()) {
            List<String> args = parse(input.nextLine());
            handler.dispatchOrder(args.get(0), args);
        }
    }
    
    private List<String> parse(String line) {
        String[] words = line.split(" ");
        List<String> args = new ArrayList<>();
        for(String tmp : words) args.add(tmp);
        return args;
    }

    private void showWelcome () {
        System.out.println("Welcome to bridge !");
        System.out.println("Type \"start\" to start the game.");
        System.out.println("Type \"end\" any time if you want to quit the game.");
    }

    public void changeState () {
        String programState = mainPresenter.getState();
        this.state = programState;
    }
}
