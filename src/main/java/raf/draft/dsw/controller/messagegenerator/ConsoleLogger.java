package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.model.messages.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger extends Logger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
