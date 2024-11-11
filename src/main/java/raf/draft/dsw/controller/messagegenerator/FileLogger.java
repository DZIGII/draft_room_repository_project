package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.model.messages.Message;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger {
    private static final String path = "src/main/resources/log.txt";


    @Override
    public void nodeDeleted() {

    }

    @Override
    public void nodeAdded() {

    }

    @Override
    public void update(Message message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(message.getContent());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing log file");
        }
    }

    @Override
    public void log(String message) {

    }
}
