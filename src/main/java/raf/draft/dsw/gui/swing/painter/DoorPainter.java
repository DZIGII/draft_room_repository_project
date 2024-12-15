package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.Closet;
import raf.draft.dsw.model.structures.roomElements.Door;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class DoorPainter implements ElementPainter{

    private Door door;
    private boolean selected;

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

        Color fillColor = selected ? new Color(173, 216, 230) : Color.LIGHT_GRAY;

        g.setColor(fillColor);
        g.fill(doorShape);

        g.setColor(Color.BLACK);
        g.draw(doorShape);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        if (!(roomElement instanceof Door)) {
            return false;
        }

        Rectangle bounds = getBound(roomElement);
        return bounds.contains(pos);
    }

    @Override
    public Rectangle getBound(RoomElement roomElement) {
        if (!(roomElement instanceof Door)) {
            return null;
        }

        double x = door.getLocation().getX();
        double y = door.getLocation().getY();
        double widthEl = door.getDimension().getWidth();
        double heightEl = door.getDimension().getHeight();

        return new Rectangle((int) x, (int) y, (int) widthEl, (int) heightEl);
    }

    @Override
    public void setSelected(RoomElement roomElement, boolean isSelected) {
        if (roomElement instanceof Door) {
            this.selected = isSelected;
        }
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void resetSelected() {
        this.selected = false;
    }

    @Override
    public RoomElement getElement() {
        return door;
    }
}
