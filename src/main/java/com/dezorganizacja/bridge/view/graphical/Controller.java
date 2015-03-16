package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;

public class Controller {
    protected MainPresenter presenter;

    public void init(MainPresenter presenter) {
        this.presenter = presenter;
    }
}
