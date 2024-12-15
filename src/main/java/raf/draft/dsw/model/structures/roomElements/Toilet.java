package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Toilet extends RoomElement {
    public Toilet(String name) {
        super(name);
    }

    public Toilet(String name, DraftNode parent) {
        super(name, parent);
    }

    public Toilet(String name, Point2D location, Dimension2D dimension) {
        super(name, location, dimension);
    }

    @Override
    public Prototype clone() {
        Toilet clonedToilet = new Toilet(this.getName(), this.getParent());

        clonedToilet.setLocation(new Point((int) (this.getLocation().getX()+15), (int) (this.getLocation().getY()+15)));
        clonedToilet.setDimension2((Dimension) this.getDimension());
        //clonedBed.setRotateRatio(this.getRotateRatio());

        return clonedToilet;
    }
}
