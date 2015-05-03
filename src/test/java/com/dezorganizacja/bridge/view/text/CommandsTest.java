package com.dezorganizacja.bridge.view.text;

import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Test;

public class CommandsTest extends TestCase {
    @Test
    public void testNewCommandDetails() throws Exception {
        Command testCommand = Commands.newCommand((List<String> args)->{return;}, "new commands details");
        assertEquals(testCommand.details(), "new commands details");
    }
}