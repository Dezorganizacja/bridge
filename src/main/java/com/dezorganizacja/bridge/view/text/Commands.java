package com.dezorganizacja.bridge.view.text;

import java.util.List;
import java.util.function.Consumer;

public class Commands {
    static Command newCommand(Consumer<List<String>> commandMethod,
                              final String commandDetails) {
        return new Command() {
            @Override
            public void runCommand(List<String> args) {
                commandMethod.accept(args);
            }

            @Override
            public String details() {
                return commandDetails;
            }
        };
    }}
