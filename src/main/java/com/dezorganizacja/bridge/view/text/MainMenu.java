package com.dezorganizacja.bridge.view.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface Command {
    void runCommand(ArrayList<String> args);
}

public class MainMenu {
    private Map<String, Command> menu = new HashMap<>();
    private Map<String, String> menuDetails = new HashMap<>();
    {
        menu.put("h", (ArrayList<String> args)->{this.help(args);});
        menu.put("help", (ArrayList<String> args)->{this.help(args);});
        menu.put("credits", (ArrayList<String> args)->{this.credits(args);});
        menu.put("menu", (ArrayList<String> args)->{this.print_menu(args);});

        menuDetails.put("h", "Help system");
        menuDetails.put("help", "Help system");
        menuDetails.put("credits", "Credits");
        menuDetails.put("menu", "Displays the possible prompt commands");
    }

    private void help(ArrayList<String> args) {
        tmp_stdout_wrapper("Some help should go here");
    }

    private void credits(ArrayList<String> args) {
        tmp_stdout_wrapper("Some credits should go here");
    }

    private void print_menu(ArrayList<String> args) {
        for(String menuPosition : menuDetails.keySet()) {
            tmp_stdout_wrapper(menuPosition + " - " + menuDetails.get(menuPosition));
        }
    }

    private void tmp_stdout_wrapper(String toPrint) {
        System.out.println(toPrint);
    }

    public void dispatchMenu(String commad, ArrayList<String> args) {
        if(!menu.containsKey(commad)) {
            tmp_stdout_wrapper("No such command: " + commad);
        } else {
            menu.get(commad).runCommand(args);
        }
    }



}
