package com.dezorganizacja.bridge.view.text;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maciek on 13.04.15.
 */


interface Command {
    void runCommand(List<String> args);
}

public class OrdersHandler {
    private final Map<String, Command> menuEntries = new HashMap<>();
    private final Map<String, String> menuDetails = new HashMap<>();
    {
        menuEntries.put("h", this::help);
        menuEntries.put("help", this::help);
        menuEntries.put("credits", this::credits);
        menuEntries.put("menu", this::print_menu);

        menuDetails.put("start", "Start game");
        menuDetails.put("end", "Quit game");
        menuDetails.put("h", "Help system");
        menuDetails.put("help", "Help system");
        menuDetails.put("credits", "Credits");
        menuDetails.put("menu", "Displays the possible prompt commands");
    }

    private void help(List<String> args) {
        print("Some help should go here");
    }

    private void credits(List<String> args) {
        print("Some credits should go here");
    }

    private void print_menu(List<String> args) {
        for(String menuPosition : menuDetails.keySet()) {
            print(menuPosition + " - " + menuDetails.get(menuPosition));
        }
    }

    private void print(String toPrint) {
        System.out.println(toPrint);
    }

    public void dispatchOrder(String command, List<String> args) {
        if(!menuEntries.containsKey(command)) {
            print("No such command: " + command);
        } else {
            menuEntries.get(command).runCommand(args);
        }
    }
}
