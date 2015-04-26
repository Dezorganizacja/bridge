package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class CreditsController extends Controller {

    public BorderPane creditsPane;
    public VBox creditsBox;

    public void closeCredits(ActionEvent actionEvent) {
        presenter.setState("main");
    }

    @Override
    public void init(MainPresenter presenter) {
        super.init(presenter);

        Path path = new Path();
        path.getElements().add(new MoveTo(200, creditsPane.getHeight() + creditsBox.getHeight() / 2));
        path.getElements().add(new LineTo(200, -creditsBox.getHeight()/2));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(20000));
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setNode(creditsBox);
        pathTransition.setCycleCount(1);
        pathTransition.play();
        pathTransition.setOnFinished(event -> presenter.setState("main"));
    }
}

