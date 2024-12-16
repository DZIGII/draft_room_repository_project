package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class BedPainter implements ElementPainter {

    private Bed bed;
    private boolean selected;
    private boolean overlap;

    public BedPainter(Bed bed) {
        this.bed = bed;
    }


    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        GeneralPath bedShape = new GeneralPath();

        double x = bed.getLocation().getX();
        double y = bed.getLocation().getY();
        double widthEl = bed.getDimension().getWidth();
        double heightEl = bed.getDimension().getHeight();

        bedShape.moveTo(x, y);
        bedShape.lineTo(x + widthEl, y);
        bedShape.lineTo(x + widthEl, y + heightEl);
        bedShape.lineTo(x, y + heightEl);
        bedShape.closePath();

        double pillowWidth = widthEl * 0.6;
        double pillowHeight = heightEl * 0.3;
        double pillowX = x + widthEl * 0.2;
        double pillowY = y + heightEl * 0.1;

        GeneralPath pillow = new GeneralPath();
        pillow.moveTo(pillowX, pillowY);
        pillow.lineTo(pillowX + pillowWidth, pillowY);
        pillow.lineTo(pillowX + pillowWidth, pillowY + pillowHeight);
        pillow.lineTo(pillowX, pillowY + pillowHeight);
        pillow.closePath();

        if (selected) {
            g.setColor(new Color(173, 216, 230));
        }
        else if (overlap) {
            g.setColor(Color.red);
            g.setColor(Color.red);
        }
        else {
            g.setColor(Color.BLACK);
            g.setColor(Color.LIGHT_GRAY);
        }

        g.fill(bedShape);
        g.draw(bedShape);

        g.setColor(Color.WHITE);
        g.fill(pillow);
        g.setColor(Color.BLACK);
        g.draw(pillow);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        if (!(roomElement instanceof Bed)) {
            return false;
        }

        Rectangle bounds = getBound(roomElement);
        return bounds.contains(pos);
    }

    @Override
    public Rectangle getBound(RoomElement roomElement) {
        if (!(roomElement instanceof Bed)) {
            return null;
        }

        double x = bed.getLocation().getX();
        double y = bed.getLocation().getY();
        double widthEl = bed.getDimension().getWidth();
        double heightEl = bed.getDimension().getHeight();

        return new Rectangle((int) x, (int) y, (int) widthEl, (int) heightEl);
    }

    @Override
    public void setSelected(RoomElement roomElement, boolean isSelected) {
        if (roomElement instanceof Bed) {
            this.selected = isSelected;
        }
    }


    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public void resetSelected() {
        selected = false;
    }

    @Override
    public RoomElement getElement() {
        return bed;
    }

    @Override
    public void setOverlap() {
        overlap = true;
    }

    @Override
    public void resetOverlap() {
        overlap = false;
    }

    public boolean isOverlap() {
        return overlap;
    }
}
