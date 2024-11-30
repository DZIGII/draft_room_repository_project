package raf.draft.dsw.model.elements;

import raf.draft.dsw.model.structures.RoomElement;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Bed extends RoomElement {
    public Bed(Point2D location, Dimension2D dimension, double rotation) {
        super(location, dimension, rotation);
    }

    @Override
    public Prototype clone() {
        return new Bed(
                (Point2D) getLocation().clone(),
                (Dimension2D) getDimension().clone(),
                getRotation()
        );
    }
}
