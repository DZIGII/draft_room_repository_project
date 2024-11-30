package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Closet extends RoomElement {

    public Closet(String name) {
        super(name);
    }

    public Closet(String name, DraftNode parent) {
        super(name, parent);
    }


    @Override
    public Prototype clone() {
        Bed clonedCloset = new Bed(this.getName(), this.getParent());

        clonedCloset.setLocation((Point2D) this.getLocation().clone());
        clonedCloset.setDimension((Dimension2D) this.getDimension().clone());
        clonedCloset.setRotateRatio(this.getRotateRatio());

        return clonedCloset;
    }
}
