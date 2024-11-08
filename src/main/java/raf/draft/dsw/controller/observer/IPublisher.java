package raf.draft.dsw.controller.observer;

import raf.draft.dsw.model.messages.Message;

import java.util.List;

public interface IPublisher {
    void notifySubscribers(Object notification);
    void subscribe(ISubscriber logger);
    void unsubscribe(ISubscriber logger);
}
