package raf.draft.dsw.model.messages;

import java.sql.Timestamp;

public class Message {

    private String content; //sadrzaj poruke
    private String messageType; // (npr. "GREŠKA", "UPOZORENJE", "OBAVEŠTENJE")
    private Timestamp timestamp; // Vreme generisanja poruke

    public Message(String content, String messageType, Timestamp timestamp) {
        this.content = content;
        this.messageType = messageType;
        this.timestamp = timestamp;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
