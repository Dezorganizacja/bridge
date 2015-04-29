package com.dezorganizacja.bridge.view.text;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maciek on 13.04.15.
 */

public class OrdersHandler {
    private final Map<String, Command> menuEntries = new HashMap<>();
    {
        menuEntries.put("h", Commands.newCommand(this::help, "Help system"));
        menuEntries.put("help", Commands.newCommand(this::help, "Help system"));
        menuEntries.put("credits", Commands.newCommand(this::credits, "Credits"));
        menuEntries.put("menu", Commands.newCommand(this::print_menu, "Display the possible prompt commands"));
    }

    private void help(List<String> args) {
        print("Some help should go here");
    }

    private void credits(List<String> args) {
        print("Some credits should go here");
    }

    private void print_menu(List<String> args) {
        for(Map.Entry<String, Command> menuPosition : menuEntries.entrySet()) {
            print(menuPosition.getKey() + " - " + menuPosition.getValue().details());
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
