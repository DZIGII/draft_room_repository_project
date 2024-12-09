package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Bed extends RoomElement {


    public Bed(String name) {
        super(name);
    }

    public Bed(String name, DraftNode parent) {
        super(name, parent);
    }


    @Override
    public Prototype clone() {
        Bed clonedBed = new Bed(this.getName(), this.getParent());

        clonedBed.setLocation((Point2D) this.getLocation().clone());
        //clonedBed.setDimension((Dimension2D) this.getDimension().clone());
        clonedBed.setRotateRatio(this.getRotateRatio());

        return clonedBed;
    }
}
