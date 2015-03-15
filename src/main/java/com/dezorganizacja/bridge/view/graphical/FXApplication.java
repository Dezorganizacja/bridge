package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class FXApplication extends Application implements Observer {
    private static MainPresenter mainPresenter;
    private static Stage stage;
    private static String fxml;

    public static void setMainPresenter(MainPresenter mainPresenter) {
        FXApplication.mainPresenter = mainPresenter;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXApplication.stage = stage;
        FXApplication.mainPresenter.addObserver(this);
        _changeMainScene();
    }

    private void _changeMainScene() {
        String programStage = mainPresenter.getStage();
        String fxml = ProgramStageMap.stageToFXML(programStage);

        if (FXApplication.fxml != null && FXApplication.fxml.equals(fxml)) {
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.err.println("error while loading " + fxml + " resource");
            e.printStackTrace();
            return;
        }

        stage.setTitle("Bridge");
        stage.setScene(new Scene(root, 300, 275));

        Controller controller = loader.getController();
        if (controller != null) {
            controller.init(mainPresenter);
        }

        stage.show();
    }

    public void changeMainScene() {
        // TODO thread safety
        Platform.runLater(this::_changeMainScene);
    }

    @Override
    public void update(Observable observable, Object o) {
        changeMainScene();
    }
}
