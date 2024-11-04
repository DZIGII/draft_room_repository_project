package raf.draft.dsw.model.messages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private String content; //sadrzaj poruke
    private String messageType; // (npr. "GREŠKA", "UPOZORENJE", "OBAVEŠTENJE")
    private LocalDateTime timestamp; // Vreme generisanja poruke

    public Message(String content, String messageType) {
        this.content = content;
        this.messageType = messageType;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "[" + messageType + "][" + timestamp.format(DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm")) + "] " + content;
    }
}
