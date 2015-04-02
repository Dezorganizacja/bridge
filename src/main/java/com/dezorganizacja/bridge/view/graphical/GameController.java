package com.dezorganizacja.bridge.view.graphical;

import javafx.event.ActionEvent;

public class GameController extends Controller {

    public void oneMore(ActionEvent actionEvent) {
        presenter.setState("bidding");
    }

    public void endGame(ActionEvent actionEvent) {
        presenter.setState("main");
    }
}
