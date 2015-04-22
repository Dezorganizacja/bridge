package com.dezorganizacja.bridge.view.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maciek on 13.04.15.
 */


interface Command {
    void runCommand(ArrayList<String> args);
}

public class OrdersHandler {
    private Map<String, Command> menuEntries = new HashMap<>();
    private Map<String, String> menuDetails = new HashMap<>();
    {
        menuEntries.put("h", (ArrayList<String> args)->{this.help(args);});
        menuEntries.put("help", (ArrayList<String> args)->{this.help(args);});
        menuEntries.put("credits", (ArrayList<String> args)->{this.credits(args);});
        menuEntries.put("menu", (ArrayList<String> args)->{this.print_menu(args);});

        menuDetails.put("h", "Help system");
        menuDetails.put("help", "Help system");
        menuDetails.put("credits", "Credits");
        menuDetails.put("menu", "Displays the possible prompt commands");
    }

    private void help(ArrayList<String> args) {
        print("Some help should go here");
    }

    private void credits(ArrayList<String> args) {
        print("Some credits should go here");
    }

    private void print_menu(ArrayList<String> args) {
        for(String menuPosition : menuDetails.keySet()) {
            print(menuPosition + " - " + menuDetails.get(menuPosition));
        }
    }

    private void print(String toPrint) {
        System.out.println(toPrint);
    }

    public void dispatchOrder(String commad, ArrayList<String> args) {
        if(!menuEntries.containsKey(commad)) {
            print("No such command: " + commad);
        } else {
            menuEntries.get(commad).runCommand(args);
        }
    }


}
