package com.dezorganizacja.bridge.view.graphical;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainMenuController extends Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button creditsButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button playButton;


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
        assert creditsButton != null : "fx:id=\"creditsButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'mainMenu.fxml'.";


    }

}
