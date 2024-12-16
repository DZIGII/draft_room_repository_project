package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.ElementPainter;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;

public class MoveState implements State {

    private Point start = null;
    private Point elStart = null;
    private Point end = null;
    private ElementPainter element;

    @Override
    public void log() {
        System.out.println("Move State");
    }

    @Override
    public void paintElement(Point2D clickPoint, RoomView roomView) {

    }

    @Override
    public void mousePressed(MouseEvent e, RoomView roomView) {

        start = e.getPoint();
        for (ElementPainter elementPainter : roomView.getPainters()) {
            RoomElement roomElement = elementPainter.getElement();
            if (elementPainter.getBound(roomElement).contains(e.getPoint())) {
                element = elementPainter;
                elStart = (Point) element.getElement().getLocation();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, RoomView roomView) {
        if (element == null) {
            MainFrame.getInstance().getMessageGenerator().generateMessage("Click on element", "Information");
        }
        else {
            end = e.getPoint();
            Point newPoint = new Point(end.x - (start.x - elStart.x), end.y - (start.y - elStart.y));

            element.getElement().setLocation(newPoint);

            if (roomView.isOverbound(element) || roomView.isOverlap(element)) {
                element.setOverlap();
            }
            else {
                element.resetOverlap();
            }

            roomView.repaint();
        }
    }

    @Override
    public void mouseRelease(MouseEvent e, RoomView roomView) {
        end = e.getPoint();
        Point newPoint = new Point(end.x - (start.x - elStart.x), end.y - (start.y - elStart.y));
        element.getElement().setLocation(newPoint);
        if (roomView.isOverbound(element) || roomView.isOverlap(element)) {
            element.getElement().setLocation(elStart);
        }
        element.resetOverlap();
        roomView.repaint();
        element = null;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, RoomView roomView) {

    }

    @Override
    public void copy() {

    }


}
