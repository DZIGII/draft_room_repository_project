package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Boiler extends RoomElement {
    public Boiler(String name) {
        super(name);
    }

    public Boiler(String name, DraftNode parent) {
        super(name, parent);
    }

    public Boiler(String name, Point2D location, Dimension2D dimension) {
        super(name, location, dimension);
    }

    @Override
    public Prototype clone() {
        Boiler clonedBoiler = new Boiler(this.getName(), this.getParent());

        clonedBoiler.setLocation(new Point((int) (this.getLocation().getX()+15), (int) (this.getLocation().getY()+15)));
        clonedBoiler.setDimension2((Dimension) this.getDimension());
        //clonedBed.setRotateRatio(this.getRotateRatio());

        return clonedBoiler;
    }
}
