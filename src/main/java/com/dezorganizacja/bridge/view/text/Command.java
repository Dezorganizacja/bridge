package com.dezorganizacja.bridge.view.text;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Command {
    public abstract void runCommand(List<String> args);
    public abstract String details();

    static Command newCommand(Consumer<List<String>> commandMethod,
                                  Supplier<String> commandDetails) {
        return new Command() {
            @Override
            public void runCommand(List<String> args) {
                commandMethod.accept(args);
            }

            @Override
            public String details() {
                return commandDetails.get();
            }
        };
    }

}
