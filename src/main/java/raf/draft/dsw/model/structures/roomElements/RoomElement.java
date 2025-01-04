package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.Leaf;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public abstract class RoomElement extends Leaf implements Prototype {

    private Point2D location;
    private Dimension2D dimension;
    private int rotateRatio;

    public RoomElement(String name) {
        super(name);
    }

    public RoomElement(String name, DraftNode parent) {
        super(name, parent);
    }

    public RoomElement(String name, Point2D location, Dimension2D dimension) {
        super(name);
        this.location = location;
        this.dimension = dimension;
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

    public void setDimension(double width, double height) {
        this.dimension.setSize(width, height);
    }

    public void setDimension2(Dimension dimension) {
        this.dimension = dimension;
    }

    public int getRotateRatio() {
        return rotateRatio;
    }

    public void setRotateRatio(int rotateRatio) {
        this.rotateRatio = rotateRatio;
    }

    public abstract Prototype clone();

    @Override
    public String toString() {
        return getName() + " (" + dimension.getWidth() + " x " + dimension.getHeight() + ")";
    }
}
