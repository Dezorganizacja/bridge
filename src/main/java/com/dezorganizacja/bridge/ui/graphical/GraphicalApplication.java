package com.dezorganizacja.bridge.ui.graphical;

import com.dezorganizacja.bridge.presenter.GamePresenter;
import com.dezorganizacja.bridge.ui.UIApplication;
import javafx.application.Application;

public class GraphicalApplication implements UIApplication {
    @Override
    public void start(GamePresenter controller, String[] args) {
        FXApplication.setGamePresenter(controller);
        Application.launch(FXApplication.class, args);
    }
}
