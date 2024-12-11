package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;

public interface ElementPainter {

    void paint(Graphics2D g, RoomElement roomElement);
    boolean elementAt(RoomElement roomElement, Point pos);

}
