package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Closet;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class ClosetPainter implements ElementPainter {

    private Closet closet;

    public ClosetPainter(Closet closet) {
        this.closet = closet;
    }


    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        double x = closet.getLocation().getX();
        double y = closet.getLocation().getY();
        double width = closet.getDimension().getWidth();
        double height = closet.getDimension().getHeight();

        GeneralPath rectangle = new GeneralPath();
        rectangle.moveTo(x, y);
        rectangle.lineTo(x + width, y);
        rectangle.lineTo(x + width, y + height);
        rectangle.lineTo(x, y + height);
        rectangle.closePath();

        double centerX = x + width / 2;

        g.setColor(Color.LIGHT_GRAY);
        g.fill(rectangle);
        g.setColor(Color.BLACK);
        g.draw(rectangle);

        g.drawLine((int) centerX, (int) y, (int) centerX, (int) (y + height));

        double handleWidth = 8;
        double handleY = y + height * 0.5;

        g.setColor(Color.BLACK);
        g.fillOval(
                (int)(centerX - width * 0.1 - handleWidth / 2),
                (int)(handleY - handleWidth / 2),
                (int)handleWidth,
                (int)handleWidth
        );

        g.fillOval(
                (int)(centerX + width * 0.1 - handleWidth / 2),
                (int)(handleY - handleWidth / 2),
                (int)handleWidth,
                (int)handleWidth
        );
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }

    public Closet getCloset() {
        return closet;
    }

    public void setCloset(Closet closet) {
        this.closet = closet;
    }
}
