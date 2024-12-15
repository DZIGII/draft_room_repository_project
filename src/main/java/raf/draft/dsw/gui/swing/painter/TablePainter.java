package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.RoomElement;
import raf.draft.dsw.model.structures.roomElements.Sink;
import raf.draft.dsw.model.structures.roomElements.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class TablePainter implements ElementPainter {

    private Table table;
    private boolean selected;

    public TablePainter(Table table) {
        this.table = table;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = table.getLocation().getX();
        double y = table.getLocation().getY();
        double widthEl = table.getDimension().getWidth();
        double heightEl = table.getDimension().getHeight();

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, widthEl, heightEl);

        double circleRadius = Math.min(widthEl, heightEl) * 0.05;

        double[][] circleCenters = {
                {x + circleRadius, y + circleRadius},
                {x + widthEl - circleRadius, y + circleRadius},
                {x + circleRadius, y + heightEl - circleRadius},
                {x + widthEl - circleRadius, y + heightEl - circleRadius}
        };

        Color fillColor = selected ? new Color(173, 216, 230) : Color.LIGHT_GRAY;

        g.setColor(fillColor);
        g.fill(rectangle);
        g.setColor(Color.BLACK);
        g.draw(rectangle);

        for (double[] center : circleCenters) {
            Ellipse2D circle = new Ellipse2D.Double(
                    center[0] - circleRadius,
                    center[1] - circleRadius,
                    circleRadius * 2,
                    circleRadius * 2
            );
            g.setColor(Color.WHITE);
            g.fill(circle);
            g.setColor(Color.BLACK);
            g.draw(circle);
        }
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        if (!(roomElement instanceof Table)) {
            return false;
        }

        Rectangle bounds = getBound(roomElement);
        return bounds.contains(pos);
    }

    @Override
    public Rectangle getBound(RoomElement roomElement) {
        if (!(roomElement instanceof Table)) {
            return null;
        }

        double x = table.getLocation().getX();
        double y = table.getLocation().getY();
        double widthEl = table.getDimension().getWidth();
        double heightEl = table.getDimension().getHeight();

        return new Rectangle((int) x, (int) y, (int) widthEl, (int) heightEl);
    }

    @Override
    public void setSelected(RoomElement roomElement, boolean isSelected) {
        if (roomElement instanceof Table) {
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
        return table;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
