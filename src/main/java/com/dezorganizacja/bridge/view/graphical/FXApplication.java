package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class FXApplication extends Application implements Observer {
    private static MainPresenter mainPresenter;
    private Stage stage;
    private String fxml;

    public static void setMainPresenter(MainPresenter mainPresenter) {
        FXApplication.mainPresenter = mainPresenter;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FXApplication.mainPresenter.addObserver(this);
        loadMainScene();
    }

    private void loadMainScene() {
        StageProperties stageProperties = new StageProperties(stage);

        String programState = mainPresenter.getState();
        String fxml = stateToFXML(programState);

        if (this.fxml != null && this.fxml.equals(fxml)) {
            return;
        }
        this.fxml = fxml;

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("error while loading " + fxml + " resource", e);
        }

        stage.setTitle("Bridge");

        stage.setScene(new Scene(root));
        Pane root_pane = loader.getRoot();
        stage.setMinHeight(root_pane.getMinHeight());
        stage.setMinWidth(root_pane.getMinWidth());

        Controller controller = loader.getController();
        if (controller != null) {
            controller.init(mainPresenter);
        }

        stageProperties.configureStage(stage);
        stage.show();
    }

    public void changeMainScene() {
        Platform.runLater(this::loadMainScene);
    }

    @Override
    public void update(Observable observable, Object o) {
        changeMainScene();
    }

    private static String stateToFXML(String state) {
        if (state == null) {
            return "/fxml/loading.fxml";
        }

        switch (state) {
            case "loading":
                return "/fxml/loading.fxml";
            case "main":
                return "/fxml/mainMenu.fxml";
            case "credits":
                return "/fxml/credits_wrapper.fxml";
            case "bidding":
                return "/fxml/bidding.fxml";
            case "game":
                return "/fxml/game.fxml";
        }

        throw new IllegalArgumentException("No such state: " + state);
    }
}
