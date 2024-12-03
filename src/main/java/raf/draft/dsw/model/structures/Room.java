package raf.draft.dsw.model.structures;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.ArrayList;
import java.util.List;

public class Room extends DraftNodeComposite implements IPublisher {

    private RoomView tab;
    private List<ISubscriber> subscribers = new ArrayList<>();
    private Color color;
    private Dimension2D dimension;

    public Room(String name, DraftNode parent, RoomView tab) {
        super(name, parent);
        this.tab = tab;
        color = generateColor();
        subscribe(tab);
        tab.setRoom(this);
        tab.setRoomName(this.getName());
        notifyAdded();
        color = generateColor();
    }

    public Room(String name, DraftNode parent) {
        super(name,parent);
        this.tab = new RoomView(name, this);
        subscribe(tab);
        notifyAdded();
        color = generateColor();
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

    public RoomView getTab() {
        return tab;
    }

    public void setTab(RoomView tab) {
        this.tab = tab;
    }

    public Color generateColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        return new Color(red, green, blue);
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
