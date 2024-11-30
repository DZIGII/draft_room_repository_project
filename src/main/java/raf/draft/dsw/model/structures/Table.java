package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Table extends RoomElement {

    public Table(String name) {
        super(name);
    }

    public Table(String name, DraftNode parent) {
        super(name, parent);
    }

    @Override
    public Prototype clone() {
        Table clonedTable = new Table(this.getName(), this.getParent());

        clonedTable.setLocation((Point2D) this.getLocation().clone());
        clonedTable.setDimension((Dimension2D) this.getDimension().clone());
        clonedTable.setRotateRatio(this.getRotateRatio());

        return clonedTable;
    }
}
