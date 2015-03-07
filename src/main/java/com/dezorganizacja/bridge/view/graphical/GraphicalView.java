package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import com.dezorganizacja.bridge.view.View;
import javafx.application.Application;

public class GraphicalView implements View {
    @Override
    public void show(MainPresenter controller, String[] args) {
        FXApplication.setMainPresenter(controller);
        Application.launch(FXApplication.class, args);
    }
}
