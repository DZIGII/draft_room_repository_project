package raf.draft.dsw.model.elements;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public abstract class RoomElement implements Prototype {

    private Point2D location;
    private Dimension2D dimension;
    private double rotation;

    public RoomElement(Point2D location, Dimension2D dimension, double rotation) {
        this.location = location;
        this.dimension = dimension;
        this.rotation = rotation;
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }

    public Dimension2D getDimension() {
        return dimension;
    }

    public void setDimension(Dimension2D dimension) {
        this.dimension = dimension;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
