package com.dezorganizacja.bridge.view.text;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import com.dezorganizacja.bridge.view.View;

public class TextView implements View {
    public void show(MainPresenter presenter, String[] args) {
        TerminalApplication application = new TerminalApplication ();
        application.setMainPresenter(presenter);
        application.launch();
    }
}
