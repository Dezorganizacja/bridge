package com.dezorganizacja.bridge.view.graphical;

import javafx.event.ActionEvent;

public class CreditsController extends Controller {

    public void closeCredits(ActionEvent actionEvent) {
        presenter.setState("main");
    }
}
