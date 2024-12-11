package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class BedPainter implements ElementPainter {

    public Bed bed;

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

        g.setColor(Color.LIGHT_GRAY);
        g.fill(bedShape);
        g.setColor(Color.BLACK);
        g.draw(bedShape);

        g.setColor(Color.WHITE);
        g.fill(pillow);
        g.setColor(Color.BLACK);
        g.draw(pillow);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }


    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
