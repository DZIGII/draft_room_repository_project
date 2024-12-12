package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;

public class BathtubPainter implements ElementPainter{
    private Bathtub bathtub;

    public BathtubPainter(Bathtub bathtub) {
        this.bathtub = bathtub;
    }


    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = bathtub.getLocation().getX();
        double y = bathtub.getLocation().getY();
        double width = bathtub.getDimension().getWidth();
        double height = bathtub.getDimension().getHeight();

        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, (int) width, (int) height);

        double ovalX = x + width * 0.1;
        double ovalY = y + height * 0.1;
        double ovalWidth = width * 0.8;
        double ovalHeight = height * 0.8;

        g.setColor(Color.WHITE);
        g.fillOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
        g.setColor(Color.BLACK);
        g.drawOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }

    public Bathtub getBathtub() {
        return bathtub;
    }

    public void setBathtub(Bathtub bathtub) {
        this.bathtub = bathtub;
    }
}
