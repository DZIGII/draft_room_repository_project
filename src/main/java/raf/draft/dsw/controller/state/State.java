package raf.draft.dsw.controller.state;

import raf.draft.dsw.gui.swing.RoomView;

import java.awt.geom.Point2D;

public interface State {

    void log();

    void paintElement(Point2D clickPoint, RoomView roomView);


}
