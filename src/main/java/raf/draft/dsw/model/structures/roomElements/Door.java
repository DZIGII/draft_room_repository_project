package raf.draft.dsw.model.structures.roomElements;

import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Prototype;
import raf.draft.dsw.model.structures.Room;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Door extends RoomElement {

    public Door(String name) {
        super(name);
    }

    public Door(String name, DraftNode parent) {
        super(name, parent);
    }

    public Door(String name, Point2D location, Dimension2D dimension) {
        super(name, location, dimension);
    }

    @Override
    public Prototype clone() {
        Door clonedBed = new Door(this.getName(), this.getParent());


        clonedBed.setLocation(new Point((int) (this.getLocation().getX()+15), (int) (this.getLocation().getY()+15)));
        clonedBed.setDimension2((Dimension) this.getDimension());
        //clonedBed.setRotateRatio(this.getRotateRatio());

        return clonedBed;
    }


}
