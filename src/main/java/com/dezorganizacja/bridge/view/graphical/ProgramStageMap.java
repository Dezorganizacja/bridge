package com.dezorganizacja.bridge.view.graphical;

public class ProgramStageMap {
    public static String stageToFXML(String stage) {
        if (stage == null) {
            return "/fxml/loading.fxml";
        }

        switch (stage) {
            case "loading":
                return "/fxml/loading.fxml";
        }

        throw new IllegalArgumentException("No such stage: " + stage);
    }
}
