package com.dezorganizacja.bridge.view.graphical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BiddingController extends Controller {
   @FXML
    void endBidding(ActionEvent event) {
        presenter.setState("game");
    }
}
