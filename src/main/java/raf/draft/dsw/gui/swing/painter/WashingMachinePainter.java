package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.RoomElement;
import raf.draft.dsw.model.structures.roomElements.Toilet;
import raf.draft.dsw.model.structures.roomElements.WashingMachine;

import java.awt.*;

public class WashingMachinePainter implements ElementPainter{
    private WashingMachine machine;
    private boolean selected;
    private boolean overlap;

    public WashingMachinePainter(WashingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = machine.getLocation().getX();
        double y = machine.getLocation().getY();
        double width = machine.getDimension().getWidth();

        Color rectFillColor;

        if (selected) {
            rectFillColor = new Color(173, 216, 230);
        }
        else if (overlap) {
            rectFillColor = Color.red;
        }
        else {
            rectFillColor = Color.WHITE;
        }

        g.setColor(rectFillColor);
        g.fillRect((int) x, (int) y, (int) width, (int) width);
        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, (int) width, (int) width);

        double ovalX = x + width * 0.1;
        double ovalY = y + width * 0.1;
        double ovalWidth = width * 0.8;
        double ovalHeight = width * 0.8;

        g.setColor(selected ? new Color(173, 216, 230) : Color.WHITE);
        g.fillOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
        g.setColor(Color.BLACK);
        g.drawOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        if (!(roomElement instanceof WashingMachine)) {
            return false;
        }

        Rectangle bounds = getBound(roomElement);
        return bounds.contains(pos);
    }

    @Override
    public Rectangle getBound(RoomElement roomElement) {
        if (!(roomElement instanceof WashingMachine)) {
            return null;
        }

        double x = machine.getLocation().getX();
        double y = machine.getLocation().getY();
        double widthEl = machine.getDimension().getWidth();
        double heightEl = machine.getDimension().getHeight();

        return new Rectangle((int) x, (int) y, (int) widthEl, (int) heightEl);
    }

    @Override
    public void setSelected(RoomElement roomElement, boolean isSelected) {
        if (roomElement instanceof WashingMachine) {
            this.selected = isSelected;
        }
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void resetSelected() {
        this.selected = false;
    }

    @Override
    public RoomElement getElement() {
        return machine;
    }

    @Override
    public void setOverlap() {
        overlap = true;
    }

    @Override
    public void resetOverlap() {
        overlap = false;
    }

    public WashingMachine getMachine() {
        return machine;
    }

    public void setMachine(WashingMachine machine) {
        this.machine = machine;
    }

    public boolean isOverlap() {
        return overlap;
    }
}
