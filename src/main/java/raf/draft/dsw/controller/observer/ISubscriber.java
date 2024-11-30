package raf.draft.dsw.controller.observer;

import raf.draft.dsw.model.messages.Message;

public interface ISubscriber {
    void recive(Object notification);
    void nodeDeleted();
    void nodeAdded();
    void update(Message message);
}
