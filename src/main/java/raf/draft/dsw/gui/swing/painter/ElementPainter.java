package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;

public interface ElementPainter {

    void paint(Graphics2D g, RoomElement roomElement);
    boolean elementAt(RoomElement roomElement, Point pos);
    Rectangle getBound(RoomElement roomElement);
    void setSelected(RoomElement roomElement, boolean isSelected);
    boolean isSelected();
    void resetSelected();
    RoomElement getElement();
    void setOverlap();
    void resetOverlap();

}
