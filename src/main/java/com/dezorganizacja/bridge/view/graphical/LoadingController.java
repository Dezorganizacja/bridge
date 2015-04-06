package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;

public class LoadingController implements Controller {
    private MainPresenter presenter;

    @Override
    public void init() {
        this.presenter = FXApplication.getMainPresenter();
    }

    public void clickEnoughButton() {
        presenter.setState("main");
    }
}
