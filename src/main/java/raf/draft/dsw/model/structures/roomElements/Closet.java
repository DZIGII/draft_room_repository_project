package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.*;
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
        Closet clonedCloset = new Closet(this.getName(), this.getParent());

        clonedCloset.setLocation(new Point((int) (this.getLocation().getX()+15), (int) (this.getLocation().getY()+15)));
        clonedCloset.setDimension2((Dimension) this.getDimension());
        //clonedBed.setRotateRatio(this.getRotateRatio());

        return clonedCloset;
    }
}
