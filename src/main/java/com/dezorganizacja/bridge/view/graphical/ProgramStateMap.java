package com.dezorganizacja.bridge.view.graphical;

public class ProgramStateMap {
    public static String stateToFXML(String state) {
        if (state == null) {
            return "/fxml/loading.fxml";
        }

        switch (state) {
            case "loading":
                return "/fxml/loading.fxml";
        }

        throw new IllegalArgumentException("No such state: " + state);
    }
}
