package raf.draft.dsw.controller.state;

import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;

public interface State {

    void log();

    void paintElement(Point2D clickPoint, RoomView roomView);

    void mousePressed(MouseEvent e, RoomView roomView);

    void mouseDragged(MouseEvent e, RoomView roomView);

    void mouseRelease(MouseEvent e, RoomView roomView);

    void mouseWheelMoved(MouseWheelEvent e, RoomView roomView);

    void copy();


}
