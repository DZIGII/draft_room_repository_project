package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;

public class BathtubPainter implements ElementPainter{
    private Bathtub bathtub;
    private boolean selected;
    private boolean overlap;

    public BathtubPainter(Bathtub bathtub) {
        this.bathtub = bathtub;
    }


    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = bathtub.getLocation().getX();
        double y = bathtub.getLocation().getY();
        double width = bathtub.getDimension().getWidth();
        double height = bathtub.getDimension().getHeight();

        Color fillColor = Color.WHITE;

        if (selected) {
            fillColor = new Color(173, 216, 230);
        }
        if (overlap) {
            fillColor = Color.red;
            g.setColor(Color.red);
            g.setColor(Color.red);
        }
        else {
            g.setColor(Color.BLACK);
            g.setColor(Color.GRAY);
        }

        g.drawRect((int) x, (int) y, (int) width, (int) height);
        g.fillRect((int) x, (int) y, (int) width, (int) height);

        double ovalX = x + width * 0.1;
        double ovalY = y + height * 0.1;
        double ovalWidth = width * 0.8;
        double ovalHeight = height * 0.8;

        g.setColor(fillColor);
        g.fillOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
        g.setColor(Color.BLACK);
        g.drawOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        if (!(roomElement instanceof Bathtub)) {
            return false;
        }

        Rectangle bounds = getBound(roomElement);
        return bounds.contains(pos);
    }

    @Override
    public Rectangle getBound(RoomElement roomElement) {
        if (!(roomElement instanceof Bathtub)) {
            return null;
        }

        double x = bathtub.getLocation().getX();
        double y = bathtub.getLocation().getY();
        double widthEl = bathtub.getDimension().getWidth();
        double heightEl = bathtub.getDimension().getHeight();

        return new Rectangle((int) x, (int) y, (int) widthEl, (int) heightEl);
    }

    @Override
    public void setSelected(RoomElement roomElement, boolean isSelected) {
        if (roomElement instanceof Bathtub) {
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
        return bathtub;
    }

    @Override
    public void setOverlap() {
        overlap = true;
    }

    @Override
    public void resetOverlap() {
        overlap = false;
    }

    public Bathtub getBathtub() {
        return bathtub;
    }

    public void setBathtub(Bathtub bathtub) {
        this.bathtub = bathtub;
    }

    public boolean isOverlap() {
        return overlap;
    }
}
