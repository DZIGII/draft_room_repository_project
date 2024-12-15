package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.Boiler;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

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
        double diameter = Math.min(boiler.getDimension().getWidth(), boiler.getDimension().getHeight());

        double padding = diameter * 0.1;
        double innerDiameter = diameter - 2 * padding;

        double centerX = x + diameter / 2;
        double centerY = y + diameter / 2;

        Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);

        if (selected) {
            g.setColor(new Color(173, 216, 230));
        } else {
            g.setColor(Color.LIGHT_GRAY);
        }
        g.fill(circle);
        g.setColor(Color.BLACK);
        g.draw(circle);

        GeneralPath xShape = new GeneralPath();

        xShape.moveTo(centerX - innerDiameter / 2, centerY - innerDiameter / 2);
        xShape.lineTo(centerX + innerDiameter / 2, centerY + innerDiameter / 2);

        xShape.moveTo(centerX + innerDiameter / 2, centerY - innerDiameter / 2);
        xShape.lineTo(centerX - innerDiameter / 2, centerY + innerDiameter / 2);

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2)); // Debljina linije za "X"
        g.draw(xShape);
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
