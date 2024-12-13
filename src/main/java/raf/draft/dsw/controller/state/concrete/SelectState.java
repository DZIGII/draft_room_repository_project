package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.geom.Point2D;

public class SelectState implements State {

    @Override
    public void log() {
        System.out.println("Select state");
    }

    @Override
    public void paintElement(Point2D clickPoint, RoomView roomView) {

    }

    public void selectElements() {

    }

}
