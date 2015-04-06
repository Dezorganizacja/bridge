package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController implements Controller {
    private MainPresenter presenter;

    @FXML private Label message;

    @Override
    public void init() {
        this.presenter = FXApplication.getMainPresenter();
    }

    public void clickLabel() {
        message.setText(presenter.getMessage().getText());
    }
}
