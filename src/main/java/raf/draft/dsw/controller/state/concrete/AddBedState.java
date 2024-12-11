package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.ElementDimensionFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BedPainter;
import raf.draft.dsw.model.structures.roomElements.Bed;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddBedState implements State {
    @Override
    public void log() {

    }

    @Override
    public void printBed(Point2D clickPoint, RoomView roomView) {

        //ElementDimensionFrame elementDimensionFrame = new ElementDimensionFrame();
        //elementDimensionFrame.setVisible(true);

        Dimension2D d = new Dimension();
        Bed bed = new Bed("Bed", clickPoint, d);

        bed.setLocation(clickPoint);
        bed.setDimension(20, 20);
        BedPainter bedPainter = new BedPainter(bed);

        roomView.addElement(bedPainter);
        roomView.repaint();
    }

    public void misKliknut(RoomView roomView, MouseEvent e) {

    }

}
