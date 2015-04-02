package com.dezorganizacja.bridge.view.graphical;

/**
 * Created by michaziobro on 02.04.2015.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class BiddingController extends Controller {


    @FXML
    void endBidding(ActionEvent event) {
        presenter.setState("game");
    }

    @FXML
    void initialize() {

    }

}
