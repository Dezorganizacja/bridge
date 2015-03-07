package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXApplication extends Application {
    private static MainPresenter mainPresenter;

    public static void setMainPresenter(MainPresenter mainPresenter) {
        FXApplication.mainPresenter = mainPresenter;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = loader.load();
        stage.setTitle("Bridge");
        stage.setScene(new Scene(root, 300, 275));

        MainController controller = loader.getController();
        controller.init(mainPresenter);

        stage.show();
    }
}
