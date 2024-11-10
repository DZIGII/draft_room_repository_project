package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements IPublisher {

    private List<ISubscriber> subscribers = new ArrayList<>();

    public MessageGenerator() {
    }

    public void generateMessage(String content, String type) {
        Message message = new Message(content, type);
        notifySubscribers(message);
    }



    @Override
    public void notifySubscribers(Object message) {
        for (ISubscriber subscriber : subscribers) {
            if(subscriber instanceof Logger) {
                ((Logger)subscriber).log(message.toString());
            }
        }
    }

    @Override
    public void subscribe(ISubscriber logger) {
        subscribers.add(logger);
    }

    @Override
    public void unsubscribe(ISubscriber logger) {
        subscribers.remove(logger);
    }

    @Override
    public void notifyDeleted() {
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
