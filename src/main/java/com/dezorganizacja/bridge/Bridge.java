package com.dezorganizacja.bridge;

import com.dezorganizacja.bridge.domain.Message;
import com.dezorganizacja.bridge.presenter.MainPresenter;
import com.dezorganizacja.bridge.view.View;
import com.dezorganizacja.bridge.view.graphical.GraphicalView;

public class Bridge {
    public static void main(String[] args) {
        Message message = new Message("Such a great game!");
        MainPresenter presenter = new MainPresenter(message);

        View view = new GraphicalView();
        view.show(presenter, args);
    }
}
