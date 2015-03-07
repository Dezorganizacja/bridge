package com.dezorganizacja.bridge.ui;

import com.dezorganizacja.bridge.presenter.GamePresenter;

public interface UIApplication {
    public void start(GamePresenter controller, String[] args);
}
