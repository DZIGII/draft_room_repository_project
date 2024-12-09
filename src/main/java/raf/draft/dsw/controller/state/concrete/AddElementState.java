package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.ElementDimensionFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BedPainter;
import raf.draft.dsw.model.structures.roomElements.Bed;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddElementState implements State {


    @Override
    public void log() {
        System.out.println("Add state");
    }

    @Override
    public void printBed(Point2D clickPoint, String elementType) {
        if ("Bed".equals(elementType)) {
            Dimension2D d = new Dimension();
            Bed bed = new Bed("Bed", clickPoint, d);

            bed.setLocation(clickPoint);
            bed.setDimension(50, 100);
            BedPainter bedPainter = new BedPainter(bed);

            RoomView roomView = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
            roomView.addElement(bedPainter);
            roomView.repaint();
        }

    }


}
