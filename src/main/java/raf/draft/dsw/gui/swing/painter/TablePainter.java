package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class TablePainter implements Painter {

    private Table table;

    public TablePainter(Table table) {
        this.table = table;
    }


    @Override
    public void paint(Graphics2D g, Object object, int width, int height) {

    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
