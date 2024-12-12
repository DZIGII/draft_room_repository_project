package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.RoomElement;
import raf.draft.dsw.model.structures.roomElements.WashingMachine;

import java.awt.*;

public class WashingMachinePainter implements ElementPainter{
    private WashingMachine machine;

    public WashingMachinePainter(WashingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = machine.getLocation().getX();
        double y = machine.getLocation().getY();
        double width = machine.getDimension().getWidth();

        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, (int) width, (int) width);

        double ovalX = x + width * 0.1;
        double ovalY = y + width * 0.1;
        double ovalWidth = width * 0.8;
        double ovalHeight = width * 0.8;

        g.setColor(Color.WHITE);
        g.fillOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
        g.setColor(Color.BLACK);
        g.drawOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }

    public WashingMachine getMachine() {
        return machine;
    }

    public void setMachine(WashingMachine machine) {
        this.machine = machine;
    }
}
