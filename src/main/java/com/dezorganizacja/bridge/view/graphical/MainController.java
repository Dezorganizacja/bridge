package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    private MainPresenter presenter;
    @FXML private Label message;

    public void init(MainPresenter presenter) {
        this.presenter = presenter;
    }

    public void clickLabel() {
        message.setText(presenter.getMessage().getText());
    }
}
