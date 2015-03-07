package com.dezorganizacja.bridge.ui.graphical;

import com.dezorganizacja.bridge.presenter.GamePresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXApplication extends Application {
    private static GamePresenter gamePresenter;

    public static void setGamePresenter(GamePresenter gamePresenter) {
        FXApplication.gamePresenter = gamePresenter;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = loader.load();
        stage.setTitle("Bridge");
        stage.setScene(new Scene(root, 300, 275));

        MainController controller = loader.getController();
        controller.setupStage(gamePresenter);

        stage.show();
    }
}
