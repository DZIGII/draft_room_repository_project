package raf.draft.dsw.controller.state;

import java.awt.geom.Point2D;

public interface State {

    void log();

    void printBed(Point2D clickPoint, String elementType);


}
