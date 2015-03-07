package com.dezorganizacja.bridge;

import com.dezorganizacja.bridge.domain.Message;
import com.dezorganizacja.bridge.presenter.GamePresenter;
import com.dezorganizacja.bridge.ui.UIApplication;
import com.dezorganizacja.bridge.ui.graphical.GraphicalApplication;

public class Bridge {
    public static void main(String[] args) {
        Message message = new Message("Such a great game!");
        GamePresenter controller = new GamePresenter(message);

        UIApplication application = new GraphicalApplication();
        application.start(controller, args);
    }
}
