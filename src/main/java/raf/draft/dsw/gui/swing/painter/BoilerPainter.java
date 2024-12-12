package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Boiler;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;

public class BoilerPainter implements ElementPainter{
    private Boiler boiler;

    public BoilerPainter(Boiler boiler) {
        this.boiler = boiler;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = boiler.getLocation().getX();
        double y = boiler.getLocation().getY();
        double diameter = boiler.getDimension().getWidth();
        double radius = diameter / 2;

        g.setColor(Color.BLACK);
        g.drawOval((int) (x - radius), (int) (y - radius), (int) diameter, (int) diameter);

        double innerMargin = radius * 0.5;

        g.drawLine((int) (x - radius + innerMargin), (int) (y - radius + innerMargin),(int) (x + radius - innerMargin), (int) (y + radius - innerMargin));
        g.drawLine((int) (x - radius + innerMargin), (int) (y + radius - innerMargin),(int) (x + radius - innerMargin), (int) (y - radius + innerMargin));
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }

    public Boiler getBoiler() {
        return boiler;
    }

    public void setBoiler(Boiler boiler) {
        this.boiler = boiler;
    }
}
