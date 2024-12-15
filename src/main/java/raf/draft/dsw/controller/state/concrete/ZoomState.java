package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;

public class ZoomState implements State {

    @Override
    public void log() {
        System.out.println("Zoom State");
    }

    @Override
    public void paintElement(Point2D clickPoint, RoomView roomView) {

    }

    @Override
    public void mousePressed(MouseEvent e, RoomView roomView) {

    }

    @Override
    public void mouseDragged(MouseEvent e, RoomView roomView) {

    }

    @Override
    public void mouseRelease(MouseEvent e, RoomView roomView) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, RoomView roomView) {

    }

}
