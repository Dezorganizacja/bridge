package com.dezorganizacja.bridge.view;

import com.dezorganizacja.bridge.presenter.MainPresenter;

public interface View {
    public void show(MainPresenter controller, String[] args);
}
