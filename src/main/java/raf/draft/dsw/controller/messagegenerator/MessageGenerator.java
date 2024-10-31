package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.messages.Message;

import java.util.List;

public class MessageGenerator implements IPublisher {

    private List<ISubscriber> subscribers;
    private Message message;

    public MessageGenerator(List<ISubscriber> subscribers, Message message) {
        this.subscribers = subscribers;
        this.message = message;
    }

    @Override
    public void notifySubscribers() {

    }
}
