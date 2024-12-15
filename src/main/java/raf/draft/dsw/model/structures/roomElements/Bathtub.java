package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Bathtub extends RoomElement{
    public Bathtub(String name) {
        super(name);
    }

    public Bathtub(String name, DraftNode parent) {
        super(name, parent);
    }

    public Bathtub(String name, Point2D location, Dimension2D dimension) {
        super(name, location, dimension);
    }

    @Override
    public Prototype clone() {
        Bathtub clonedBathTube = new Bathtub(this.getName(), this.getParent());

        clonedBathTube.setLocation(new Point((int) (this.getLocation().getX()+15), (int) (this.getLocation().getY()+15)));
        clonedBathTube.setDimension2((Dimension) this.getDimension());
        //clonedBed.setRotateRatio(this.getRotateRatio());

        return clonedBathTube;
    }
}
