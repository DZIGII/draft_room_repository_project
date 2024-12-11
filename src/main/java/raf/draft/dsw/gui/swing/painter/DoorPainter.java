package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Door;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class DoorPainter implements ElementPainter{

    private Door door;

    public DoorPainter(Door door) {
        this.door = door;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        GeneralPath doorPath = new GeneralPath();

        double x = door.getLocation().getX();
        double y = door.getLocation().getY();
        double widthEl = door.getDimension().getWidth();
        double heightEl = door.getDimension().getHeight();

        doorPath.moveTo(x, y);
        doorPath.lineTo(x + widthEl * 0.5, y - heightEl);
        doorPath.lineTo(x + widthEl, y);
        doorPath.closePath();

        g.setColor(Color.DARK_GRAY);
        g.fill(doorPath);
        g.setColor(Color.BLACK);
        g.draw(doorPath);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }
}
