package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;

public class LoadingController extends Controller {
    public void clickEnoughButton() {
        presenter.setState("main");
    }
}
