package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BedPainter;
import raf.draft.dsw.gui.swing.painter.DoorPainter;
import raf.draft.dsw.model.structures.roomElements.Door;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddDoorState implements State {
    @Override
    public void log() {

    }

    @Override
    public void printBed(Point2D clickPoint, RoomView roomView) {

    }

    public void printDoor(Point2D clickPoint, RoomView roomView) {
        Dimension2D d = new Dimension();
        Door door = new Door("Bed", clickPoint, d);

        door.setLocation(clickPoint);
        door.setDimension(30, 30);
        DoorPainter bedPainter = new DoorPainter(door);

        roomView.addElement(bedPainter);
        roomView.repaint();
    }
}
