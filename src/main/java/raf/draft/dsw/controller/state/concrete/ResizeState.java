package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.geom.Point2D;

public class ResizeState implements State {

    @Override
    public void log() {
        System.out.println("Resize State");
    }

    @Override
    public void printBed(Point2D clickPoint, RoomView roomView) {

    }

}
