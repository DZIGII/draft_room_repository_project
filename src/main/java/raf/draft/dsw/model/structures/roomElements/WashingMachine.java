package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class WashingMachine extends RoomElement {
    public WashingMachine(String name) {
        super(name);
    }

    public WashingMachine(String name, DraftNode parent) {
        super(name, parent);
    }

    public WashingMachine(String name, Point2D location, Dimension2D dimension) {
        super(name, location, dimension);
    }

    @Override
    public Prototype clone() {
        return null;
    }
}
