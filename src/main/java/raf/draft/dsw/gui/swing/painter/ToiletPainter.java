package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.RoomElement;
import raf.draft.dsw.model.structures.roomElements.Table;
import raf.draft.dsw.model.structures.roomElements.Toilet;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class ToiletPainter implements ElementPainter{
    private Toilet toilet;
    private boolean selected;

    public ToiletPainter(Toilet toilet) {
        this.toilet = toilet;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = toilet.getLocation().getX();
        double y = toilet.getLocation().getY();
        double widthEl = toilet.getDimension().getWidth();
        double heightEl = toilet.getDimension().getHeight();

        double rectHeight = heightEl * 0.5;

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, widthEl, rectHeight);

        double arcHeight = heightEl * 0.5;

        Arc2D outerArc = new Arc2D.Double(
                x,
                y,
                widthEl,
                arcHeight * 2,
                0,
                -180,
                Arc2D.OPEN
        );

        double innerArcWidth = widthEl * 0.5;
        double innerArcHeight = arcHeight * 0.5;
        double innerArcX = x + (widthEl - innerArcWidth) / 2;
        double innerArcY = y + rectHeight - (innerArcHeight / 2);

        Arc2D innerArc = new Arc2D.Double(
                innerArcX,
                innerArcY,
                innerArcWidth,
                innerArcHeight * 2,
                0,
                -180,
                Arc2D.OPEN
        );

        Color rectFillColor = selected ? new Color(173, 216, 230) : Color.DARK_GRAY;

        g.setColor(rectFillColor);
        g.fill(rectangle);
        g.setColor(Color.BLACK);
        g.draw(rectangle);

        g.setColor(selected ? new Color(173, 216, 230) : Color.LIGHT_GRAY);
        g.fill(outerArc);
        g.setColor(Color.BLACK);
        g.draw(outerArc);

        g.setColor(Color.WHITE);
        g.fill(innerArc);
        g.setColor(Color.BLACK);
        g.draw(innerArc);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        if (!(roomElement instanceof Toilet)) {
            return false;
        }

        Rectangle bounds = getBound(roomElement);
        return bounds.contains(pos);
    }

    @Override
    public Rectangle getBound(RoomElement roomElement) {
        if (!(roomElement instanceof Toilet)) {
            return null;
        }

        double x = toilet.getLocation().getX();
        double y = toilet.getLocation().getY();
        double widthEl = toilet.getDimension().getWidth();
        double heightEl = toilet.getDimension().getHeight();

        return new Rectangle((int) x, (int) y, (int) widthEl, (int) heightEl);
    }

    @Override
    public void setSelected(RoomElement roomElement, boolean isSelected) {
        if (roomElement instanceof Toilet) {
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
        return toilet;
    }

    public Toilet getToilet() {
        return toilet;
    }

    public void setToilet(Toilet toilet) {
        this.toilet = toilet;
    }
}
