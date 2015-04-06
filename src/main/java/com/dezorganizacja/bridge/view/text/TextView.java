package com.dezorganizacja.bridge.view.text;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import com.dezorganizacja.bridge.view.View;

public class TextView implements View {
    public void show(MainPresenter presenter, String[] args) {
        System.out.println("Hello world!");
    }
}
