package com.dezorganizacja.bridge.view.graphical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MainMenuController extends Controller {

    @FXML
    void creditsClick(ActionEvent event) {
        presenter.setState("credits");
    }

    @FXML
    void playClick(ActionEvent event) {
        presenter.setState("bidding");
    }

    @FXML
    void exitClick(ActionEvent event) {
        presenter.exitNow();
    }
}
