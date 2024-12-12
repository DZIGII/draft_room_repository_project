package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Closet extends RoomElement {

    public Closet(String name) {
        super(name);
    }

    public Closet(String name, DraftNode parent) {
        super(name, parent);
    }

    public Closet(String name, Point2D location, Dimension2D dimension) {
        super(name, location, dimension);
    }

    @Override
    public Prototype clone() {
        return null;
    }
}
