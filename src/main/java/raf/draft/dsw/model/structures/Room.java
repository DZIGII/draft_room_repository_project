package raf.draft.dsw.model.structures;

import raf.draft.dsw.controller.messagegenerator.Logger;
import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.TabFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.Leaf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room extends Leaf implements IPublisher {

    private TabFrame tab;
    private List<ISubscriber>  subscribers=new ArrayList<>();

    public Room(String name, DraftNode parent, TabFrame tab) {
        super(name, parent);
        this.tab = tab;
        subscribe(tab);
        tab.setRoom(this);
        tab.setRoomName(this.getName());
        notifyAdded();
    }

    public Room(String name, DraftNode parent) {
        super(name,parent);
        this.tab = new TabFrame();
        subscribe(tab);
        tab.setRoom(this);
        tab.setRoomName(this.getName());
        notifyAdded();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscribers(name);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.recive(notification);
        }
    }

    @Override
    public void subscribe(ISubscriber tab) {
        subscribers.add(tab);
    }

    @Override
    public void unsubscribe(ISubscriber tab) {
        subscribers.remove(tab);
    }

    @Override
    public void notifyDeleted() {
        for (ISubscriber subscriber : subscribers) {
            subscriber.nodeDeleted();
        }
    }

    @Override
    public void notifyAdded() {
        for (ISubscriber subscriber : subscribers) {
            subscriber.nodeAdded();
        }
    }

    public TabFrame getTab() {
        return tab;
    }

    public void setTab(TabFrame tab) {
        this.tab = tab;
    }



    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
