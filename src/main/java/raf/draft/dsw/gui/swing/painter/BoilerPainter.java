package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.Boiler;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;

public class BoilerPainter implements ElementPainter{
    private Boiler boiler;
    private boolean selected;

    public BoilerPainter(Boiler boiler) {
        this.boiler = boiler;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = boiler.getLocation().getX();
        double y = boiler.getLocation().getY();
        double diameter = boiler.getDimension().getWidth();
        double radius = diameter / 2;

        Color fillColor = selected ? new Color(173, 216, 230) : Color.WHITE;

        g.setColor(Color.BLACK);
        g.drawOval((int) (x - radius), (int) (y - radius), (int) diameter, (int) diameter);

        g.setColor(fillColor);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) diameter, (int) diameter);

        double innerMargin = radius * 0.5;
        g.setColor(Color.BLACK);
        g.drawLine((int) (x - radius + innerMargin), (int) (y - radius + innerMargin),
                (int) (x + radius - innerMargin), (int) (y + radius - innerMargin));
        g.drawLine((int) (x - radius + innerMargin), (int) (y + radius - innerMargin),
                (int) (x + radius - innerMargin), (int) (y - radius + innerMargin));
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        if (!(roomElement instanceof Boiler)) {
            return false;
        }

        Rectangle bounds = getBound(roomElement);
        return bounds.contains(pos);
    }

    @Override
    public Rectangle getBound(RoomElement roomElement) {
        if (!(roomElement instanceof Boiler)) {
            return null;
        }

        double x = boiler.getLocation().getX();
        double y = boiler.getLocation().getY();
        double widthEl = boiler.getDimension().getWidth();
        double heightEl = boiler.getDimension().getHeight();

        return new Rectangle((int) x, (int) y, (int) widthEl, (int) heightEl);
    }

    @Override
    public void setSelected(RoomElement roomElement, boolean isSelected) {
        if (roomElement instanceof Boiler) {
            this.selected = isSelected;
        }
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void resetSelected() {
        selected = false;
    }

    @Override
    public RoomElement getElement() {
        return boiler;
    }

    public Boiler getBoiler() {
        return boiler;
    }

    public void setBoiler(Boiler boiler) {
        this.boiler = boiler;
    }
}
