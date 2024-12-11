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
        GeneralPath doorShape = new GeneralPath();

        double x = door.getLocation().getX();
        double y = door.getLocation().getY();
        double widthEl = door.getDimension().getWidth();
        double heightEl = door.getDimension().getHeight();

        doorShape.moveTo(x, y + heightEl);
        doorShape.quadTo(x, y, x + widthEl * 0.6, y);

        doorShape.lineTo(x + widthEl, y);

        doorShape.lineTo(x + widthEl, y + heightEl);

        doorShape.closePath();

        g.setColor(new Color(173, 216, 230));
        g.fill(doorShape);

        g.setColor(Color.BLUE);
        g.draw(doorShape);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }
}
