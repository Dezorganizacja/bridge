package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public AnchorPane creditsPane;

    public void closeCredits(ActionEvent actionEvent) {
        presenter.setState("main");
    }

    @Override
    public void init(MainPresenter presenter) {
        super.init(presenter);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/movingCredits.fxml"));
        VBox creditsBox;
        try {
            creditsBox = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("error while loading /fxml/movingCredits.fxml resource", e);
        }


        creditsPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));



        creditsPane.getChildren().add(creditsBox);

        Path path = new Path();
        path.getElements().add(new MoveTo(300,creditsPane.getHeight()+creditsBox.getPrefHeight()/2+100)); // sth like window size, dunno if it's fixed or not
        path.getElements().add(new LineTo(300,-creditsBox.getPrefHeight()/2-100));

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

