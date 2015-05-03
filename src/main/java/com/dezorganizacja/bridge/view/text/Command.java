package com.dezorganizacja.bridge.view.text;

import java.util.List;

interface Command {
    void runCommand(List<String> args);
    String details();
}
