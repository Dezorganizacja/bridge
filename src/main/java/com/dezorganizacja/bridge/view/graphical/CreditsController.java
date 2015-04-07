package com.dezorganizacja.bridge.view.graphical;

import com.dezorganizacja.bridge.presenter.MainPresenter;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import static java.lang.Thread.sleep;

public class CreditsController extends Controller {

    public AnchorPane creditsPane;

    public void closeCredits(ActionEvent actionEvent) {
        presenter.setState("main");
    }

    @Override
    public void init(MainPresenter presenter) {
        super.init(presenter);

        creditsPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        int duration = 10000;

        VBox myCreditsBox = new VBox();
        myCreditsBox.getChildren().add((new CreditsNodeController()).setCodePieceLabel("OPs").addAuthor("Grzegorz Świrski").addAuthor("Marek Rusinowski").accept());
        myCreditsBox.getChildren().add((new CreditsNodeController()).setCodePieceLabel("GUI").addAuthor("Michał Ziobro").addAuthor("Bartłomiej Puget").addAuthor("Dominika Salawa").addAuthor("Maciej Wachulec").accept());
        myCreditsBox.getChildren().add((new CreditsNodeController()).setCodePieceLabel("TUI").addAuthor("Maciej Woźniak").accept());

        creditsPane.getChildren().add(myCreditsBox);

        Path path = new Path();
        path.getElements().add(new MoveTo(300,600));
        path.getElements().add(new LineTo(300,-200));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(duration));
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setNode(myCreditsBox);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        new Thread(() -> {
            try
            {
                sleep(duration);
            } catch (InterruptedException e) {
                RuntimeException tmp = new RuntimeException("Interrupted not expected");
                throw tmp;
            }
            pathTransition.stop();
            presenter.setState("main");
        }).start();

    }

    public static class CreditsNodeController extends VBox {



        private class AuthorLabel extends Label {
            public AuthorLabel(String name) {
                super(name);
                this.setFont(new Font("Verdena", 20));
                this.setTextFill(Color.LIGHTGRAY);
            }
        }

        private class CodePieceLabel extends Label {
            public CodePieceLabel(String name) {
                super(name);
                this.setFont(new Font("Verdena", 27));
                this.setTextFill(Color.LIGHTGRAY);
            }
        }

        public CodePieceLabel codePieceLabel;

        public CreditsNodeController() {
            super();
            codePieceLabel = new CodePieceLabel("Sample piece");
            this.getChildren().add(codePieceLabel);
        }

        CreditsNodeController setCodePieceLabel(String name) {
            codePieceLabel.setText(name);
            return this;
        }

        CreditsNodeController addAuthor(String author) {
            this.getChildren().add(new AuthorLabel(author));
            return this;
        }

        CreditsNodeController accept() {
            Region reg = new Region();
            reg.setMinHeight(40);
            this.getChildren().add(reg);
            return this;
        }
    }
}
