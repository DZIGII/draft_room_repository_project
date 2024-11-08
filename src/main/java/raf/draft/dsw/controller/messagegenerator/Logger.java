package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.messages.Message;

public abstract class Logger implements ISubscriber {
    public abstract void log(String message);

    @Override
    public void recive(Object message) {
        log(message.toString());
    }
}
