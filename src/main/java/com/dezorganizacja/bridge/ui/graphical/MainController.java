package com.dezorganizacja.bridge.ui.graphical;

import com.dezorganizacja.bridge.presenter.GamePresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    private GamePresenter presenter;
    @FXML private Label message;

    public void setupStage(GamePresenter presenter) {
        this.presenter = presenter;
    }

    public void clickLabel() {
        message.setText(presenter.getMessage().getText());
    }
}
