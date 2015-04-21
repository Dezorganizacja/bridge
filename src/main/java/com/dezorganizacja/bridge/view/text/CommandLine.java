package com.dezorganizacja.bridge.view.text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLine {
    private MainMenu standardMenu = new MainMenu();

    public void startCommandLine() {
        Scanner input = new Scanner(System.in);
        standardMenu.dispatchMenu("help", new ArrayList<>());
        while(input.hasNextLine()) {
            ArrayList<String> args = parse(input.nextLine());
            standardMenu.dispatchMenu(args.get(0), args);
        }
    }

    private ArrayList<String> parse(String line) {
        String[] words = line.split(" ");
        ArrayList<String> args = new ArrayList<>();
        for(String tmp : words) args.add(tmp);
        return args;
    }
}
