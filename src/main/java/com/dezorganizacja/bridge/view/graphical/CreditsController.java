package com.dezorganizacja.bridge.view.graphical;

import javafx.event.ActionEvent;

/**
 * Created by michaziobro on 02.04.2015.
 */
public class CreditsController extends Controller {

    public void closeCredits(ActionEvent actionEvent) {
        presenter.setState("main");
    }
}
