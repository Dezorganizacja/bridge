package com.dezorganizacja.bridge.view.graphical;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController extends Controller {
    @FXML private Label message;

    public void clickLabel() {
        message.setText(presenter.getMessage().getText());
    }
}
