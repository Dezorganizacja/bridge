package com.dezorganizacja.bridge.view.text;

import com.dezorganizacja.bridge.presenter.MainPresenter;

import java.util.*;

/**
 * Created by maciek on 13.04.15.
 */
public class TerminalApplication implements Observer {
    private MainPresenter mainPresenter;
    private OrdersHandler handler = new OrdersHandler ();
    private String state;

    public void setMainPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    public void launch () {
        mainPresenter.addObserver(this);
        System.out.println("Welcome to bridge !");
        this.startHandling ();
    }

    public void update(Observable observable, Object o) {
        this.changeState();
    }

    public void startHandling () {
        Scanner input = new Scanner(System.in);
        System.out.println("Available commands:");
        handler.dispatchOrder("menu", new ArrayList<>());
        while(input.hasNextLine()) {
            List<String> args = parse(input.nextLine());
            handler.dispatchOrder(args.get(0), args);
        }
    }
    
    private static List<String> parse(String line) {
        String[] words = line.split("\\s+");
        return Arrays.asList(words);
    }

    private void changeState () {
        String programState = mainPresenter.getState();
        this.state = programState;
    }
}
