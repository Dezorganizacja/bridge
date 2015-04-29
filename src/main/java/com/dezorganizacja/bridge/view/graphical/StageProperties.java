package com.dezorganizacja.bridge.view.graphical;

import javafx.stage.Stage;

public class StageProperties {
    private double height;
    private double width;

    private boolean always_on_top;
    private boolean fullscreen;
    private boolean maximized;

    StageProperties(Stage stage) {
        height = stage.getHeight();
        width = stage.getWidth();

        always_on_top = stage.isAlwaysOnTop();
        fullscreen = stage.isFullScreen();
        maximized = stage.isMaximized();
    }

    public void configureStage(Stage stage) {
        stage.setHeight(height);
        stage.setWidth(width);

        stage.setAlwaysOnTop(always_on_top);
        stage.setFullScreen(fullscreen);
        stage.setMaximized(maximized);
    }
}
