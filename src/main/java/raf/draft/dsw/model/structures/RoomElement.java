package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.Leaf;

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

    public int getRotateRatio() {
        return rotateRatio;
    }

    public void setRotateRatio(int rotateRatio) {
        this.rotateRatio = rotateRatio;
    }

    public abstract Prototype clone();
}
