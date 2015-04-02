package com.dezorganizacja.bridge.view.graphical;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


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

    @FXML
    void initialize() {

    }

}
