package com.dezorganizacja.bridge.view.graphical;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class SideMenuController {
    @FXML
    void clickGarbageCollector() {
        System.gc();
        System.runFinalization();
    }

    @FXML
    void clickExit() {
        Platform.exit();
    }
}
