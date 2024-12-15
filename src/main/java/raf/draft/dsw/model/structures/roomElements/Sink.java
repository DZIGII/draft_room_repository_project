package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Sink extends RoomElement {
    public Sink(String name) {
        super(name);
    }

    public Sink(String name, DraftNode parent) {
        super(name, parent);
    }

    public Sink(String name, Point2D location, Dimension2D dimension) {
        super(name, location, dimension);
    }

    @Override
    public Prototype clone() {
        Sink clonedSink = new Sink(this.getName(), this.getParent());

        clonedSink.setLocation(new Point((int) (this.getLocation().getX()+15), (int) (this.getLocation().getY()+15)));
        clonedSink.setDimension2((Dimension) this.getDimension());
        //clonedBed.setRotateRatio(this.getRotateRatio());

        return clonedSink;
    }


}
