package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.RoomElement;
import raf.draft.dsw.model.structures.roomElements.Sink;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class SinkPainter implements ElementPainter{
    private Sink sink;

    public SinkPainter(Sink sink) {
        this.sink = sink;
    }

    @Override
    public void paint(Graphics2D g, RoomElement roomElement) {
        GeneralPath triangle = new GeneralPath();

        double x = sink.getLocation().getX();
        double y = sink.getLocation().getY();
        double widthEl = sink.getDimension().getWidth();
        double heightEl = sink.getDimension().getHeight();

        double x1 = x + widthEl / 2;
        double y1 = y;
        double x2 = x;
        double y2 = y + heightEl;
        double x3 = x + widthEl;
        double y3 = y + heightEl;

        triangle.moveTo(x1, y1);
        triangle.lineTo(x2, y2);
        triangle.lineTo(x3, y3);
        triangle.closePath();

        // Rotacija oko centra trougla
        double centerX = x + widthEl / 2;
        double centerY = y + heightEl / 2;

        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.PI, centerX, centerY);

        triangle.transform(transform);

        g.setColor(Color.LIGHT_GRAY);
        g.fill(triangle);
        g.setColor(Color.BLACK);
        g.draw(triangle);

        double circleRadius = Math.min(widthEl, heightEl) * 0.1;
        double circleCenterX = x + widthEl / 2;
        double circleCenterY = y + heightEl / 2;

        Ellipse2D circle = new Ellipse2D.Double(circleCenterX - circleRadius, circleCenterY - circleRadius, circleRadius * 2, circleRadius * 2);

        g.setColor(Color.WHITE);
        g.fill(circle);
        g.setColor(Color.BLACK);
        g.draw(circle);
    }

    @Override
    public boolean elementAt(RoomElement roomElement, Point pos) {
        return false;
    }

    public Sink getSink() {
        return sink;
    }

    public void setSink(Sink sink) {
        this.sink = sink;
    }
}
